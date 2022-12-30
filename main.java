import java.util.Scanner;
import java.io.IOException;
public class main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        cards card = new cards();
	        card.shuffleCard();
	        card.cutCards();
	        card.startGame();
	        card.lastWinner();
	        card.userPointsCalculator();
	        card.computerPointsCalculator();
	        card.totalPoint();
	        System.out.println("What is players name?= ");
	        String userName = sc.nextLine();
	        cards.useHighScoreList(userName , card.userpoint);
}
}