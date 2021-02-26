import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class PrintCard {
    public static String avlCards(Player p) {
        StringBuilder res = new StringBuilder();
        Queue<ArrayList<Card>> cards = p.getCards();
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
