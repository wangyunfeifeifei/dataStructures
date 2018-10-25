package javaImp.SegmentTree;

public interface Merger<E> {
    /**
     * 合并两元素
     *
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
