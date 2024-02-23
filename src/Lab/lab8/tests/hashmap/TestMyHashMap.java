package Lab.lab8.tests.hashmap;

import static org.junit.Assert.*;

import Lab.lab8.src.hashmap.MyHashMap;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * Tests by Brendan Hu, Spring 2015
 * Revised for 2016 by Josh Hug
 * Revised for 2021 by Neil Kulkarni
 * Revised for 2023 by Aram Kazorian and Noah Adhikari
 */
public class TestMyHashMap {

    @DisplayName("generics")
    @Test
    public void testGenerics() {
        try {
            MyHashMap<String, String> a = new MyHashMap<>();
            MyHashMap<String, Integer> b = new MyHashMap<>();
            MyHashMap<Integer, String> c = new MyHashMap<>();
            MyHashMap<Boolean, Integer> d = new MyHashMap<>();
        } catch (Exception e) {
            fail();
        }
    }

    //assumes put/size/containsKey/get work
    @DisplayName("clear")
    @Test
    public void testClear() {
        sanityClearTest(new MyHashMap<>());
    }

    public static void sanityClearTest(MyHashMap<String, Integer> b) {
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, i);
            //make sure put is working via containsKey and get
            assertEquals((long) b.get("hi" + i), i);
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

    // assumes put works
    @DisplayName("containsKey")
    @Test
    public void testContainsKey() {
        containsKeyTest(new MyHashMap<>());
    }

