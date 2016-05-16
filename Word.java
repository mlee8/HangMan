public abstract class Word 
{
    private String word; 
    private String partOfSpeech;

    public Word(String name, String description) 
    { 
        word=name; 
        partOfSpeech=description; 

    } 

    // gets the category of the specific word 
    public String getPartOfSpeech() 
    { 
        return partOfSpeech; 
    } 

    // gets the number of letters for the number of slots to fill 
    public int getNumLetters() 
    { 
        return word.length(); 
    } 

    // returns the word 
    public String getWord() 
    { 
        return word; 
    } 

    public abstract String hint1();
    public abstract String hint2();
    public abstract String hintCategory();
    public abstract String getFinalHint();
}