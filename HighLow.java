import java.util.Scanner;

/**
 * Write a description of class HighLow here.
 *
 * @author (Eric Robinson)
 * @version (a version number or a date)
 */
public class HighLow
{
    protected int m_gamesPlayed;
    private int m_sumofScores;
    private Deck deck;
    
    public void Play(){
        //Scanner in=new Scanner(System.in);
        //System.out.println("welcome");
        PlayARound();
    }

    protected char PlayAgainPrompt(){
        char answer;
        Scanner in=new Scanner(System.in);
        System.out.println("Would you like to play again? Y/N");
        answer=in.next().charAt(0);
        return answer;
    }

    protected int PlayARound(){
        char guess;
        boolean goodGuess=true;
        deck=new Deck();
        deck.Shuffle();
        Card currentCard;
        //Card NextCard;
        currentCard=deck.DealACard();
        //NextCard=deck.DealACard();
        //DisplayCurrentCard(currentCard);        
        //guess=GuessPrompt();
        //NextCard(NextCard);
        while(goodGuess){
            DisplayCurrentCard(currentCard); 
            guess=GuessPrompt();
            Card NextCard=deck.DealACard(); 
            if(NextCard.GetValue()==currentCard.GetValue()){
                System.out.println("The value is the same as the last card");
                //DisplayCurrentCard(NextCard);
                System.out.println("You lose on ties!"); 
                goodGuess=false;
                //PlayAgainPrompt();
                if(PlayAgainPrompt()=='Y'){
                    Play();
                }
                else{
                    break;
                }
                //break;
            }
            else if(NextCard.GetValue()>currentCard.GetValue()){
                if(guess=='H'){
                    System.out.println("Your prediction was correct");
                   DisplayCurrentCard(NextCard);
                    m_gamesPlayed++;
                    //GuessPrompt();
                    Play();
                }
                else{
                    System.out.println("The prediction was incorrect");
                    DisplayCurrentCard(NextCard);
                    goodGuess=false;
                    break;
                }
            }
            else {
                if(guess=='L'){
                    System.out.println("Your prediction was correct");
                    DisplayCurrentCard(NextCard);
                    m_gamesPlayed++;
                    Play();
                }
                else{
                    System.out.println("The prediction was incorrect");
                    DisplayCurrentCard(NextCard);
                    goodGuess=false;
                    break;
                }
            }
            currentCard=NextCard;
        }

        // System.out.println("The games won is "+m_gamesPlayed);
        return this.m_gamesPlayed;

    }

    protected char GuessPrompt(){
        char prompt;
        Scanner in=new Scanner(System.in);
        System.out.println("Will the next card be higher (H) or lower (L)?");
        prompt=in.next().charAt(0);
        return prompt;
    }

    protected void DisplayCurrentCard(Card card){
        System.out.println("The current card is "+card);
    }

    protected void NextCard(Card card){
        System.out.println("The next card is "+card);
    }
    // public static void main(String args[]){
    // HighLow highlow =new HighLow();
    // int count=0;
    // do{
    // // highlow.PlayARound();
    // highlow.Play();
    // count++;
    // }while(highlow.PlayAgainPrompt()=='Y'); 

    // }

}