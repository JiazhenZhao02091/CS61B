package Course.course2.guide.guide2_3.B;

/**
 * @author JiazhenZhao
 * 2024/1/20
 * 类说明：
 */
public class Deck{
    public static  int[] cards;
    Deck(){
        cards = new int[]{1, 3, 4, 10};
    }
    public static void print(){
        for(int card : cards){
            System.out.print(card + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Deck dingie = new Deck();
        dingie.cards[3] = 3;
        Deck.print();
        Deck pilates = new Deck();
        pilates.cards[1] = 2;
        Deck.print();
        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = pilates.cards;
        pilates.cards = newArrWhoDis;
        newArrWhoDis = null;
        Deck.print();
    }
}

