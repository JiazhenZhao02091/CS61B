package Lab.lab8.tests.hashmap;

import Lab.lab8.src.hashmap.MyHashMap;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Collection;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * Tests by Brendan Hu, Spring 2015
 * Revised for 2016 by Josh Hug
 * Revised for 2021 by Neil Kulkarni
 * Revised for 2023 by Aram Kazorian and Noah Adhikari
 */
public class TestMyHashMap2 {

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
            assertThat(b.get("hi" + i)).isEqualTo(i);
            assertThat(b.containsKey("hi" + i)).isTrue();
        }
        assertThat(b.size()).isEqualTo(455);
        b.clear();
        assertThat(b.size()).isEqualTo(0);
        for (int i = 0; i < 455; i++) {
            assertThat(b.get("hi" + i)).isNull();
            assertThat(b.containsKey("hi" + i)).isFalse();
        }
    }

    // assumes put works
    @DisplayName("containsKey")
    @Test
    public void testContainsKey() {
        containsKeyTest(new MyHashMap<>());
    }

    public static void containsKeyTest(MyHashMap<String, Integer> b) {
        assertThat(b.containsKey("waterYouDoingHere")).isFalse();
        b.put("waterYouDoingHere", 0);
        assertThat(b.containsKey("waterYouDoingHere")).isTrue();

        // Recall that even with a null value, containsKey should return true
        b.put("hashBrowns", null);
        assertThat(b.containsKey("hashBrowns")).isTrue();
    }

    // assumes put works
    @DisplayName("get")
    @Test
    public void testGet() {
        sanityGetTest(new MyHashMap<>());
    }

    public static void sanityGetTest(MyHashMap<String, Integer> b) {
        assertThat(b.get("starChild")).isNull();
        b.put("starChild", 5);
        assertThat(b.get("starChild")).isEqualTo(5);
        b.put("KISS", 5);
        assertThat(b.get("KISS")).isEqualTo(5);
        assertThat(b.get("starChild")).isEqualTo(5);
    }

    // assumes put works
    @DisplayName("size")
    @Test
    public void testSize() {
        sanitySizeTest(new MyHashMap<>());
    }

    public static void sanitySizeTest(MyHashMap<String, Integer> b) {
        assertThat(b.size()).isEqualTo(0);
        b.put("hi", 1);
        assertThat(b.size()).isEqualTo(1);
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertThat(b.size()).isEqualTo(456);
    }

    //assumes get/containskey work
    @DisplayName("put")
    @Test
    public void testPut() {
        sanityPutTest(new MyHashMap<>());
    }

    public static void sanityPutTest(MyHashMap<String, Integer> b) {
        b.put("hi", 1);
        assertThat(b.containsKey("hi")).isTrue();
        assertThat(b.get("hi")).isEqualTo(1);
    }

    // Test for general functionality and that the properties of Maps hold.
    @DisplayName("functionality")
    @Test
    public void testFunctionality() {
        functionalityTest(new MyHashMap<>(), new MyHashMap<>());
    }

    public static void functionalityTest(MyHashMap<String, String> dictionary,
                                         MyHashMap<String, Integer> studentIDs) {
        assertThat(dictionary.size()).isEqualTo(0);

        // can put objects in dictionary and get them
        dictionary.put("hello", "world");
        assertThat(dictionary.containsKey("hello")).isTrue();
        assertThat(dictionary.get("hello")).isEqualTo("world");
        assertThat(dictionary.size()).isEqualTo(1);

        // putting with existing key updates the value
        dictionary.put("hello", "kevin");
        assertThat(dictionary.size()).isEqualTo(1);
        assertThat(dictionary.get("hello")).isEqualTo("kevin");

        // putting key in multiple times does not affect behavior
        studentIDs.put("sarah", 12345);
        assertThat(studentIDs.size()).isEqualTo(1);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        assertThat(studentIDs.containsKey("sarah")).isTrue();
        assertThat(studentIDs.containsKey("alan")).isTrue();

        // handle values being the same
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("evil alan", 345);
        assertThat(studentIDs.get("evil alan")).isEqualTo(345);
        assertThat(studentIDs.get("alan")).isEqualTo(studentIDs.get("evil alan"));
    }

    /** Tests that the backing array is resized when the load factor is exceeded.
     *  In addition, times out if it takes too long (e.g. arithmetically instead of geometrically).
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
            assertThat(backingArrayCapacity).isEqualTo(initialCapacity);
            for (int i = 0; i < 1000000; i++) {
                m.put("hi" + i, i);
                if (1.0 * i / backingArrayCapacity > loadFactor) {
                    assertThat(sizeOfBackingArray(m)).isGreaterThan(backingArrayCapacity);
                    backingArrayCapacity = sizeOfBackingArray(m);
                }
            }
        });
    }

    /** Returns the length of the backing array of the given map.
     *  Be sure that you only use one instance variable to hold the buckets,
     *  otherwise this will not work properly.
     *
     *  Don't worry about knowing how this method works. */
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

}
