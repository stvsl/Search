public class SeqList <T>{
    Object [] elements;
    int size;
    int MIN_SIZE = 8;
    
    SeqList() {
        elements = new Object[MIN_SIZE];
    }
    
    SeqList(int size) {
        if (size < MIN_SIZE) {
            size = MIN_SIZE;
        }
        elements = new Object[size];
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
    void autoBuildH(int size,int base,int noise,int diff) {
        if(this.size != 0){
            System.out.println("自动构造失败：顺序表非空");
        }
        elements[0] = (int)Math.random()*base + Math.random() *noise;
        for(int i = 1; i < size; i++){
            elements[i] = (int)elements[i-1] + Math.random()*noise * diff *noise/10;
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
    void autoBuildL(int size,int base,int noise,int diff){
        if(this.size != 0){
            System.out.println("自动构造失败：顺序表非空");
        }
        elements[0] = (int)Math.random()*base + Math.random() *noise;
        for(int i = 1; i < size; i++){
            elements[i] = (int)elements[i-1] - Math.random()*noise * diff *noise/10;
        }
    }
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    T get(int i){
        return (T)elements[i];
    }
}
