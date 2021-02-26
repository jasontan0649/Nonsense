import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class PrintCard {
    public static String avlCards(Queue<ArrayList<Card>> cards) {
        StringBuilder res = new StringBuilder();
        for (ArrayList<Card> cardPart : cards) {
            res.append(strCardPart(cardPart) + ",");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    public static String curAvlCards(ArrayList<Card> cardPart) {
        return strCardPart(cardPart);
    }

    private static String strCardPart(ArrayList<Card> cardPart) {
        StringBuilder res = new StringBuilder();
        for (Card card : cardPart)
            res.append(" " + card);
        return res.toString();
    }

}
