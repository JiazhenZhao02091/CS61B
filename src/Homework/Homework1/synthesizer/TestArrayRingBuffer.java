package Homework.Homework1.synthesizer;
import Project.project0.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        System.out.println(arb.isEmpty() + " " + arb.isFull());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        System.out.println(arb.isEmpty() + " " + arb.isFull());
        arb.dequeue();
//        arb.enqueue(2);

    }


    @Test
    public void test(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        for(Integer x : arb){
            System.out.println(x);
        }
    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
//        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
