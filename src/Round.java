import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Round {
    private Game game;
    private int roundInt;
    private ArrayList<ArrayList<Card>> cards;
    private ArrayList<Integer> points;
    private HashSet<Integer> winnerIdx;

    public Round(Game game, int roundInt) {
        this.game = game;
        this.roundInt = roundInt;

        //poll cards from all players and sort then count point
        this.cards = new ArrayList<ArrayList<Card>>();
        this.points = new ArrayList<Integer>();

        for (Player p : game.getPlayers()) {
            ArrayList<Card> tmp = p.pollCards();
            Collections.sort(tmp, new suitComparator());
            cards.add(tmp); //add sorted card
            points.add(countPoint(tmp));
        }

        //get the top highest point players index
        this.winnerIdx = highestPointIdx();

        //add score to those players
        addPointToScore();
    }

    private int countPoint(ArrayList<Card> cards) {
        int bestSum = cards.get(0).getPoint();
        int currentSum = bestSum;

        for(int i = 1; i < cards.size(); i++) {
            if (cards.get(i-1).getSuit() != cards.get(i).getSuit())
                currentSum = cards.get(i).getPoint();
            else
                currentSum += cards.get(i).getPoint();
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }


    private HashSet<Integer> highestPointIdx() {
        HashSet<Integer> res = new HashSet<>();
        int maxPoint = 0;

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) > maxPoint) {
                maxPoint = points.get(i);
                res.clear();
                res.add(i);
            } else if (points.get(i) == maxPoint)
                res.add(i);
        }

        return res;
    }


    private void addPointToScore() {
        for (int i = 0; i < points.size(); i++) {
            if (winnerIdx.contains(i))
                game.getPlayers().get(i).addScore(points.get(i));
        }
    }

    public void showRound() {
        System.out.println("*** ROUND " + roundInt + " ***");
    }

    public void showCardsAtHand() {
        System.out.println("Cards at Hand:");
        int maxLen  = game.getNameMaxLen() + 1;

        int i = 0;
        for (Player p : game.getPlayers()) {
            int spaceLen = maxLen - p.getName().length();
            System.out.print(p.getName() + " ".repeat(spaceLen) + ":");
            System.out.print(PrintCard.curAvlCards(cards.get(i)));
            System.out.print(" | Point = ");
            System.out.print(points.get(i));
            if (winnerIdx.contains(i))
                System.out.print(" | Win");
            System.out.println();
            i++;
        }

    }

    public void showScore() {
        System.out.println("Score:");
        int maxLen  = game.getNameMaxLen() + 1;

        for (Player p : game.getPlayers()) {
            int spaceLen = maxLen - p.getName().length();
            System.out.print(p.getName() + " ".repeat(spaceLen) + "= ");
            System.out.print(p.getScore());
            System.out.println();
        }
    }

    public void showNextRound() {
        System.out.println("Press ENTER to next round");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

}
