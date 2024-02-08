package Course.chapter16;

/**
 * @author JiazhenZhao
 * 2024/2/8
 * 类说明：
 */
public class main {
    private class BST<Key>{
        private Key key;
        private BST left;
        private BST right;

        public BST(Key key, BST left, BST Right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public BST(Key key) {
            this.key = key;
        }
    }

}
