package Project.project1B;

/**
 * @author JiazhenZhao
 * 2024/2/1
 * 类说明：
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
//        return x == y;
        int flag = x - y;
        return flag == 1 || flag == -1;
    }

}
