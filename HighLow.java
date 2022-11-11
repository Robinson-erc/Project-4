import java.util.Scanner;

/**
 * Write a description of class HighLow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HighLow
{
    private int m_gamesPlayed;
    private int m_sumofScores;
    public static void main(String[] args){
        boolean PlayAgain=false;
        int HighestScore = 0;
        Scanner in = new Scanner(System.in); 
        do{
            int GetScore;
            GetScore = Play();
            System.out.println("Would you like to play again?");
            PlayAgain=in.nextBoolean();
            
        }while(PlayAgain);
        System.out.println("The highest scores was: "+HighestScore);
    }
    
    public static int Play(){
       Deck deck = new Deck();
       Card CurrentCard;
       Card NextCard;
       int Correct;
       String choise;
       deck.Shuffle();
       Correct=0;
       CurrentCard=deck.DealACard();
       System.out.println("\nThe current card is "+CurrentCard);
       
       while(true){
           System.out.println("Will the next card be higher (H) or lower (L)" );
           Scanner in = new Scanner(System.in);
           do{
               choise = in.next();
               if(!choise.equals("H")&&!choise.equals("L")){
                   System.out.println("Please respond with 'H' or 'L'");
               }
           }while(!choise.equals("H")&&!choise.equals("L"));
           
           NextCard=deck.DealACard();
           System.out.println("The next card is "+NextCard);
           
           if(NextCard.GetValue()== CurrentCard.GetValue()){
               System.out.println("The value is the same as the last card");
               System.out.println("You lose on ties!");
               break;
           }
           else if(NextCard.GetValue()>CurrentCard.GetValue()){
               if(choise.equals("H")){
                   System.out.println("Your choise was correct");
                   Correct++;
               }
               else{
                   System.out.println("The choice was incorrect");
                   break;
               }
           }
           else {
               if(choise.equals("L")){
                   System.out.println("Your prediction was correct");
                   Correct++;
               }
               else{
                   System.out.println("The choice was incorrect");
                   break;
               }
           }
           System.out.println();
           System.out.println("The game is over. You made "+Correct+" correct guesses");
           System.out.println();
       }
       
       return Correct;
    }
}
