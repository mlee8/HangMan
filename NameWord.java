
public class NameWord extends Word
{

    private String finalHint;

    // Creates a new Word that is a Name
    public NameWord(String name1, String description1,String lastHint)
    {
        super(name1,description1);
        finalHint=lastHint;
    }

    // Gives the first hint of the word
    public String hint1()
    {
        return "This is a mammal";
    }

    // Gives the second hint of the word
    public String hint2()
    {
        return "This word is associated with a human";
    }

    // Gives the exact category of the word
    public String hintCategory()
    {
        return "This is a Name";
    }
    // Gives the specific Final Hint of the word
    public String getFinalHint()
    {
        return finalHint;
    }
}