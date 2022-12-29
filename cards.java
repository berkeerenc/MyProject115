import java.util.Scanner;

public class cards {
	Scanner sc = new Scanner(System.in);
    public int usersPisti;
    public int computersPisti;
    public int totalwincardnumber;
    public int lastboardcardnumbers;
    public int boardcardnumbers;
    public int computersfirstcard;
    public int computerssecondcard;
    public int computersthirdcard;
    public int computersfourthcard;
    public int firstcard;
    public int secondcard;
    public int boardarraycardnumbers;
    public int thirdcard;
    public int fourthcard;
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
    public boolean lastWinner;

    public cards() {
        cards = new int[52];
        suits = new String[]{"♠", "♣", "♥", "♦"};
        ranks = new String[]{"A(Ace)", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J(Jack)", "Q(Queen)", "K(King)"};
        decks = new String[52];
        board = new String[52];
        usersHand = new String[4];
        computersHand = new String[4];
        numcards = 0;
        firstcard = 0;
        secondcard = 0;
        thirdcard = 0;
        fourthcard = 0;
        computersfirstcard = 0;
        computerssecondcard = 0;
        computersthirdcard = 0;
        computersfourthcard = 0;
        usersTreasure = new String[52];
        compareTreasure= new String[52];
        computersTreasure = new String[52];
        boardcardnumbers = 4;
        boardarraycardnumbers = 3;
        totalwincardnumber = 0;
        k = 0;
        usersPisti = 0;
        computersPisti = 0;
        lastWinner = true;
    }

    public void setCards(int[] a) {
        cards = a;
    }

    public int[] getCards() {
        return cards;
    }

    public void setSuits(String[] a) {
        suits = a;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setRanks(String[] a) {
        ranks = a;
    }

    public String[] getRanks() {
        return ranks;
    }

    public void shuffleandcutCard() {
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
            System.out.println((i + 1) + ")" + decks[i]);
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
        System.out.println("");
        System.out.println("The users hand is: ");
        while (k < 4) {
            for (int i = 0; i < 4; i++) {
                System.out.println(i + ")" + usersHand[i]);
            }
            System.out.println("");
            System.out.println("The computers hand is: ");
            for (int i = 0; i < 4; i++) {
                System.out.println(i + ")" + computersHand[i]);
            }
            System.out.println("What is your card?= ");
            firstcard = sc.nextInt();
            comparetoCards(usersHand, firstcard, usersTreasure, usersPisti);
            System.out.println("Here's the computer's card..");
            computerplay();
            System.out.println(computersHand[secondcard]);
            comparetoCards(computersHand, secondcard, compareTreasure, computersPisti);
            k++;
        }
        dealuserCards();
        System.out.println("");
        System.out.println("The users hand is: ");
        while (k < 8) {
            for (int i = 0; i < 4; i++) {
                System.out.println(i + ")" + usersHand[i]);
            }
            System.out.println("");
            System.out.println("The computers hand is: ");
            for (int i = 0; i < 4; i++) {
                System.out.println(i + ")" + computersHand[i]);
            }
            System.out.println("What is your card?= ");
            firstcard = sc.nextInt();
            comparetoCards(usersHand, firstcard, usersTreasure, usersPisti);
            System.out.println("Here's the computer's card..");
            computerplay();
            System.out.println(computersHand[secondcard]);
            comparetoCards(computersHand, secondcard, compareTreasure, computersPisti);
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
                if(comparecard == secondcard){
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
                if(comparecard == secondcard){
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
                        secondcard = i;
                        break;
                    }  else {
                        secondcard = emptyBoardCard();
                    }
                }
            } else {
                secondcard = emptyBoardCard();
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
}
