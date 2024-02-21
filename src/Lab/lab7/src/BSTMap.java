package Lab.lab7.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author JiazhenZhao
 * 2024/2/21
 * 类说明： 使用 BST(Binary Search Tree) 来构建Map
 * TODO: 这里在判断 root 节点是否为空的时候选择使用了特判的方法
 *       其实可以使用哨兵节点来实现这种判断，可以极大简化
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        private K key;
        private V value;
        Node left_node;
        Node right_node;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left_node = null;
            this.right_node = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.left_node = null;
            this.right_node = null;
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
        if(root_node.key == null){
            root_node = node;
            size ++ ;
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
                    size++;
                    return;
                }
                tmp_node = tmp_node.right_node;
            } else {
                if (tmp_node.left_node == null) {
                    tmp_node.left_node = node;
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
        if(root_node == null)
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
        if(root_node == null)
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
        return BST_get(node).value;
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
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public void printInOrder() {
        if(root_node == null){
            System.out.println("Current BSTMap is null !!!");
            return ;
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
            if(x.left_node != null)
                queue.add(x.left_node);
            if(x.right_node != null)
                queue.add(x.right_node);
        }
    }

}
