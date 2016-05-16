public class LocationWord extends Word
{
    // instance variables - replace the example below with your own
    
    private String finalHint;
    /**
     * Constructor for objects of class HumanWord
     */
    public LocationWord(String name1, String description1,String lastHint)
    {
        super(name1,description1);
        finalHint=lastHint;
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public String hint1()
    {
        return "This is not alive";
    }
    public String hint2()
    {
        return "This is outdoors";
    }
    public String hintCategory()
    {
        return "This is a location/place in nature";
    }
    public String getFinalHint()
    {
        return finalHint;
    }
}