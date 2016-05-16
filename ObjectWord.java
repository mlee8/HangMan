
/**
 * Write a description of class ObjectWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjectWord extends Word
{
    private String finalHint;
    /**
     * Constructor for objects of class HumanWord
     */
    public ObjectWord(String name1, String description1,String lastHint)
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
        return "This is a solid";
    }

    public String hintCategory()
    {
        return "This is an object ";
    }

    public String getFinalHint()
    {
        return finalHint;
    }
}
