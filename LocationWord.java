/**
 * Hangman
 * Michael Lee, David Hou, Jayden Cho
 * Final APCS Project 
 */
public class LocationWord extends Word
{
    private String finalHint;

    // Creates a new Word that is a Location
    public LocationWord(String name1, String description1,String lastHint)
    {
        super(name1,description1);
        finalHint=lastHint;
    }

    // Gives the first hint of the word
    public String hint1()
    {
        return "This is not alive";
    }
    // Gives the second hint of the word
    public String hint2()
    {
        return "This is outdoors";
    }
    // Gives the exact category of the word
    public String hintCategory()
    {
        return "This is a location/place in nature";
    }
    // Gives the specific Final Hint of the word
    public String getFinalHint()
    {
        return finalHint;
    }
}