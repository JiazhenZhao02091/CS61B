package Lab.lab12;

import edu.princeton.cs.algs4.Queue;

/**
 * Use the function that provided by Queue.
 */

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     * <p>
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /**
     * Returns a queue of queues that each contain one item from items.
     */
    private static <Item extends Comparable> Queue<Queue<Item>>
    makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> queue = new Queue<>();
        for (Item item : items) {
            Queue<Item> queue1 = new Queue<>();
            queue1.enqueue(item);
            queue.enqueue(queue1);
        }
        return queue;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     * <p>
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least to
     * greatest.
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        // merge sorted two q1 and q2;
        Queue<Item> res = new Queue<>();
        int max_index = q1.size() + q2.size();
        int index = 0;
        while (index < max_index) {
            Item x = getMin(q1, q2);
            res.enqueue(x);
            index ++;
        }
        return res;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        /*
         * merge sort
         * */
        Queue<Queue<Item>> queue = makeSingleItemQueues(items);
        while (queue.size() > 1){
            Queue<Item> q1 = queue.dequeue();
            Queue<Item> q2 = queue.dequeue();
            queue.enqueue(mergeSortedQueues(q1, q2));
        }
        Queue<Item> res = queue.dequeue();
        return res;
    }

    public static void main(String[] args) {
        Queue<String> students = new Queue<>();
        students.enqueue("Ethan");
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students = MergeSort.mergeSort(students);
        System.out.println(students.toString());
        // A E V


        Queue<Integer> numbers = new Queue<>();
        numbers.enqueue(3);
        numbers.enqueue(2);
        numbers.enqueue(1);
        numbers.enqueue(1);
        numbers.enqueue(5);
        numbers.enqueue(9);
        numbers = MergeSort.mergeSort(numbers);
        System.out.println(numbers.toString());
    }
}
