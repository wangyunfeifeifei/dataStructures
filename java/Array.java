package java;

public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数， 传入数组的容量capacity构造Array
     * @param capacity int 容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判定数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组追加元素
     * @param e 追加的元素
     */
    public void append(int e) {
        add(size, e);
    }

    /**
     * 添加第一个元素
     * @param e
     */
    public void shift(int e) {
        add(0, e);
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     */
    public void add (int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed. Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Require index >= 0 and index <= size");
        }
        for(int i = size - 1; i >= index; i-- ) {
            data[i+1] = data[i];
        }
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
