/**
 * Hangman
 * Michael Lee, David Hou, Jayden Cho
 * Final APCS Project 
 */
public class ObjectWord extends Word
{
    private String finalHint;

    // Creates a new Word that is an Object
    public ObjectWord(String name1, String description1,String lastHint)
    {
        super(name1,description1);
        finalHint=lastHint;
    }
    // Gives the first hint of the word
    public String hint1()
    {
        return "This is not alive.";
    }
    // Gives the second hint of the word
    public String hint2()
    {
        return "This is something that is common in life.";
    }
    // Gives the exact category of the word
    public String hintCategory()
    {
        return "This is an object or concept.";
    }
    // Gives the specific Final Hint of the word
    public String getFinalHint()
    {
        return finalHint;
    }
}
