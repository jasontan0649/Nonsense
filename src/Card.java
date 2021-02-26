import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Card implements Comparable<Card> {
    private char suit;
    private char value;
    private final static String VALID_SUIT = "cdhs";
    private final static String VALID_VALUE = "A23456789XJQK";
    private final static Card CARDS[] = geneCards();

    public Card(String cardValue) {
        setCard(cardValue);
    }

    //getter
    public char getSuit() {
        return this.suit;
    }

    public char getValue() {
        return this.value;
    }

    public int getWeight() {
        return VALID_VALUE.indexOf(this.value);
    }

    public int getPoint() {
        return Math.min(this.getWeight() + 1, 10);
    }

    public int getSuitWeight() {
        return VALID_SUIT.indexOf(this.suit);
    }

    public String getCard() {
        return "" + this.suit + this.value;
    }

    public void setCard(String cardValue) {
        setSuit(cardValue.charAt(0));
        setValue(cardValue.charAt(1));
    }

    private void setSuit(char suit) {
        suit = Character.toLowerCase(suit);
        this.suit = suit;
    }

    private void setValue(char value) {
        value = Character.toUpperCase(value);
        this.value = value;
    }

    //static method for initialize stack of card to program
    private static Card[] geneCards() {
        Card cards[] = new Card[52];
        char[] suits = VALID_SUIT.toCharArray();
        char[] values = VALID_VALUE.toCharArray();

        int i = 0;
        for (char value : values)
            for (char suit : suits)
                cards[i++] = new Card("" + suit + value);

        return cards;
    }

    //static method for instantiate a stack of shuffled cards
    public static Stack<Card> newShuffleCards() {
        Stack<Card> newCards = new Stack<Card>();
        for(Card c : Card.CARDS)
            newCards.push(c);
        Collections.shuffle(newCards);
        return newCards;
    }


    //comparable
    public int compareTo(Card c) {
        return this.getWeight() - c.getWeight();
    }

    //toString
    @Override
    public String toString() {
        return this.getCard();
    }

}

class suitComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuitWeight() != c2.getSuitWeight())
            return c1.getSuitWeight() - c2.getSuitWeight();
        else
            return c1.compareTo(c2);
    }
}

