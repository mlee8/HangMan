

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HangmanTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HangmanTest
{
    Word a,b,c,d;
    /**
     * Default constructor for test class HangmanTest
     */
    public HangmanTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        a=new NameWord("Michael", "Proper Noun", "His last name is Lee.");
        b=new LocationWord("Stevenson", "Proper Noun", "It is a school");
        c=new ObjectWord("jazz", "noun", "This is a type of music.");
        d=new AnimalWord("yak", "noun", "This is an animal with horns.");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void NameWord1()
    {
        assertEquals("This is a mammal",a.hint1());
    }
    
    @Test
    public void NameWord2()
    {
        assertEquals("This word is associated with a human",a.hint2());
    }
    
    @Test
    public void NameWordCategory()
    {
        assertEquals("This is a Name",a.hintCategory());
    }
    
    @Test
    public void NameWordFinal()
    {
        assertEquals("His last name is Lee.",a.getFinalHint());
    }
    
    @Test
    public void LocationWord1()
    {
        assertEquals("This is not alive",b.hint1());
    }
    
    @Test
    public void LocationWord2()
    {
        assertEquals("This is outdoors",b.hint2());
    }
    
    @Test
    public void LocationWordCategory()
    {
        assertEquals("This is a location/place in nature",b.hintCategory());
    }
    
    @Test
    public void LocationWordFinal()
    {
        assertEquals("It is a school",b.getFinalHint());
    }
    
    @Test
    public void ObjectWord1()
    {
        assertEquals("This is not alive.",c.hint1());
    }
    
     @Test
    public void ObjectWord2()
    {
        assertEquals("This is something that is common in life.",c.hint2());
    }
    
     @Test
    public void ObjectWordCategory()
    {
        assertEquals("This is an object or concept.",c.hintCategory());
    }
    
     @Test
    public void ObjectWordFinal()
    {
        assertEquals("This is a type of music.",c.getFinalHint());
    }
    
    @Test
    public void AnimalWord1()
    {
        assertEquals("This is alive",d.hint1());
    }
    
    @Test
    public void AnimalWord2()
    {
        assertEquals("This is not a human",d.hint2());
    }
    
    @Test
    public void AnimalWordCategory()
    {
        assertEquals("This is an animal.",d.hintCategory());
    }
    
    @Test
    public void AnimalWordFinal()
    {
        assertEquals("This is an animal with horns.",d.getFinalHint());
    }
    
    @Test
    public void PartOfSpeech()
    {
        assertEquals("Proper Noun",a.getPartOfSpeech());
    }
    
    @Test
    public void numLetters()
    {
        assertEquals(7,a.getNumLetters());
    }
    
    @Test
    public void word()
    {
        assertEquals("Michael",a.getWord());
    }
}
