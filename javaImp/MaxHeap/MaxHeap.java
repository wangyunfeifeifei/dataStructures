package javaImp.MaxHeap;

import javaImp.Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    /**
     * 参数为数组的构造函数， 使数组堆化
     *
     * @param array
     */
    public MaxHeap(E[] array) {
        data = new Array<>(array);

        // heapify
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 参数为容量的构造函数
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
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
     *
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
     * 返回堆中最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Cannot findMax when heap is empty");
        }
        return data.get(0);
    }

    /**
     * 删除堆中最大值
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.pop();
        siftDown(0);
        return ret;
    }

    /**
     * index位置元素下沉操作
     *
     * @param index
     */
    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            // 找左右孩子的最大值
            int i = leftChild(index);
            if (i + 1 < data.getSize() && data.get(i).compareTo(data.get(i + 1)) < 0) {
                i = rightChild(index);
            }

            if (data.get(index).compareTo(data.get(i)) >= 0) {
                break;
            } else {
                data.swap(i, index);
                index = i;
            }
        }

    }

    /**
     * 取出堆中最大元素， 并插入元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
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
