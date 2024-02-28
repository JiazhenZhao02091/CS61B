package Lab.lab12;

import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     *
     * The items in q2 will be catenated after all of the items in q1.
     * 将 q2 的项目链接至 q1之后
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item: q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /** Returns a random item from the given queue. */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted  A Queue of unsorted items
     * @param pivot     The item to pivot on
     * @param less      An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are less than the given pivot.
     * @param equal     An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are equal to the given pivot.
     * @param greater   An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        System.out.println(pivot);
        for(Item items : unsorted){
            if (items.compareTo(pivot) == 0){
                equal.enqueue(items);
            }
            else if(items.compareTo(pivot) > 0){
                greater.enqueue(items);
            }else {
                less.enqueue(items);
            }
        }
    }


    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {

        if (items.size() == 0) {
            return new Queue<>();
        }
        if (items.size() == 1) {
            return items;
        }
        /**
         * unsorted is items.
         * contain function is contact two queue.
         * partition function is part an array.
         * getRandomItem function returns a random element of the queue.
         * */
        Queue<Item> less = new Queue<>();
        Queue<Item> greater = new Queue<>();
        Queue<Item> equal = new Queue<>();
        QuickSort.partition(items, getRandomItem(items), less, equal, greater);
        less = quickSort(less);
        greater = quickSort(greater);
        Queue<Item> res = catenate(less,equal);
        res = catenate(res, greater);
        return res;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(8);
        queue.enqueue(9);
        queue = QuickSort.quickSort(queue);
        System.out.println(queue.toString());
    }
}
