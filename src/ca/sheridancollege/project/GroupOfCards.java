/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @author Ferhad Mislim
 * @modifier Blake Boyd-Lowry
 */
public class GroupOfCards {

    private int size;
    private final ArrayList<Card> cards = new ArrayList<Card>();//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        
        // Generating hand
        for(int i = 0; i < size; i++) {
            int suit = new Random().nextInt(Suit.values().length);
            int value = new Random().nextInt(Value.values().length);
            
            cards.add(new Card(
                    Value.values()[value],
                    Suit.values()[suit]
            ));
        }
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * 
     * @param index
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * 
     * @param index
     */
    public Card drawCard() {
        Card card = cards.get(0);
        cards.remove(0);
        cards.trimToSize();
        
        return card;
    }

}//end class