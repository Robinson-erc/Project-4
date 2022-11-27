
/**
 * Write a description of class Deck here.
 *
 * @author (Eric Robinson)
 * @version (a version number or a date)
 */
public class Deck
{
    public static final int NCARDS = 52;
    private Card[] NewDeck = new Card[NCARDS];
    private int cardsUsed = 0;
    private final int SHUFFLENUM=1000;
    private RandomInteger   r1; 
    private RandomInteger   r2;
    
    public Deck(){
        initDeck();
        r1=new RandomInteger(1,52);
        r2=new RandomInteger(1,52);
    }
    public int CardsLeft(){
        return NewDeck.length - cardsUsed;
    }
    public Card DealACard(){
        if(CardsLeft()==0) throw new IllegalStateException("No cards left in the deck");
        return NewDeck[cardsUsed++];
    }
   private void initDeck() {
        int index = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    //System.out.println("index: " + index  + "I: " + i + "J: " + j );
                    switch (i) {
                        case 0:
                            NewDeck[index] = new Card(j, Card.Suit.SPADES);
                            break;
                        case 1:
                            NewDeck[index] = new Card(j, Card.Suit.HEARTS);
                            break;
                        case 2:
                            NewDeck[index] = new Card(j, Card.Suit.DIAMONDS);
                            break;
                        case 3:
                            NewDeck[index] = new Card(j, Card.Suit.CLUBS);
                            break;
                    } //end of switch statement
                    index++;
                } //end of j loop
            } // end of i loop
    }
    public void Shuffle(){
        for(int i= NewDeck.length-1; i >0;  i--){
            int rand = (int) (Math.random()*(i+1));
            Card temp = NewDeck[i];
            NewDeck[rand]=temp; 
        } 
        cardsUsed=0;
    }
}
