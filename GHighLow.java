/**
 * GHighLow extends and adds graphics to HighLow
 * 
 * @author (Prof R) 
 * @version (v1.0 )
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
public class GHighLow extends HighLow
{
    private JFrame      frame;
    private JPanel      panel;
    private JButton     push;
    private ImageIcon   cardBack;
    private ImageIcon[] gDeck;
    private JLabel      iconLabelOne, iconLabelTwo;
    private Deck        deck;
    
    public GHighLow()
    {
        super();

        this.frame = new JFrame("Cards");                     // Create frame window and specify window bar text
        this.frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);  
        // Create the 52 card ImageIcons
        gDeck = new ImageIcon[52];
        int cardIndex=0;
        String s1 =null;
        for(int i = 0; i<12;i++){
            int j=(i%13)+1;
            if(i<=12){
                s1= String.valueOf(j)+ "Spades" + ".png";
            }
            if(i<=25){
                s1= String.valueOf(j)+ "Diamonds" + ".png";
            }
            if(i<=38){
                s1= String.valueOf(j)+ "Hearts" + ".png";
            }
            else{
                s1= String.valueOf(j)+ "Clubs" + ".png";
            }
            
            gDeck[cardIndex] = new ImageIcon("cards//"+ s1);
            cardIndex++;
        }
        // Create the on back of cars ImageIcon
        this.cardBack  = new ImageIcon("cards//cardBack.png");
        //this.cardBack= gDeck[1];
        // Create two icon JLabel objects
        this.iconLabelOne = new JLabel (null, this.cardBack, 
            SwingConstants.CENTER);
        this.iconLabelTwo = new JLabel (null, this.cardBack, 
            SwingConstants.CENTER);
        (this.iconLabelOne).setIcon(this.cardBack); 
        (this.iconLabelTwo).setIcon(this.cardBack); 
        //this.push = new JButton("Deal");
        //this.push.addActionListener (new ButtonListener());
        this.panel = new JPanel();
        this.panel.setBackground(Color.cyan);
        this.panel.setPreferredSize (new Dimension(350, 275));
        this.panel.add(this.iconLabelOne);
        this.panel.add(this.iconLabelTwo);
       // this.panel.add(this.push);
        this.frame.getContentPane().add(this.panel);
        this.frame.pack();
        this.frame.setVisible(true);  
    }

    public void SetCardLabel(Card card, JLabel label)
    {
        int index = (card.GetSuit()).ordinal();
        index= index*13 +card.GetValue();
        label.setIcon(gDeck[index-1]);
        
    }

    @Override
    public void DisplayCurrentCard(Card card)
    {
        SetCardLabel(card, this.iconLabelOne); 
        
    }

    @Override
    public void NextCard(Card card)
    {
        SetCardLabel(card, this.iconLabelTwo); 
    }

    @Override
    protected int PlayARound()
    {     
        //return correctGuesses;
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
        DisplayCurrentCard(currentCard); 
          while(goodGuess){
            DisplayCurrentCard(currentCard);
            (this.iconLabelTwo).setIcon(this.cardBack);
            guess=GuessPrompt();
            Card NextCard=deck.DealACard(); 
            DisplayCurrentCard(NextCard);
            if(NextCard.GetValue()==currentCard.GetValue()){
                System.out.println("The value is the same as the last card");
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
}