class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

public class Search implements iSearch {

    @Override
    public int search(int key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int search(SeqList list, int key) {
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.compareTo(i, key) == 0) {
                return result = i;
            }
        }
        return result;
    }

    @Override
    public int binarySearch(int key,boolean high) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public int binarySearch(SeqList list, int key, boolean high) {
        return binarySearch(list, key, high, list.size(), 0);
    }

    //重载
    private int binarySearch(SeqList list, int key, boolean high,int h,int l){
        int result = -1;
        return result;
    }

    @Override
    public int hash(int i) {
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        
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