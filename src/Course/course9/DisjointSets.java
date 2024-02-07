package Course.course9;

/**
 * @author JiazhenZhao
 * 2024/2/7
 * 类说明：
 */
public interface DisjointSets {

    public void connect(int p, int q);

    public boolean isConnected(int p, int q);
}
