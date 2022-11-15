import java.util.Scanner;

/**
 * Write a description of class HighLow here.
 *
 * @author (Eric Robinson)
 * @version (a version number or a date)
 */
public class HighLow
{
    private int m_gamesPlayed;
    private int m_sumofScores;
    private Deck deck;
    
    public void Play(){
        Scanner in=new Scanner(System.in);
        System.out.println("Play again?");
        char answer=in.next().charAt(0);
        while(PlayAgainPrompt()=='y'||PlayAgainPrompt()=='Y'){
            //System.out.println("I hate life");
            int GetScore;
            GetScore=PlayARound();
            System.out.println(GetScore);
            System.out.println("Play again?");
            answer=in.next().charAt(0);
            
         }
        
        

    }
    protected char PlayAgainPrompt(){
        char answer;
        Scanner in=new Scanner(System.in);
        System.out.println("Would you like to play again?");
        answer=in.next().charAt(0);
        
        return answer;
    }
    protected int PlayARound(){
        Deck deck=new Deck();
        deck.Shuffle();
        Card currentCard;
        Card nextCard;
        currentCard=deck.DealACard();
        System.out.println(currentCard+" is the current card");
        
        // deck.DealACard();
        GuessPrompt();
        
        return this.m_sumofScores;
    }
    protected char GuessPrompt(){
        char prompt;
        Scanner in=new Scanner(System.in);
        System.out.println("Will the next card be higher or lower than the current card");
        prompt=in.next().charAt(0);
        return prompt;
    }
    protected void DisplayCurrentCard(Card card){
        
    }

    public static void main(String args[]){
        HighLow highlow =new HighLow();
        highlow.Play();
        
    }

}
