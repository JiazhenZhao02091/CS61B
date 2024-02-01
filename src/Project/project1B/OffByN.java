package Project.project1B;

/**
 * @author JiazhenZhao
 * 2024/2/1
 * 类说明：
 */
public class OffByN implements CharacterComparator{
    public int offset;
    public OffByN(int n){
        offset = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int flag = x - y;
        return flag == offset || flag == offset * -1;
    }
}
