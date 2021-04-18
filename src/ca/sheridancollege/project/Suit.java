package ca.sheridancollege.project;

enum Suit
{
   HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
   
   private String value;
   
   private Suit(String value) {
       this.value = value;
   }
   
   public String getSuit() {
       return this.value;
   }

}