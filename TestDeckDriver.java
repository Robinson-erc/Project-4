
/**
 * Test Deck Driver (Do not turn this in)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDeckDriver
{
    public static void main(String args[])
    {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++)
        {
            Card card = deck.DealACard();
            System.out.println(card);
        }

        deck.Shuffle();

        System.out.println();
        System.out.println("After Shuffle");
        for (int i = 0; i < 52; i++)
        {
            Card card = deck.DealACard();
            System.out.println(card);
        }
    }
}
