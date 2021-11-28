/****************************************************************
     * 注意：
     * 1.   此查找拥有配置模式和内置模式，配置模式下使用附带的一个简易线性表（固定长度，无增删改的相关实现，但拥有一个自动构造造函数，可快速生成具有顺序的线性表）
     *      若不想使用内置线性表，你也可以使用自己的线性表，只需要使用你的替换SeqList即可，但请保证你的线性表中有以下函数：
     *          int size();
     *          T get();
     *      若内部元素并非基本数据类型，请保证有 int compare(int a,int b) 函数，保证可正常运行
     * 2.   算法功能中并没有内置包含链表的相关操作
     * 3.   排序内置模式：
     *      如果你觉得1里面写的那种太麻烦了，那么你可以使用searchInside内置的版本，此类中内置线性表（仅基本类型泛型可使用）
     * 4.   静态模式大多数查找可能无法使用，相关稳定性问题未测试，请勿使用静态模式
     * 5.   代码已进入github仓库与gitee仓库（gitee自动同步github）
     *      github地址：https://github.com/stvsl/Search.git
     *      gitee地址：https://gitee.com/stvsl/Search.git
     *                                                 @author stvsl
     *                                                 @date 2021.11.28
     ****************************************************************/
public interface iSearch<T> {
    /***
     * 普通模式
     * 返回查找元素所在位置
     * 
     * @param key
     *             查询的元素
     * @param high
     *             升降序 true为升序模式，false为降序模式
     ***/
    int search(T key, boolean high);

    /***
     * 普通模式
     * 返回查找元素所在位置（二分法）
     * 
     * @param key
     *             查询的元素
     * @param high
     *             升降序 true为升序模式，false为降序模式
     ***/
    int binarySearch(T key, boolean high);

    /***
     * 哈希模式
     * 获取相关元素的哈希值
     * 请在配置模式下使用双参数，内置模式下使用单参数
     * @param  i
     *             元素位置
     * @param list
     *             顺序表位置
     ***/
    int hash(int i);

    int hash(SeqList<T> list,int i);

    /***
     * 哈希模式
     * 线性探测模式哈希表生成
     * @param list
     *          请在使用配置模式时使用有参，内置模式下请使用无参
     ***/
    void buildLinearHash(SeqList<T> list);

    void buildLinearHash();

    /***
     * 哈希模式
     * 链式模式哈希表生成
     *  @param list
     *          顺序表位置
     *          请在使用配置模式时使用有参，内置模式下请使用无参
     ***/
    void buildLinkedHash(SeqList<T> list);

    void buildLinkedHash();

}