    public static void containsKeyTest(MyHashMap<String, Integer> b) {
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));

        // Recall that even with a null value, containsKey should return true
        b.put("hashBrowns", null);
        assertTrue(b.containsKey("hashBrowns"));
    }

    // assumes put works
    @DisplayName("get")
    @Test
    public void testGet() {
        sanityGetTest(new MyHashMap<>());
    }

    public static void sanityGetTest(MyHashMap<String, Integer> b) {
        assertNull(b.get("starChild"));
        b.put("starChild", 5);
        assertEquals((long) b.get("starChild"), 5);
        b.put("KISS", 5);
        assertEquals((long) b.get("KISS"), 5);
        assertEquals((long) b.get("starChild"), 5);
    }

    // assumes put works
    @DisplayName("size")
    @Test
    public void testSize() {
        sanitySizeTest(new MyHashMap<>());
    }

    public static void sanitySizeTest(MyHashMap<String, Integer> b) {
        assertEquals((long) b.size(), 0);
        b.put("hi", 1);
        assertEquals((long) b.size(), 1);
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals((long) b.size(), 456);
    }

    //assumes get/containskey work
    @DisplayName("put")
    @Test
    public void testPut() {
        sanityPutTest(new MyHashMap<>());
    }

    public static void sanityPutTest(MyHashMap<String, Integer> b) {
        b.put("hi", 1);
        assertTrue(b.containsKey("hi"));
        assertEquals((long) b.get("hi"), 1);
    }

    // Test for general functionality and that the properties of Maps hold.
    @DisplayName("functionality")
    @Test
    public void testFunctionality() {
        functionalityTest(new MyHashMap<>(), new MyHashMap<>());
    }

    public static void functionalityTest(MyHashMap<String, String> dictionary,
                                         MyHashMap<String, Integer> studentIDs) {
        assertEquals((long) dictionary.size(), 0);

        // can put objects in dictionary and get them
        dictionary.put("hello", "world");
        assertTrue(dictionary.containsKey("hello"));
        assertEquals(dictionary.get("hello"), "world");
        assertEquals((long) dictionary.size(), 1);

        // putting with existing key updates the value
        dictionary.put("hello", "kevin");
        assertEquals((long) dictionary.size(), 1);
        assertEquals(dictionary.get("hello"), "kevin");

        // putting key in multiple times does not affect behavior
        studentIDs.put("sarah", 12345);
        assertEquals((long) studentIDs.size(), 1);
        assertEquals((long) studentIDs.get("sarah"), 12345);
        studentIDs.put("alan", 345);
        assertEquals((long) studentIDs.size(), 2);
        assertEquals((long) studentIDs.get("sarah"), 12345);
        assertEquals((long) studentIDs.get("alan"), 345);
        studentIDs.put("alan", 345);
        assertEquals(studentIDs.size(), 2);
        assertEquals((long) studentIDs.get("sarah"), 12345);
        assertEquals((long) studentIDs.get("alan"), 345);
        studentIDs.put("alan", 345);
        assertEquals(studentIDs.size(), 2);
        assertEquals((long) studentIDs.get("sarah"), 12345);
        assertEquals((long) studentIDs.get("alan"), 345);
        assertTrue(studentIDs.containsKey("sarah"));
        assertTrue(studentIDs.containsKey("alan"));

        // handle values being the same
        assertEquals((long) studentIDs.get("alan"), 345);
        studentIDs.put("evil alan", 345);
        assertEquals((long) studentIDs.get("evil alan"), 345);
        assertEquals(studentIDs.get("alan"), studentIDs.get("evil alan"));
    }

    /**
     * Tests that the backing array is resized when the load factor is exceeded.
     * In addition, times out if it takes too long (e.g. arithmetically instead of geometrically).
     */
    @DisplayName("resize")
    @Test
    public void testResize() {
        sanityResizeTest(new MyHashMap<>(), 16, 0.75);
        sanityResizeTest(new MyHashMap<>(32), 32, 0.75);
        sanityResizeTest(new MyHashMap<>(64, 0.5), 64, 0.5);
    }

    public static void sanityResizeTest(MyHashMap<String, Integer> m, int initialCapacity, double loadFactor) {
        // Times out after 10 seconds
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            int backingArrayCapacity = sizeOfBackingArray(m);
            assertEquals(backingArrayCapacity, initialCapacity);
            for (int i = 0; i < 1000000; i++) {
                m.put("hi" + i, i);
                if (1.0 * i / backingArrayCapacity > loadFactor) {
                    assertTrue(sizeOfBackingArray(m) > backingArrayCapacity);
                    backingArrayCapacity = sizeOfBackingArray(m);
                }
            }
        });
    }

    /**
     * Returns the length of the backing array of the given map.
     * Be sure that you only use one instance variable to hold the buckets,
     * otherwise this will not work properly.
     * <p>
     * Don't worry about knowing how this method works.
     */
    private static <K extends Comparable<K>, V> int sizeOfBackingArray(MyHashMap<K, V> m) {
        Class<?> clazz = m.getClass();
        if (clazz.getSuperclass().equals(MyHashMap.class)) {
            // anonymous bucketed extensions of MyHashMap
            clazz = clazz.getSuperclass();
        }
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType() == Collection[].class) {
                try {
                    Collection<MyHashMap<K, V>.Node>[] backingArray = (Collection[]) field.get(m);
                    return backingArray.length;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        throw new IllegalArgumentException("Could not find backing array");
    }


    @DisplayName("edge cases")
    @Test
    public void testEdgeCases() {
        edgeCasesTest(new MyHashMap<>());
    }

    /**
     * This test uses an unusual hash function and equals method to
     * capture some strange edge case behavior with collisions.
     * <p>
     * If you're stuck on this test, use the debugger to see what values are
     * expected from the reference map, which is Java's built-in HashMap.
     * <p>
     * If you're still stuck, walk through the expected behavior by hand.
     * Does your map behave the same way?
     * Note Bee's strange equals and hashCode implementations!
     */
    public static void edgeCasesTest(MyHashMap<Bee, Integer> map) {

        Map<Bee, Integer> ref = new HashMap<>();

        Bee b1 = new Bee(1);
        map.put(b1, 1);
        ref.put(b1, 1);
        assertEquals(map.containsKey(b1), ref.containsKey(b1));

        Bee b2 = new Bee(2);
        assertEquals(map.containsKey(b2), ref.containsKey(b2));

        map.put(b2, 2);
        ref.put(b2, 2);
        assertEquals(map.get(b1), ref.get(b1));
        assertEquals(map.get(b2), ref.get(b2));
        assertEquals(map.containsKey(b1), ref.containsKey(b1));
        assertEquals(map.containsKey(b2), ref.containsKey(b2));

        Bee b61 = new Bee(-61);
        map.printHashMap();
        assertEquals(map.get(b61), ref.get(b61));
        assertEquals(map.containsKey(b61), ref.containsKey(b61));
        assertEquals(map.size(), ref.size());

        map.put(b61, -61);
        ref.put(b61, -61);
        assertEquals(map.get(b1), ref.get(b1));
        assertEquals(map.get(b2), ref.get(b2));
        assertEquals(map.get(b61), ref.get(b61));
        assertEquals(map.size(), ref.size());

        // trigger a resize
        for (int m = 3; m <= 61; m++) {
            Bee bm = new Bee(m * 61);
            assertEquals(map.containsKey(bm), ref.containsKey(bm));
            assertEquals(map.get(bm), ref.get(bm));
            map.put(bm, m * 61);
            ref.put(bm, m * 61);
            assertEquals(map.containsKey(bm), ref.containsKey(bm));
            assertEquals(map.get(bm), ref.get(bm));
            assertEquals(map.get(b61), ref.get(b61));
            assertEquals(map.size(), ref.size());
        }

        for (int n = 0; n < 61; n++) {
            Bee bn = new Bee(n);
            map.put(bn, n);
            ref.put(bn, n);
            assertEquals(map.containsKey(b1), ref.containsKey(b1));
            assertEquals(map.containsKey(bn), ref.containsKey(bn));
            assertEquals(map.get(b1), ref.get(b1));
            assertEquals(map.get(bn), ref.get(bn));
            assertEquals(map.size(), ref.size());
        }
    }

    private static class Bee implements Comparable<Bee> {
        int b;

        Bee(int b) {
            this.b = b;
        }

        /**
         * TODO: 为什么修改 hashCode 方式之后就可以解决冲突
         */
        @Override
        public int hashCode() {
            return Math.floorMod(b, 61);
        }


        @Override
        public boolean equals(Object o) {
            if (o instanceof Bee) {
                return Math.abs(this.b - ((Bee) o).b) < 61;
            }
            return false;
        }

        @Override
        public int compareTo(Bee o) {
            if (b == o.b)
                return 0;
            else if (b > o.b)
                return 1;
            else
                return -1;
        }
    }
}
