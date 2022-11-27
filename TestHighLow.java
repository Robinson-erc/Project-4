
/**
 * Write a description of class TestHighLow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestHighLow
{
   public static void main(String args[]){
        HighLow highlow =new HighLow();
        int count=0;
        do{
            highlow.PlayARound();
            count++;
        }while(highlow.PlayAgainPrompt()=='Y'); 
        
    }
}
