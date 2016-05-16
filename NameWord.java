/**
 * Write a description of class HumanWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameWord extends Word
{
    // instance variables - replace the example below with your own
    
    private String finalHint;
    /**
     * Constructor for objects of class HumanWord
     */
    public NameWord(String name1, String description1,String lastHint)
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
        return "This is a mammal";
    }
    public String hint2()
    {
        return "This word is associated with a human";
    }
    public String hintCategory()
    {
        return "This is a Name";
    }
    public String getFinalHint()
    {
        return finalHint;
    }
}