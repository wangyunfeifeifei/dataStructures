package javaImp.BST;

public class BST<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 二分搜索树元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的节点插入元素e
     *
     * @param node
     * @param e
     */
    private Node add(Node<E> node, E e) {

        if(node == null) {
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看二分搜索树是否包含某元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以node为节点的二分搜索树是否包含e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node<E> node, E e) {

        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(node -> {
            System.out.println(node.e);
        });
    }

    /**
     * 以回调函数的形式前序遍历
     * @param t
     */
    public void preOrder(TraverseCallback t) {
        preOrder(root, t);
    }

    /**
     * 以Node为根的二分搜索树的前序遍历
     * @param node
     */
    private void preOrder(Node node, TraverseCallback t) {
        if(node == null) {
            return;
        }

        t.doing(node);
        preOrder(node.left, t);
        preOrder(node.right, t);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder((node) -> {
            System.out.println(node);
        });
    }

    /**
     * 中序遍历回调实现
     * @param t
     */
    public void inOrder(TraverseCallback t) {
        inOrder(root, t);
    }

    /**
     * 中序遍历具体实现
     * @param node
     * @param t
     */
    private void inOrder(Node node, TraverseCallback t) {
        if(node == null) {
            return;
        }
        inOrder(node.left,t );
        t.doing(node);
        inOrder(node.right, t);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder((node)->{
            System.out.println(node);
        });
    }

    /**
     * 后序遍历回调
     * @param t
     */
    public void postOrder(TraverseCallback t) {
        postOrder(root, t);
    }

    /**
     * 后序遍历具体实现
     * @param node
     * @param t
     */
    private void postOrder(Node node, TraverseCallback t) {
        if(node == null) {
            return;
        }

        postOrder(node.left, t);
        postOrder(node.right, t);
        t.doing(node);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成二分搜索树树形结构的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * 根据二叉树深度生成层次性的字符
     * @param depth
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i =0; i<depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
