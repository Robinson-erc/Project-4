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
        while(answer=='y'){
            System.out.println("I hate life");
            int GetScore;
            GetScore=PlayARound();
            System.out.println(GetScore);
            
        }
        

    }
    protected int PlayARound(){
        Deck deck=new Deck();
        deck.DealACard();
        System.out.println("Will the next card be higher or lower?");
        
        return this.m_sumofScores;
    }

    public static void main(String args[]){
        HighLow highlow =new HighLow();
        highlow.Play();
        
    }

}
