package javaImp.BST;

public interface TraverseCallback<E extends Comparable<E>> {
    public void doing(Node<E> node);
}
