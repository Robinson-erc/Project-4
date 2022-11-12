
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
    private void initDeck(){
        Card.Suit suit = Card.Suit.SPADES; 
        for(int i = 0; i < 4; i++){
            for(int j = 0; i < 13; j++){
                if(i == 0) suit = Card.Suit.SPADES;
                else if(i == 1) suit = Card.Suit.HEARTS;
                else if(i == 2) suit = Card.Suit.DIAMONDS;
                else if(i == 3) suit = Card.Suit.CLUBS;
                NewDeck[i*j] = new Card(j,suit);
            }
            
        }
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
