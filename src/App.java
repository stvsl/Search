public class App {
    public static void main(String[] args) throws Exception {
        searchInsideTest();
        searchLoadTest();
    }

    private static void searchLoadTest() {
        println("配置模式测试 \n普通查找");
        Search s = new Search();
        SeqList seq = new SeqList(new int[]{1,2,3,4,5,6,7,8});
        println(s.search(seq, 6));
        println("二分法查找");
        println(s.binarySearch(seq, 6, true));
        println("线性探测哈希表构造");
        s.buildLinearHash(seq);
        s.printSeqHash();
        println("查找元素");
        println(s.LinearHashSearch(6));
        println("链式哈希表构建");
        s.buildLinkedHash(seq);
        println(s.LInkedHashSearch(6));
    }

    //手动构造测试
    public static void searchInsideTest(){
        Search s = new Search();
        s.buildSeqList(new int[] { 1, 2, 3, 4, 5, 6, 7});
        println("手动构造测试 \n 普通查找：");
        println(s.search(2));
        println("二分法查找模式");
        println(s.binarySearch(3, true));
        println("线性探测哈希表构建");
        s.buildLinearHash();
        println("当前表内元素状态：");
        s.printSeqHash();
        println("搜索：");
        println(s.LinearHashSearch(7));
        println("链式哈希表构建：");
        s.buildLinkedHash();
        println("查找元素：");
        println(s.LInkedHashSearch(7));
    }

    public static void println(Object msg){
        System.out.println(msg);
    }
}
