package Project.project1B;

/**
 * @author JiazhenZhao
 * 2024/2/1
 * 类说明：
 */
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        int size_word = word.length();
        for (int i = 0; i < size_word; i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /**
     * 如果给的是回文串则返回 true
     * 否则返回false
     * 任何长度为 0 和 1 的都是 palindromes
     */
    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1)
            return true;
        int flag = word.length() / 2;
        if (word.length() % 2 == 0) {
            for (int i = 0; i < flag; i++) {
                char front = word.charAt(i);
                char back = word.charAt(word.length() - 1 - i);
                if (back != front)
                    return false;
            }
            return true;
        }
        for (int i = 0; i < flag; i++) {
            char front = word.charAt(i);
            char back = word.charAt(word.length() - 1 - i);
            if (back != front)
                return false;
        }
        return true;
    }

}
