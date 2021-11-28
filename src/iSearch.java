/****************************************************************
     * 注意：
     * 1.   此查找拥有配置模式和内置模式，配置模式下使用附带的一个简易线性表（固定长度，无增删改的相关实现，
     *      但拥有一个自动构造造函数，可快速生成具有顺序的线性表）
     * 2.   若不想使用内置线性表，你也可以使用自己的线性表，只需要使用你的替换SeqList即可，但请保证你的线性表中有以下函数：
     *          int size();
     *          T get();（仅支持最基本的单一查找）
     *      为了能够对内部元素并非基本数据类型进行搜索，请保证有 int compare(int a,int key) 函数，保证可正常运行
     * 3.   算法功能中并没有内置包含链表的相关操作
     * 4.   未提供类型的比较，如需支持类型请自行修改（已对其进行优化使之支持一定能力的类型（固定类型））
     *      如需支持类型请先确保对象支持以下函数：
     *          为了能够对内部元素并非基本数据类型进行搜索，请保证有 int compareTo(Object a,Object b) 函数，保证可正常运行
     *          若需要使用二分查找和哈希，请确保对象拥有索引特性，并将特性暴露到int getIndex(int x)函数中
     * 5.   内置模式：
     *      如果你觉得1里面写的那种太麻烦了，那么你可以使用search内置的无对象传入版本，其内置线性表（需要使用的话请先对其进行构造）
     *      （仅支持可比较的基本类型（系统提供int）可使用且需要根据实际情况去进行修改，当然，你也可以更改使其支持高级类型）
     * 6.   所有函数均使用动态模式！！！请勿使用静态模式
     * 7.   系统内封装了链式哈希所需要的结点类
     * 8.   代码已进入github仓库与gitee仓库（gitee自动同步github）
     *      github地址：https://github.com/stvsl/Search.git
     *      gitee地址：https://gitee.com/stvsl/Search.git
     *                                                 @author stvsl
     *                                                 @date 2021.11.28
     ****************************************************************/
public interface iSearch {
    /***
     * 普通模式
     * 返回查找元素所在位置
     * 内置模式
     * 
     * @param key
     *             查询的元素
     ***/
    int search(int key);
    /***
     * 普通模式
     * 返回查找元素所在位置
     * 配置模式
     * 
     * @param key
     *             查询的元素
     * @param list
     *             线性表传入
     ***/
    int search(SeqList list, int key);

    /***
     * 普通模式
     * 返回查找元素所在位置（二分法）
     * 内置模式
     * 
     * @param key
     *             查询的元素
     * @param high
     *             升降序 true为升序模式，false为降序模式
     ***/
    int binarySearch(int key, boolean high);
    /***
     * 普通模式
     * 返回查找元素所在位置（二分法）
     * 配置模式
     * 
     * @param key
     *             查询的元素
     * @param high
     *             升降序 true为升序模式，false为降序模式
     * @param list
     *             线性表传入
     ***/
    int binarySearch(SeqList list, int key, boolean high);

    /***
     * 哈希模式
     * 获取相关元素的哈希值
     * 内置模式
     * @param  i
     *             元素位置
     * @param list
     *             顺序表位置
     ***/
    int hash(int i);
    /***
     * 哈希模式
     * 获取相关元素的哈希值
     * 配置模式
     * @param  i
     *             元素位置
     * @param list
     *             顺序表位置
     * @param list
     *             线性表传入
     ***/
    int hash(SeqList list,int i);

    /***
     * 哈希模式
     * 线性探测模式哈希表生成
     * 配置模式
     * @param list
     *          线性表传入
     ***/
    void buildLinearHash(SeqList list);
    /***
     * 哈希模式
     * 线性探测模式哈希表生成
     * 内置模式
     ***/
    void buildLinearHash();

    /***
     * 哈希模式
     * 线性探测模式哈希表查找
     * 内置模式
     * @param key
     *          查找的元素值
     */
    int LinearHashSearch(int key);

    /***
     * 哈希模式
     * 链式模式哈希表生成
     * 配置模式
     *  @param list
     *          顺序表位置
     *          请在使用配置模式时使用有参，内置模式下请使用无参
     ***/
    void buildLinkedHash(SeqList list);
    /***
     * 哈希模式
     * 链式模式哈希表生成
     * 内置模式
     ***/
    void buildLinkedHash();

    /***
     * 哈希模式
     * 链式模式哈希表查找
     * 双兼容模式
     * @param key
     *          查找的元素值
     */
    int LInkedHashSearch(int key);
}
