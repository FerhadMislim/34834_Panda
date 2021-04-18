/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @author Ferhad Mislim
 * @modifier Blake Boyd-Lowry
 */
public abstract class Game {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrayList<Player> players = new ArrayList<>();// the players of the game

    public static void play() {
        boolean playing = true;
        
        while(playing) {
            System.out.println("=========================");
            System.out.println("Drawing cards for players");
            System.out.println("=========================");
            
            if(players.get(0).getHand().getSize() == 0 ||
               players.get(1).getHand().getSize() == 0) {
                playing = false;
                break;
            }
            
            Card p1Card = players.get(0).drawCard();
            Card p2Card = players.get(1).drawCard();
            
            System.out.println("Player one draws " + p1Card);
            System.out.println("Player two draws " + p2Card);
            System.out.println("");
            
            // if player 1 wins
            if(p1Card.getValue() > p2Card.getValue()) {
                System.out.println("Player 1 wins this round!");
                players.get(0).getHand().addCard(p2Card);
                players.get(0).getHand().addCard(p1Card);
            }
            // if player 2 wins
            else if(p1Card.getValue() < p2Card.getValue()) {
                System.out.println("Player 2 wins this round!");
                players.get(1).getHand().addCard(p1Card);
                players.get(1).getHand().addCard(p2Card);
            }
            // if war
            else {
                System.out.println("WAR DECLARED!");
                
                boolean war = true;
                
                while(war) {
                    if(players.get(0).getHand().getSize() <= 5) {
                        System.out.println("P1 doesn't have enough cards.");
                        war = false;
                        playing = false;
                        break;
                    }
                    if(players.get(1).getHand().getSize() < 5) {
                        System.out.println("P2 doesn't have enough cards.");
                        war = false;
                        playing = false;
                        break;
                    }
                    
                    ArrayList<Card> warCards1 = new ArrayList<Card>();
                    ArrayList<Card> warCards2 = new ArrayList<Card>();
                    
                    System.out.println("Drawing five cards...");
                    for(int i = 0; i < 5; i++) {
                        warCards1.add(players.get(0).drawCard());
                        warCards2.add(players.get(1).drawCard());
                    }
                    
                    p1Card = warCards1.get(0);
                    p2Card = warCards2.get(1);
                    
                    if(p1Card.getValue() > p2Card.getValue()) {
                        System.out.println("Player 1 wins war!");
                        for(int i = 0; i < 5; i++) {
                            players.get(0).getHand().addCard(warCards1.get(i));
                            players.get(0).getHand().addCard(warCards2.get(i));
                        }
                        war = false;
                    }
                    // if player 2 wins
                    else if(p1Card.getValue() < p2Card.getValue()) {
                        System.out.println("Player 2 wins war!");
                        for(int i = 0; i < 5; i++) {
                            players.get(1).getHand().addCard(warCards1.get(i));
                            players.get(1).getHand().addCard(warCards2.get(i));
                        }
                        war = false;
                    }
                }
            }
            
            System.out.println("Press enter to draw a new card.");
            scan.nextLine();
        }
        
        declareWinner();
    }

    public static void declareWinner() {
        System.out.println("===========");
        System.out.println("GAME OVER!!");
        System.out.println("===========");
        
        if(players.get(0).getHand().getSize() >
                players.get(1).getHand().getSize())
            System.out.println(players.get(0).getName() + " wins the game!!!");
        else
            System.out.println(players.get(1).getName() + " wins the game!!!");
        
        System.out.println("");
        System.out.print("Do you want to play again? ( Y / n ): ");
        
        char playAgain = scan.next().charAt(0);
        
        if(playAgain == 'y' || playAgain == 'Y') {
            String name1 = players.get(0).getName();
            String name2 = players.get(1).getName();
            
            players.remove(0);
            players.remove(0);
            players.trimToSize();
            
            players.add(new Player(name1));
            players.add(new Player(name2));
            
            play();
        }
        else {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {        
        players.add(new Player("temp"));
        players.add(new Player("temp"));
        
        for(int i = 1; i <= 2; i++) {
            System.out.print("Enter a username for player " + i + ": ");
            players.get(i - 1).setName(scan.nextLine());
            
            if(players.get(i - 1).validName()) {
                System.out.println("Named successfully added.");
            }
            else {
                System.out.println("Your name must be over 5 chars");
                i--;
            }
        }
        
        play();
    }

}//end class