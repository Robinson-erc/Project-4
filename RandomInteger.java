/**
 * Integer range randon number generator
 *
 * @author (Prof R)
 * @version (v1.0 10/16/2022)
 */
public class RandomInteger
{
    // data members
    private int min;
    private int max;
    private int range;
    /**
     * Default constructor
     */
    public RandomInteger()
    {
        // initialise instance variables
        this.min = 0;
        this.max = 1;
        range    = max - min + 1;
    }
    /**
     * Default constructor
     */
    public RandomInteger(int min, int max)
    {
        this.min = min;
        this.max = max;
        range    = max - min + 1;
    }
    /**
     * int GetMin()
     *
     * @param none
     * @return the miniumun number in the inclusive range
     */
    public int GetMin() 
    {
        return min;
    }
    /**
     * int GetMax()
     *
     * @param none
     * @return the miniumun number in the inclusive range
     */
    public int GetMax() 
    {
        return max;
    }
    /**
     * int SetMin()
     *
     * @param none
     * @return the miniumun number in the inclusive range
     */
    public void SetMin(int min) 
    {
        this.min = min;
        range    = max - min + 1;
    }
    /**
     * void SetMax(int max)
     *
     * @param none
     * @return the miniumun number in the inclusive range
     */
    public void SetMax(int max) 
    {
        this.max = max;
        range    = max - min + 1;
    }
    /**
     * int Generate()
     *
     * @param none
     * @return the miniumun number in the inclusive range
     */
    int Generate()
    {
        return (int)(range * Math.random()) + min; 
    }
}