package Lab.lab7.src;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author JiazhenZhao
 * 2024/2/21
 * 类说明： 使用 BST(Binary Search Tree) 来构建Map
 * TODO: 这里在判断 root 节点是否为空的时候选择使用了特判的方法
 *       其实可以使用哨兵节点来实现这种判断，可以极大简化
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    /**
     * BSTMap's Node class
     */
    private class Node {
        private K key;
        private V value;
        Node left_node;
        Node right_node;
        Node father_node;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left_node = null;
            this.right_node = null;
            father_node = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.left_node = null;
            this.right_node = null;
            father_node = null;
        }
    }

    /**
     * BSTMap's iterator class
     */
    private class BSTMapiterator<K> implements Iterator<K> {
        int current_size;
        K[] items;

        public BSTMapiterator(Set<K> set) {
            current_size = 0;
            items = set.toArray((K[]) new Object[0]);
        }

        @Override
        public boolean hasNext() {
            return current_size < size();
        }

        @Override
        public K next() {
            K returnItem = items[current_size];
            current_size += 1;
            return returnItem;
        }
    }

    Node root_node; // 比较 node 中的 key 值来进行排序
    int size;       // BST 的size 大小

    public BSTMap() {
        root_node = new Node();
        size = 0;
    }

    /***
     Insert a node to the BST.
     如果该值已经存在了，修改对应的 value 的值
     */
    public void BST_insert(Node node) {
        if (root_node.key == null) {
            root_node = node;
            size++;
            return;
        }
        Node tmp_node = root_node;
        while (tmp_node != null) {
            if (node.key.compareTo(tmp_node.key) == 0) {
                tmp_node.value = node.value;
                return;
            } else if (node.key.compareTo(tmp_node.key) > 0) {
                if (tmp_node.right_node == null) {
                    tmp_node.right_node = node;
                    node.father_node = tmp_node;
                    size++;
                    return;
                }
                tmp_node = tmp_node.right_node;
            } else {
                if (tmp_node.left_node == null) {
                    tmp_node.left_node = node;
                    node.father_node = tmp_node;
                    size++;
                    return;
                }
                tmp_node = tmp_node.left_node;
            }
        }
    }

    /**
     * 判断是否包含节点 node
     */
    public boolean BST_contain(Node node) {
        if (root_node == null || root_node.key == null)
            return false;
        Node tmp_node = root_node;
        while (tmp_node != null) {
            if (node.key.compareTo(tmp_node.key) == 0)
                return true;
            else if (node.key.compareTo(tmp_node.key) > 0) {
                if (tmp_node.right_node == null) {
                    return false;
                }
                tmp_node = tmp_node.right_node;
            } else {
                if (tmp_node.left_node == null) {
                    return false;
                }
                tmp_node = tmp_node.left_node;
            }
        }
        return false;
    }

    /**
     * 返回 node 对应的节点
     */
    public Node BST_get(Node node) {
        if (root_node == null || root_node.key == null)
            return null;
        Node tmp_node = root_node;
        while (tmp_node != null) {
            if (node.key.compareTo(tmp_node.key) == 0)
                return tmp_node;
            else if (node.key.compareTo(tmp_node.key) > 0) {
                if (tmp_node.right_node == null) {
                    return null;
                }
                tmp_node = tmp_node.right_node;
            } else {
                if (tmp_node.left_node == null) {
                    return null;
                }
                tmp_node = tmp_node.left_node;
            }
        }
        return null;
    }

    /**
     * 清楚所有的 map
     */
    public void BST_clear() {
        root_node = null; // Java 自带的垃圾回收器会自动回收所有的节点
        size = 0;
    }

    @Deprecated
    public Node compare(Node node) {
        Node tmp_node = root_node;
        while (tmp_node != null) {
            if (node.key.compareTo(tmp_node.key) == 0)
                return tmp_node;
            else if (node.key.compareTo(tmp_node.key) > 0) {
                if (tmp_node.right_node == null) {
                    tmp_node.right_node = node;
                    break;
                }
                tmp_node = tmp_node.right_node;
            } else {
                if (tmp_node.left_node == null) {
                    tmp_node.left_node = node;
                    break;
                }
                tmp_node = tmp_node.left_node;
            }
        }
        return null;
    }


    @Override
    public void put(K key, V value) {
        Node node = new Node(key, value);
        BST_insert(node);
    }

    @Override
    public V get(K key) {
        Node node = new Node();
        node.key = key;
        node = BST_get(node);
        return node == null ? null : node.value;
    }

    @Override
    public boolean containsKey(K key) {
        Node node = new Node();
        node.key = key;

        return BST_contain(node);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        BST_clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        if (root_node == null) {
            System.out.println("Current BSTMap is null !!!");
            return set;
        }
        Node tmp_node = root_node;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tmp_node);
        while (queue.size() != 0) {
            Node x = queue.remove();
            set.add(x.key);
            if (x.left_node != null)
                queue.add(x.left_node);
            if (x.right_node != null)
                queue.add(x.right_node);
        }
        return set;
    }

    /**
     * 使用 Hibbard 删除
     */
    @Override
    public V remove(K key) {
        Node n = new Node();
        n.key = key;
        Node node = BST_get(n);
        if (node == null)
            return null;
        V tmp = node.value;
        // no child
        if (node.right_node == null && node.left_node == null) {
            if (node == root_node) {
                root_node = null;
            } else {
                if (node.father_node.right_node == node)
                    node.father_node.right_node = null;
                else
                    node.father_node.left_node = null;
            }
        }
        // two child
        else if (node.right_node != null && node.left_node != null) {
            Node tmp_node = find_rightestNodeOnLeftSubtree(node.left_node);
            // 重置选中节点的父节点
            if (tmp_node.father_node.right_node == tmp_node) {
                if (tmp_node.left_node != null)
                    tmp_node.father_node.right_node = tmp_node.left_node;
                else
                    tmp_node.father_node.right_node = null;
            } else {
                if (tmp_node.right_node != null)
                    tmp_node.father_node.left_node = tmp_node.right_node;
                else
                    tmp_node.father_node.left_node = tmp_node.left_node;

            }
            // 重置删除节点的父节点.
            if (node.father_node != null) { // not root point.
                if (node.father_node.right_node == node)
                    node.father_node.right_node = tmp_node;
                else
                    node.father_node.left_node = tmp_node;
            } else { // root_node
                root_node = tmp_node;
            }
            // 更新选中节点的左右节点
            tmp_node.left_node = node.left_node;
            tmp_node.right_node = node.right_node;
        }
        // one child
        else {
            Node tmp_node = node.right_node == null ? node.left_node : node.right_node; // get signal node.
            if (root_node == node) {
                root_node = tmp_node;
            } else {
                if (node.father_node.left_node == node) // current node on father_node left.
                    node.father_node.left_node = tmp_node;
                else node.father_node.right_node = tmp_node;
            }
        }
        size--;
        return tmp;
    }

    /**
     * find the rightest node on the left subtree.
     */
    public Node find_rightestNodeOnLeftSubtree(Node node) {
        if (node.right_node == null)
            return node;
        else
            return find_rightestNodeOnLeftSubtree(node.right_node);
    }

    /**
     * find the leftst node on the right subtree.
     */
    public Node find_leftestNodeOnRightSubtree(Node node) {
        if (node.left_node == null)
            return node;
        else
            return find_leftestNodeOnRightSubtree(node.left_node);
    }


    @Override
    public Iterator<K> iterator() {
        return new BSTMapiterator(keySet());
    }

    /**
     * 按层级打印输出所有的节点
     */
    public void printInOrder() {
        if (root_node == null) {
            System.out.println("Current BSTMap is null !!!");
            return;
        }
        Node tmp_node = root_node;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tmp_node);
        while (queue.size() != 0) {
            Node x = queue.remove();
            System.out.println("node.key = " + x.key +
                    "\tnode.value = " + x.value +
                    "\tnode.left_node = " + x.left_node +
                    "\tnode.right_node = " + x.right_node);
            if (x.left_node != null)
                queue.add(x.left_node);
            if (x.right_node != null)
                queue.add(x.right_node);
        }
    }

}
