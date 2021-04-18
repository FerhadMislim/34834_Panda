/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import ca.sheridancollege.project.Card;
import java.util.ArrayList;
import java.util.*;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @author Ferhad Mislim
 * @modifier Blake Boyd-Lowry
 */
public class Player {

    private String name;
    private GroupOfCards hand;// create a hand of card
    
    public Player(String name) {
        this.name = name;
        
        hand = new GroupOfCards(26);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public GroupOfCards getHand() {
        // TODO - implement Player.getHand
        return hand;
    }

    public Card drawCard() {
        return hand.drawCard();
    }
    
    public boolean validName() {
        return getName().length() > 5;
    }

}
