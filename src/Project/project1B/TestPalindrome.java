package Project.project1B;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindromeCompare() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("abbbba"));
        assertTrue(palindrome.isPalindrome("abbba"));
    }

    @Test
    public void testPalindromeByOffByOneCompare() {
        assertTrue(palindrome.isPalindrome("cad", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("acdebb", offByOne));
        assertTrue(palindrome.isPalindrome("bcbba", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }

    @Test
    public void testPalindromeByOffByNCompare() {
        assertTrue(palindrome.isPalindrome("a", offByN));
        assertTrue(palindrome.isPalindrome("", offByN));
        assertTrue(palindrome.isPalindrome("acf", offByN));
        assertTrue(palindrome.isPalindrome("fca", offByN));
        assertTrue(palindrome.isPalindrome("fcha", offByN));
    }


//    Uncomment this
//    class once you've created your Palindrome class.


}
