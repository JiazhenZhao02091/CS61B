package Course.course6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JiazhenZhao
 * 2024/2/3
 * 类说明：
 */
public class main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("a");
        System.out.println(stringSet.size());

    }
}
