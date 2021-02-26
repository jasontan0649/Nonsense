import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("******************");
        System.out.println(" 3-Player Phase  *");
        System.out.println("******************");
        Game game = new Game();
        System.out.println();

        for (int i = 0; i < 2; i++) {
            game.showShuffleCard();
            System.out.println("\n\n");

            //round
            for (int roundInt = 1; roundInt <= 3+i ; roundInt++) {
                Round round = new Round(game, roundInt);
                round.showRound();
                round.showCardsAtHand();
                System.out.println("\n");
                round.showScore();
                System.out.println("\n");
                game.showAvailableCard();
                System.out.println("\n");
                round.showNextRound();
            }

            game.removeWeakest(); //remove weakest player

            if (i == 0) //3 players phase
                game.showNextPhase();
            else //2 players phase
                game.showWinner();


        }

    }
}
