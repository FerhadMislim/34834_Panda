/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Megha Patel
 * @author Ferhad Mislim
 * @modifier Blake Boyd-Lowry
 */
public class Card {
    //default modifier for child classes
    private Suit attribute;
    private Value attribute2;
	private Suit suit;
	private Value value;
    public Card (Value cardValue, Suit suit)
   {
      this.value = cardValue;
      this.suit = suit;
   }

   public String getSuit ()
   {
      return suit.getSuit();
   }

   public void setSuit (Suit suit)
   {
      this.suit = suit;
   }

   public int getValue ()
   {
      return value.getValue();
   }

   public void setValue (Value value)
   {
      this.value = value;
   }
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public String toString(){
        return String.format("Suit:%s Value:%s",getSuit(),getValue());
    }

}
