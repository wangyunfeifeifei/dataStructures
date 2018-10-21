package javaImp.MaxHeap;

import javaImp.Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 返回堆中有多少元素
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e) {
        data.append(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 看index位置的元素是否能上浮
     *
     * @param index
     */
    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    /**
     * 返回父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index - 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回左孩子的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回右孩子的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
