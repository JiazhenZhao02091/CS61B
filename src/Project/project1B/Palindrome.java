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

}
