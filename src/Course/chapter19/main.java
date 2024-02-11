package Course.chapter19;

import java.util.LinkedList;

/**
 * @author JiazhenZhao
 * 2024/2/11
 * 类说明：
 */
public class main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        System.out.println(list.hashCode()); // 32
        list.addFirst(2);
        System.out.println(list.hashCode()); // 1024
    }

}

