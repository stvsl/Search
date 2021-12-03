class Node{
    Map data;
    Node next;

    Node(Map data, Node next){
        this.data = data;
        this.next = next;
    }
}

class Map{
    int data;
    int i;

    Map(int data, int i){
        this.data = data;
        this.i = i;

    }
}

public class Search implements iSearch {

    /***
     * 内置模式使用的数据存储器，默认为int
     ***/
    int[] elements = null;
    
    /***
     * 哈希素数状态
     * 用于判断当前是否获取到了用于计算的特征值
     ***/
    boolean primeOK = false;
    /***
     * 哈希素数值
     * 用于计算特征值的参数
     ***/
    int prime = 1; 

    /***
     * 线性探测哈希表使用的存储数组
     ***/
    Map[] Seqhash = null;

    /***
     * 链式哈希表使用的存储数组
     ***/
    Node[] linkhash = null;

    public void buildSeqList(int[] data){
        this.elements = data;
    }

    /***
     * 升序自动构造函数
     * @param size
     *          构造范围
     * @param base
     *          基准值
     * @param noise
     *          噪音大小
     * @param diff
     *          梯度
    ***/
    public void autoBuildSeqListH(int size,int base,int noise,int diff){
        this.elements = new int[size];
        elements[0] = (int)(Math.random()*base + Math.random() *noise);
        for(int i = 1; i < size; i++){
            elements[i] = (int)(elements[i-1] + Math.random()*noise * diff *noise/10);
        }
    }
    /***
     * 降序自动构造函数
     * @param size
     *          构造范围
     * @param base
     *          基准值
     * @param noise
     *          噪音大小
     * @param diff
     *          梯度
    ***/
    public void autoBuildSeqListL(int size,int base,int noise,int diff){
        this.elements = new int[size];
        elements[0] = (int)(Math.random()*base + Math.random() *noise);
        for(int i = 1; i < size; i++){
            elements[i] = (int)(elements[i-1] - Math.random()*noise * diff *noise/10);
        }
    }

    @Override
    public int search(int key) {
        int result = -1;
        for(int i = 0; i < elements.length; i++){
            if(this.elements[i] == key){
                result = i;
            }
        }
        return result;
    }

