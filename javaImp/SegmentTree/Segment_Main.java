package javaImp.SegmentTree;

public class Segment_Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> {
            return a+b;
        });
        System.out.println(segmentTree);
    }
}
