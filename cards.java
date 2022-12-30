import java.util.Scanner;

public class cards {
	 public int usersPisti;
	    public int computersPisti;
	    public int totalwincardnumber;
	    public int boardcardnumbers;
	    public int firstcard;
	    public int computerscard;
	    public int boardarraycardnumbers;
	    public int k;
	    public int numcards;
	    public String[] board;
	    public String[] usersHand;
	    public String[] computersHand;
	    private int[] cards;
	    private String[] suits;
	    private String[] ranks;
	    private String[] decks;
	    public String[] usersTreasure;
	    public String[] compareTreasure;
	    public String[] computersTreasure;
	    public String[] specialPoint1;
	    public String[] specialPoint2;
	    public int userpoint;
	    public int computerpoint;
	    public int userTotalCard;
	    public int computerTotalCard;
	    public boolean userMakePisti;
	    private  boolean lastWinner;
	    private  boolean success;
	    private boolean success2;

    public cards() {
    	cards = new int[52];
        suits = new String[]{"♠", "♣", "♥", "♦"};
        ranks = new String[]{"A(Ace)", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J(Jack)", "Q(Queen)", "K(King)"};
        decks = new String[52];
        board = new String[130];
        usersHand = new String[4];
        computersHand = new String[4];
        specialPoint1 = new String[] {"♦"+  " of " + "10"};
        specialPoint2 = new String[] {"♣" + " of " + "2"};
        numcards = 0;
        computerscard = 0;
        usersTreasure = new String[130];
        compareTreasure = new String[130];
        computersTreasure = new String[130];
        boardcardnumbers = 4;
        boardarraycardnumbers = 3;
        totalwincardnumber = 0;
        k = 0;
        usersPisti = 0;
        computersPisti = 0;
        userpoint = 0;
        computerpoint = 0;
        userTotalCard = 0;
        computerTotalCard = 0;
        userMakePisti = false;
        lastWinner = true;
        success = false;
        success2 = false;
    }

    public void createCard() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
            decks[i] = suits[cards[i] / 13] + " of " + ranks[cards[i] % 13];
            System.out.println((i + 1) + ")" + decks[i]);
        }
        displayCard();
    }
    public void shuffleCard() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }
        for (int i = 0; i < cards.length; i++) {
            int index = (int) (Math.random() * cards.length);
            int temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
        displayCard();
    }
    
    public void cutCards(){
        System.out.println("Cutting the cards...");
        System.out.println(" ");
        System.out.println(" ");
        for (int i = 0; i < 26; i++) {
            int temp = cards[i];
            cards[i] = cards[i + 26];
            cards[i + 26] = temp;
        }
        displayCard();
    }
    public void displayCard() {
        for (int i = 0; i < cards.length; i++) {
            decks[i] = suits[cards[i] / 13] + " of " + ranks[cards[i] % 13];
        }
    }
    public void setDecks(String[] a) {
        decks = a;
    }
    public String[] getDecks() {
        return decks;
    }

    public void dealboardCards() {
        System.out.println("");
        System.out.println("");
        System.out.println("The board is: ");
        boardcardnumbers = 4;
        for (int i = 0; i < 4; i++) {
            board[i] = decks[i];
            System.out.println(i + ")" + board[i]);
            numcards++;
        }
    }

    public void dealuserCards() {
        System.out.println("");
        System.out.println("The users hand is: ");
        for (int i = 0; i < 4; i++) {
            usersHand[i] = decks[numcards];
            System.out.println(i + ")" + usersHand[i]);
            numcards++;
        }
        System.out.println("");
        System.out.println("The computers hand is: ");
        for (int i = 0; i < 4; i++) {
            computersHand[i] = decks[numcards];
            System.out.println(i + ")" + computersHand[i]);
            numcards++;
        }
    }
    public void startGame() {
    	dealboardCards();
        dealuserCards();
        System.out.println("");
        while (k < 4) {
           oneTurn();
            k++;
        }
        dealuserCards();
        while (k < 8) {
            oneTurn();
            k++;
        }
        dealuserCards();
        while( k< 12){
            oneTurn();
            k++;
        }
        dealuserCards();
        while ( k < 16){
            oneTurn();
            k++;
        }
        dealuserCards();
        while ( k < 20){
            oneTurn();
            k++;
        }
        dealuserCards();
        while ( k < 24){
            oneTurn();
            k++;
        }
    }
    public void comparetoCards(String[] compare, int comparecard, String[] compareTreasure, int pistiCounter ) {
        if (boardcardnumbers == 0) {
            board[boardarraycardnumbers] = compare[comparecard];
            compare[comparecard] = null;
            boardcardnumbers++;
            for (int i = boardarraycardnumbers; i < boardcardnumbers + boardarraycardnumbers; i++) {
                if(board[i] != null) {
                    System.out.println(board[i]);
                }
            }
        } else if (boardcardnumbers == 1) {
            if (compare[comparecard].charAt(5) == board[boardarraycardnumbers].charAt(5) || compare[comparecard].charAt(5) == 'J') {
                boardarraycardnumbers++;
                board[boardarraycardnumbers] = compare[comparecard];
                if(comparecard == computerscard){
                    computersPisti++;
                    lastWinner = false;
                } else{
                    usersPisti++;
                    lastWinner = true;
                }
                System.out.println("Congratulations!!.." + "\n" + "PİSTİİİİİ!!!!");
                for (int i = 0; i <= boardarraycardnumbers; i++) {
                    if(board[i] != null) {
                        compareTreasure[i] = board[i];
                        System.out.println("Treasure are:" + compareTreasure[i]);
                    }
                    board[i] = null;
                }
                boardcardnumbers = 0;
                boardarraycardnumbers++;
                compare[comparecard] = null;
            } else {
                boardarraycardnumbers++;
                board[boardarraycardnumbers] = compare[comparecard];
                compare[comparecard] = null;
                for (int i = 0; i <= boardarraycardnumbers; i++) {
                    if(board[i] != null) {
                        System.out.println(board[i]);
                    }
                }
                boardcardnumbers++;
            }
        } else {
            if (compare[comparecard].charAt(5) == board[boardarraycardnumbers].charAt(5) || compare[comparecard].charAt(5) == 'J') {
                System.out.println("You win the all cards!!");
                if(comparecard == computerscard){
                    lastWinner = false;
                } else{
                    lastWinner = true;
                }
                boardarraycardnumbers++;
                board[boardarraycardnumbers] = compare[comparecard];
                for (int i = 0; i <= boardarraycardnumbers; i++) {
                    if (board[i] != null) {
                        compareTreasure[i] = board[i];
                        System.out.println("Treasure are:" + compareTreasure[i]);
                    } else {
                        continue;
                    }
                    board[i] = null;
                }
                boardcardnumbers = 0;
                boardarraycardnumbers++;
                compare[comparecard] = null;
            } else {
                boardarraycardnumbers++;
                board[boardarraycardnumbers] = compare[comparecard];
                compare[comparecard] = null;
                for (int i = 0; i <= boardarraycardnumbers; i++) {
                    if(board[i] != null){
                    System.out.println(board[i]);
                    }
                }
                boardcardnumbers++;
            }
        }
    }
    public void computerplay() {
        for (int i = 0; i < 4; i++) {
            if (board[boardarraycardnumbers] != null) {
                if (computersHand[i] != null) {
                    if (board[boardarraycardnumbers].charAt(5) == computersHand[i].charAt(5)) {
                        computerscard = i;
                        break;
                    }  else {
                        computerscard = emptyBoardCard();
                    }
                }
            } else {
                computerscard = emptyBoardCard();
                break;
            }
        }
    }
    public int emptyBoardCard(){
        if(computersHand[0] != null){
            return 0;
        }
        else if(computersHand[1] != null){
            return 1;
        }
         else if(computersHand[2] != null){
            return 2;
        } else {
            return 3;
        }
    }
    public void oneTurn(){
        System.out.println("The users hand is: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + ")" + usersHand[i]);
        }
        do {
            try {
                System.out.println("What is your card?= ");
                Scanner sc = new Scanner(System.in);
                firstcard = sc.nextInt();
                success = true;
            } catch (Exception e) {
                System.out.println("Could not get integer , please enter integer number");
                success = false;
            }
            if(success){
            if(firstcard >= 0 && firstcard <=3){
                if(usersHand[firstcard]!= null){
                    comparetoCards(usersHand, firstcard, usersTreasure, usersPisti);
                    success2 = true;
                }else {
                    System.out.println("You have already played this card.Play different card.");
                    success2 = false;
                }
            } else if (firstcard <= 0){
                System.out.println("The card range you can play is between 0-3, please enter a number in this range.");
                success2 = false;
            } else{
                System.out.println("The card range you can play is between 0-3, please enter a number in this range.");
                success2 = false;
            }
            }
        } while(!success || !success2);
        System.out.println("Here's the computer's card.." + "\n");
        computerplay();
        System.out.println(computersHand[computerscard]);
        comparetoCards(computersHand, computerscard, computersTreasure, computersPisti);
    }
    public void lastWinner(){
        if(lastWinner){
            for (int i = 0; i <= boardarraycardnumbers+boardcardnumbers; i++) {
                if(board[i] != null) {
                    usersTreasure[i] = board[i];
                    System.out.println("Users Treasure are:" + usersTreasure[i]);
                }
                board[i] = null;
            }
        } else {
            for (int i = 0; i <= boardarraycardnumbers+boardcardnumbers; i++) {
                if(board[i] != null) {
                    computersTreasure[i] = board[i];
                    System.out.println("Computers Treasure are:" + computersTreasure[i]);
                }
                board[i] = null;
            }
        }
        public void userPointsCalculator(){
        	for (String s : usersTreasure) {
                if (s != null) {
                    userTotalCard++;
                    if ((s.charAt(0) == '♦' && s.charAt(5) == '1')) {
                        userpoint += 3;
                    } else if((s.charAt(0) == '♣' && s.charAt(5) == '2')){
                        userpoint +=2;
                    } else {
                        userpoint += 1;
                    }
                }
            }
            userpoint = userpoint + (usersPisti*10);
            System.out.println("User point is: " + userpoint);
        }
        public void computerPointsCalculator(){
        	for (String s : computersTreasure) {
                if (s != null) {
                    computerTotalCard++;
                    if ((s.charAt(0) == '♦' && s.charAt(5) == '1') ) {
                        computerpoint += 3;
                    }else if((s.charAt(0) == '♣' && s.charAt(5) == '2')){
                        computerpoint +=2;
                    }
                    else {
                        computerpoint += 1;
                    }
                }
            }
            computerpoint = computerpoint + (computersPisti*10);
            System.out.println("computer point is: " + computerpoint);
        }
        public void totalPoint(){
            if (computerTotalCard > userTotalCard){
                computerpoint +=3;
            } else if ( userTotalCard > computerTotalCard) {
                userpoint +=3;
            } else{
                System.out.println("Total cards are equals!!!!");
            }
            System.out.println("Total computer point is: " + computerpoint);
            System.out.println("Total user point is: " + userpoint);
            if(computerpoint > userpoint){
                System.out.println("COMPUTER WİN!!!!!!!!");
            } else if(userpoint > computerpoint){
                System.out.println("USER WİN!!!!!!!!");
            } else {
                System.out.println("DRAWWWW");
            }
        }
}
