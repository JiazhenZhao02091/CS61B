package Course.course4.course4;

import java.util.*;

/**
 * @author JiazhenZhao
 * 2024/1/31
 * 类说明：
 */
public class main {
    public void getWords(String filename){
        List stringList = new ArrayList<String>();
        stringList.add("hello, ");
        stringList.add("world!");
    }
    public int countUniqueWords(List<String> words){
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        return set.size();
    }

    public void collectWordCount(List<String> target, List<String> words){
        Map<String, Integer> map = new HashMap<>();
        for(String t : target){
            map.put(t, 0);
            for(String word : words){
                if(t == word){
                    map.put(t, map.get(t) + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("h" , 0);
        map.put("h" , map.get("h") + 1);
        System.out.println(map.toString());
        System.out.println(map.size());
        map.put("hh", 2);
        System.out.println(map.size());
    }

    /**
     * List : 项目的有序集合
     *      ArrayList
     * Set  : 严格唯一的项目的无序集合(不重复)
     *      HashSet
     * Map  : 键值对集合 // 也不重复
     *      HashMap
     */
}
