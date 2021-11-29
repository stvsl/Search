public class App {
    public static void main(String[] args) throws Exception {
        searchInsideTest();
    }

    //手动构造测试
    public static void searchInsideTest(){
        Search s = new Search();
        s.buildSeqList(new int[] { 1, 2, 3, 4, 5, 6});
        println("手动构造测试 \n 普通查找：");
        println(s.search(2));
        println("二分法查找模式");
        println(s.binarySearch(3, true));
        
        println(s.hash(5));
    }

    public static void println(Object msg){
        System.out.println(msg);
    }
}
