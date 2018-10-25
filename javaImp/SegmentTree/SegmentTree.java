package javaImp.SegmentTree;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
    }

    /**
     * 返回数据大小
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 返回指定index的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    /**
     * 返回左孩子索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回右孩子索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
