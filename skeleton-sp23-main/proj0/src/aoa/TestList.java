package aoa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiazhenZhao
 * 2024/3/1
 * 类说明：
 */
public class TestList<Item> {
    public List<Item> TestList(Item[] chars) {
        return of(chars);
    }
    public  List<Item> of(Item[] chars){
        List<Item> list = new ArrayList<>();
        for(Item ch : chars){
            list.add(ch);
        }
        return list;
    }
}
