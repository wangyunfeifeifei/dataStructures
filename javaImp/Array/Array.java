package javaImp.Array;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数， 传入数组的容量capacity构造Array
     * @param capacity int 容量
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
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
    public void append(E e) {
        add(size, e);
    }

    /**
     * 添加第一个元素
     * @param e
     */
    public void unshift(E e) {
        add(0, e);
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     */
    public void add (int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i-- ) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取index索引位置的元素
     * @param index 索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    /**
     * 返回最后一个元素
     * @return
     */
    public E getLast() {
        return get(size-1);
    }

    /**
     * 返回第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素
     * @param index 索引
     * @param e 修改的元素
     * @return
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("SET failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e的索引， 如果不存在返回-1
     * @param e
     * @return
     */
    public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
    }

    /**
     * 删除一个元素
     * @param index 删除元素的索引
     * @return 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove falied. Index is illegalArgumentException");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;

        if(size <= data.length / 2) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除第一个元素
     * @return 删除的元素
     */
    public E shift() {
        return remove(0);
    }

    /**
     * 查看是否有某个元素，如果有，删除该元素
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    /**
     * 删除最后一个元素
     * @return 删除的元素
     */
    public E pop() {
        return remove(size - 1);
    }

    /**
     * 数组扩容
     */
    private void resize(int newCap) {
        E[] newData = (E[])new Object[newCap];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
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
