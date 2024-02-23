package Project.project1.project1B;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.


    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByOne(){
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('c','d'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('b','b'));
        System.out.println("PASSED ALL CASE !!!");
    }

    @Test
    public void testOffByN(){
        System.out.println(offByN.equalChars('a','f'));
        System.out.println(offByN.equalChars('f','a'));
        System.out.println(offByN.equalChars('f','h'));
        System.out.println("PASSED ALL CASE !!!");
    }
}
