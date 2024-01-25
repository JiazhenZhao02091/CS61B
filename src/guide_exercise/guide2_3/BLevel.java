package guide_exercise.guide2_3;

/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 */
public class BLevel {
    public static  int[] cards;
    BLevel(){
        cards = new int[]{1, 3, 4, 10};
    }
    public static void print(){
        for(int card : cards){
            System.out.print(card + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BLevel dingie = new BLevel();
        dingie.cards[3] = 3;
        BLevel.print();
        BLevel pilates = new BLevel();
        pilates.cards[1] = 2;
        BLevel.print();
        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = pilates.cards;
        pilates.cards = newArrWhoDis;
        newArrWhoDis = null;
        BLevel.print();
    }
}

