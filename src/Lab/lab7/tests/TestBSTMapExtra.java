package Lab.lab7.tests;

import java.util.Set;
import java.util.TreeSet;

import Lab.lab7.src.BSTMap;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

/** Tests of optional parts of lab 7. */
public class TestBSTMapExtra {

    /*
     * Sanity test for keySet, only here because it's optional
     */
    @Test
    public void sanityKeySetTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        TreeSet<String> values = new TreeSet<>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            values.add("hi" + i);
        }
        /*
        assertEquals(b.size()).isEqualTo(455); //keys are there
        Set<String> keySet = b.keySet();
        assertEquals(values).containsExactlyElementsIn(keySet).inOrder();
        assertEquals(keySet).containsExactlyElementsIn(values).inOrder();
         */
    }

    /* Remove Test
     *
     * Note for testRemoveRoot:
     *
     * Just checking that c is gone (perhaps incorrectly)
     * assumes that remove is BST-structure preserving.
     *
     * More exhaustive tests could be done to verify
     * implementation of remove, but that would require doing
     * things like checking for inorder vs. preorder swaps,
     * and is unnecessary in this simple BST implementation.
     */
    @Test
    public void testRemoveRoot() {
        BSTMap<String, String> q = new BSTMap<>();
        q.put("c", "a");
        q.put("b", "a");
        q.put("a", "a");
        q.put("d", "a");
        q.put("e", "a"); // a b c d e
        assertEquals(q.remove("c"), "a");
        assertFalse(q.containsKey("c"));
        assertNull(q.remove("c"));
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        assertTrue(q.containsKey("e"));

    }

    /* Remove Test 2
     * test the 3 different cases of remove
     */
    @Test
    public void testRemoveThreeCases() {
        BSTMap<String,String> q = new BSTMap<>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a");                         // a b c d e
        assertNotNull(q.remove("e"));      // a b c d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("c"));
        assertTrue(q.containsKey("d"));
        assertNotNull(q.remove("c"));      // a b d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        q.put("f","a");                         // a b d f
        assertNotNull(q.remove("d"));      // a b f
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("f"));
    }

    /* Remove Test 3
     *  Checks that remove works correctly on root nodes
     *  when the node has only 1 or 0 children on either side. */
    @Test
    public void testRemoveRootEdge() {
        BSTMap<Character, Integer> rightChild = new BSTMap<>();
        rightChild.put('A', 1);
        rightChild.put('B', 2);
        assertEquals((long)rightChild.remove('A') , 1);
        for (int i = 0; i < 10; i++) {
            rightChild.put((char) ('C' + i), 3 + i);
        }
        rightChild.put('A', 100);
        assertEquals((long)rightChild.remove('D'), 4);
        assertEquals((long)rightChild.remove('G'), 7);
        assertEquals((long)rightChild.remove('A'), 100);
        assertEquals((long)rightChild.size(), 9);

        BSTMap<Character, Integer> leftChild = new BSTMap<>();
        leftChild.put('B', 1);
        leftChild.put('A', 2);
        assertEquals((long)leftChild.remove('B'), 1);
        assertEquals((long)leftChild.size(), 1);
        Assert.assertNull(leftChild.get('B'));

        BSTMap<Character, Integer> noChild = new BSTMap<>();
        noChild.put('Z', 15);
        assertEquals((long)noChild.remove('Z'), 15);
        assertEquals((long)noChild.size(), 0);
        Assert.assertNull(noChild.get('Z'));
    }

}