    @Override
    public int search(SeqList list, int key) {
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.compareTo(i, key) == 0) {
                result = i;
                break;
            }
        }
        return result;
    }


    @Override
    public int binarySearch(int key,boolean high) {
        return binarySearch(key, high,this.elements.length,0);
    }

    private int binarySearch(int key, boolean high,int h,int l) {
        int p = (int)((h + l) / 2);
        if(h == l){
            return -1;
        }
        if(this.elements[p] == key){
            return p;
        }else if(key > this.elements[p]){
            return binarySearch(key,high,h,p);
        }else{
            return binarySearch(key,high,p,l);
        }
    }

    @Override
    public int binarySearch(SeqList list, int key, boolean high) {
        return binarySearch(list, key, high, list.size(), 0);
    }

    //递归重载
    private int binarySearch(SeqList list, int key, boolean high,int h,int l){
        int p = (int)((h + l)/2);
        if(h == l){
            return -1;
        }
        if(list.get(p) == key){
            return p;
        }else if(list.get(p) > key){
            return binarySearch(list, key, high, p, l);
        }else{
            return binarySearch(list, key, high, h, p);
        }
    }

    private void getHashPrime(){
        //运算方法：最大素数
        //计算最大元素
        if(elements.length == 0){
            System.out.println("Empty!!!");
        }
        int max = elements[0];
        for(int j = 0; j < elements.length; j++) {
            if(max < elements[j]){
                max = elements[j];
            }
        }
        //保证可以计算负数
        max = (int)Math.sqrt(max *max);
        //求最大素数
        this.prime = max;
        while(prime != 0){
            boolean isprime = true;
            //判断当前prime值是不是素数
            for(int j = 2;j < prime;j++){
                if(prime % j == 0){
                    isprime = false;
                }
            }
            if(isprime){
                break;
            }
            prime --;
        }
        primeOK = true;
    }

    @Override
    public int hash(int i) {
        if(!primeOK){
            getHashPrime();
        }
        return elements[i] % this.prime;
    } 

    /***
     * 获取传入元素的哈希值
     ***/
     public int gethash(int x) {
        if(!primeOK){
            getHashPrime();
        }
        return x % this.prime;
    }

    @Override
    public int hash(SeqList list, int i) {
        if(!primeOK){
            getHashPrime(list);
        }
        return list.getIndex(i)%this.prime;
    }

    private void getHashPrime(SeqList list) {
        if(list.size() == 0){
            System.out.println("Empty!!!");
        }
        int max = list.get(0);
        for(int j = 0; j < list.size(); j++) {
            if(max < list.get(j)){
                max = list.get(j);
            }
        }
        max = (int)Math.sqrt(max *max);
        this.prime = max;
        while(prime != 0){
            boolean isprime = true;
            for(int j = 2;j < prime;j++){
                if(prime % j == 0){
                    isprime = false;
                }
            }
            if(isprime){
                break;
            }
            prime --;
        }
        primeOK = true;
    }

    @Override
    public double buildLinearHash(SeqList list) {
        getHashPrime(list);
        int size = (int) (list.size()>=this.prime?list.size()*1.2:prime + (prime - elements.length)/2);
        int sum = 0;
        Seqhash = new Map[size];
        for(int i=0;i < list.size(); i++){
            System.out.print("当前是第" + i + "轮\t" + "元素：" + list.get(i) + "\t");
            int p = hash(list,i);
            int offset = 0;
            while(Seqhash[p] != null){
                System.out.print("位置后移" + " " + p + " ");
                p = (++p)%Seqhash.length;
                offset ++;
            }
            sum += offset;
            System.out.println("存储位置：" + p);
            Seqhash[p] = new Map(list.get(i),i); 
            System.out.println("存储完毕");
        }
        return sum/list.size();
    }

    @Override
    public double buildLinearHash() {
        getHashPrime();
        int size = (int) (elements.length>=this.prime?this.elements.length*1.2:prime + (prime - elements.length)/2);
        int sum = 0;
        Seqhash = new Map[size];
        for(int i = 0; i < elements.length; i++){
            System.out.print("当前是第" + i + "轮\t" + "元素：" + elements[i] + "\t");
            int p = hash(i);
            int offset = 0;
            while(Seqhash[p] != null){
                System.out.print("位置后移" + " " + p + " ");
                p = (++p)%Seqhash.length;
                offset++;
            }
            sum += offset;
            System.out.println("存储位置：" + p);
            Seqhash[p] = new Map(elements[i],i);
        }
        System.out.println("存储完毕");
        return sum/elements.length;
    }

    @Override
    public int LinearHashSearch(int key) {
        int p = gethash(key);
        while(Seqhash[p].data != key) {
            p = (++p)%Seqhash.length;
        }
        return Seqhash[p].i;
    }

    /***
     * 调试用代码（输出当前线性探测哈希表内部状态）
    ***/
    public void printSeqHash(){
        for(int i = 0;i < Seqhash.length;i++){
            System.out.print(Seqhash[i] + "\t");
        }
        System.out.println();
    }

    public void printLinkHash(){
        for (int i = 0;i < linkhash.length;i++){
            System.out.print("特征" + (1+i) + "：\t");
            Node p = linkhash[i];
            while(p != null){
                System.out.print(p.data + "\t");
                p = p.next;
            }
            System.out.println();
        }
    }

    @Override
    public void buildLinkedHash(SeqList list) {
        linkhash = new Node[this.prime];
        for(int i = 0;i < prime;i++){
            linkhash[i] = new Node(null, null);
        }
        for(int i = 0;i < list.size();i++){
            int p = gethash(list.getIndex(i));
            Node pos = this.linkhash[p];
            while(pos.next != null){
                pos = pos.next;
            }
            pos.data = new Map(list.get(i),i);
        }
    }

    @Override
    public void buildLinkedHash() {
        linkhash = new Node[this.prime];
        for(int i = 0; i < prime; i++){
            linkhash[i] = new Node(null,null);
        }
        for(int i = 0; i < elements.length; i++){
            int p = hash(i);
            Node pos = linkhash[p];
            while(pos.next != null){
                pos = pos.next;
            }
            pos.data = new Map(elements[i],i);
        }
    }

    @Override
    public int LInkedHashSearch(int key) {
        int p = gethash(key);
        Node pos = linkhash[p];
        while(pos.next != null){
            if(pos.data.data == key){
                break;
            }
        }
        return pos.data.i;
    }

    @Override
    public double getLinkAPL() {
        int sum = 0;
        int elenum = 0;
        for(int i = 0; i < linkhash.length; i++){
            Node pos = linkhash[i];
            int offset = 0;
            while(pos.next != null){
                pos = pos.next;
                offset++;
                elenum++;
                sum += offset;
            }
        }
        return sum/elenum;
    }
}