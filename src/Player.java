import java.util.*;

public class Player implements Comparable<Player>{
    private int score;
    private String name;
    private Queue<ArrayList<Card>> cards;

    public Player(String name) {
        setScore(0);
        setName(name);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Queue<ArrayList<Card>> getCards() {
        return cards;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = new LinkedList<>();
        while(!cards.isEmpty()) {
            ArrayList<Card> tmp = new ArrayList<>();
            for (int i = 0; !cards.isEmpty() && i < 5; i++)
                tmp.add(cards.pop());
            this.cards.add(tmp);
        }
    }

    public ArrayList<Card> pollCards() {
        return cards.poll();
    }

    public ArrayList<Card> peekCards() {
        return cards.peek();
    }


    @Override
    public int compareTo(Player p) {
        return this.getScore() - p.getScore();
    }
}
