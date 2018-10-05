package javaImp.BST;

public class BST_MAIN {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        System.out.println("==========前序遍历============");
        bst.preOrder(); // 前序遍历

        bst.preOrder(node -> {
            System.out.println("node: " + node.e);
        });

        System.out.println(bst); // 检验toString()方法

        System.out.println("==========中序遍历============");
        bst.inOrder();
        bst.inOrder(node -> {
            System.out.println("node: " + node.e);
        });

        System.out.println("==========后序遍历============");
        bst.postOrder();
        bst.postOrder(node -> {
            System.out.println("node: " + node.e);
        });
    }
}
