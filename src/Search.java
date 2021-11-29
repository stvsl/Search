class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

public class Search implements iSearch {

    //内置线性表
    int[] elements = null;
    
    //哈希素数状态
    boolean primeOK = false;
    //哈希素数值
    int prime = 1; 

    //顺序哈希数组
    int[] Seqhash = null;

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

    @Override
    public int hash(SeqList list, int i) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void buildLinearHash(SeqList list) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void buildLinearHash() {
        int size = elements.length>this.prime?this.elements.length*2:(int)((2 *this.prime - elements.length)/1.2);
        Seqhash = new int[size];
        for(int i = 0; i < elements.length; i++){
            int p = hash(i);

        }
    }

    @Override
    public int LinearHashSearch(int key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void buildLinkedHash(SeqList list) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void buildLinkedHash() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int LInkedHashSearch(int key) {
        // TODO Auto-generated method stub
        return 0;
    }

}