package javaImp.Map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private Node<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取节点
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * 删除元素
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {

        Node prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.key .equals(key)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return (V) delNode.value;
        }
        return null;
    }

    /**
     * 是否包含某元素
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : (V) node.value;
    }

    /**
     * 修改元素
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        node .value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
