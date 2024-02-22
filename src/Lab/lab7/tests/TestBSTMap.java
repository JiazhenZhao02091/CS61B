package Lab.lab7.tests;

import static org.junit.Assert.*;

import Lab.lab7.src.BSTMap;
import org.junit.Test;


/** Tests by Brendan Hu, Spring 2015, revised for 2016 by Josh Hug and for 2023 by Noah Adhikari */
public class TestBSTMap {

    @Test
    public void sanityGenericsTest() {
        try {
            BSTMap<String, String> a = new BSTMap<>();
            BSTMap<String, Integer> b = new BSTMap<>();
            BSTMap<Integer, String> c = new BSTMap<>();
            BSTMap<Boolean, Integer> e = new BSTMap<>();
        } catch (Exception e) {
            fail();
        }
    }
    // This test assumes put/size/containsKey/get are implemented properly.
    @Test
    public void sanityClearTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1+i);
            //make sure put is working via containsKey and get
            assertEquals((long)b.get("hi" + i), 1+i);
            assertEquals((long)b.get("hi" + i), 1 + i);
            assertTrue(b.containsKey("hi" + i));
        }
        assertEquals(b.size(), 455);
        b.clear();
        assertEquals(b.size(), 0);
        for (int i = 0; i < 455; i++) {
            assertNull(b.get("hi" + i));
            assertFalse(b.containsKey("hi" + i));
        }
    }

    // Assumes `put` is implemented properly.
    @Test
    public void sanityContainsKeyTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // Assumes `put` is implemented properly.
    @Test
    public void sanityGetTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        assertNull(b.get("starChild"));
        assertEquals((long)b.size(), 0);
        b.put("starChild", 5);
        assertEquals((long)b.get("starChild"), 5);
        assertEquals((long)b.size(), 1);
        b.put("KISS", 5);
        assertEquals((long)b.get("KISS"), 5);
        assertNotNull(b.get("starChild"));
        assertEquals((long)b.size(), 2);
    }

    // Assumes `put` is implemented properly.
    @Test
    public void sanitySizeTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        assertEquals(b.size(),0);
        b.put("hi", 1);
        assertEquals(b.size(), 1);
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals(b.size(), 456);
    }

    // Assumes `get` and `containsKey` are implemented properly.
    @Test
    public void sanityPutTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi"));
        assertEquals((long)b.get("hi"), 1);
    }

    // Assumes `put` is implemented properly. This test is a bit tricky - remember that
    // `containsKey` should only care about the keys, not the values!
    @Test
    public void containsKeyNullTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        b.put("hi", null);
        assertNull(b.get("hi"));
        assertTrue(b.containsKey("hi"));
    }

    @Test
    public void treeTest() {
        BSTMap<String, String> b = new BSTMap<>();
        b.put("d", "parmesan");
        b.put("a", "mozzarella");
        b.put("c", "swiss");
        b.put("b", "pepper jack");
        b.put("e", "gouda");

        assertEquals(b.size(), 5);
        assertEquals(b.get("d"), "parmesan");
        assertEquals(b.get("a"), "mozzarella");
        assertEquals(b.get("c"), "swiss");
        assertEquals(b.get("b"), "pepper jack");
        assertEquals(b.get("e"), "gouda");

        b.put("b", "provolone");
        assertEquals(b.size(), 5 );
        assertEquals(b.get("b"),"provolone");
    }

}
