//Michael Lee, David Hou, Jayden Cho
import java.util.*;
import java.lang.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class Hangman 
{
    private int max=0;
    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) 
    {
        /**
         * creates panel and frame, where it will make graphics
         */
        JFrame frame = new JFrame();

        frame.setSize(200,375); 
        frame.setTitle("Hangman"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graphiks yy = new Graphiks();
        frame.add(yy);

        frame.setVisible(true);
        System.out.println('\f');
        //creates instances of Word and an ArrayList of Word objects.
        String man[] = new String[7];
        // man[0] = " --\n   |\n   |\n   |\n_____\n";
        //man[1] = " --\n o |\n   |\n   |\n_____\n";
        // man[2] = " --\n o |\n/  |\n   |\n_____\n";
        //man[3] = " --\n o |\n/| |\n   |\n_____\n";
        // man[4] = " --\n o |\n/|\\|\n   |\n_____\n";
        // man[5] = " --\n o |\n/|\\|\n/  |\n_____\n";
        System.out.println("\t\t WELCOME TO THE GAME OF HANGMAN");
        System.out.println("\n\t Created by: Michael Lee, David Hou, Jayden Cho");
        System.out.print("\n\n");
        man[6] = "\t\t\t\t--\n\t\t\t\t o |\n\t\t\t\t/|\\|\n\t\t\t\t/ \\|\n\t\t\t\t_____\n\t\t\t\t";

        System.out.println(man[6]);
        System.out.print("\n\n"); 
        System.out.println("Enter anything to begin game:");
        Scanner scan2=new Scanner (System.in);
        String choice2=scan2.nextLine();

        Word a=new NameWord("Michael", "Proper Noun", "His last name is Lee.");
        Word b=new NameWord("David", "Proper Noun", "Hou is he doing?");
        Word c=new NameWord("Jayden", "Proper Noun", "He is a Korean male.");
        Word d=new NameWord("Abhi", "Proper Noun", "This is a Bee.");
        Word y=new NameWord("Basit", "Proper Noun", "He is related to Zayn Malik.");

        Word f=new LocationWord("Stevenson", "Proper Noun", "It is a school");
        Word gg=new LocationWord("Hollywood", "Proper Noun", "It is a sign.");
        Word h=new LocationWord("Chicago", "Proper Noun", "This is the Windy City.");
        Word z=new LocationWord("Yellowstone", "Proper Noun", "It is a park.");
        Word j=new LocationWord("Stonehenge", "Proper Noun", "It is a rocky thing in England.");

        Word k=new AnimalWord("yak", "noun", "This is an animal with horns.");
        Word l=new AnimalWord("buffalo", "noun", "Wild Wings");
        Word m=new AnimalWord("elephant", "noun", "Banana Republic logo.");
        Word n=new AnimalWord("orangutan", "noun", "This is a primate.");
        Word o=new AnimalWord("lizard", "noun", "The gecko from Geico is this animal.");

        Word p=new ObjectWord("jazz", "noun", "This is a type of music.");
        Word q=new ObjectWord("bagpipes", "noun", "This is an instrument in Europe.");
        Word r=new ObjectWord("BlueJ", "Proper Noun", "This is a Computer thing.");
        Word s=new ObjectWord("Adidas", "Proper Noun", "This is a brand.");
        Word t=new ObjectWord("basketball", "noun", "This is a sport.");

        ArrayList<Word> words=new ArrayList<Word>();
        words.add(a);words.add(b);words.add(c);words.add(d);words.add(y);words.add(f);words.add(gg);words.add(h);words.add(z);words.add(j); 
        words.add(k);words.add(l);words.add(m);words.add(n);words.add(o);words.add(p);words.add(q);words.add(r);words.add(s);words.add(t);
        String next="y";

        //while loop to run the game multiple times if user enters y
        while (next.equals("Y") || next.equals("y"))
        {
            //chooses a random word in words ArrayList to use for the game
            //creates character array letters for the random word that was chosen, creates an ArrayList "wrong" to add wrong guesses to
            //creates ArrayList wrong of Characters to keep track of wrong guesses
            //creates character array progress to keep track of correct guesses 
            yy.resetCount();
            System.out.println('\f');
            int index=(int)(Math.random()*words.size());
            Word WORD=words.get(index);
            char[] letters=WORD.getWord().toCharArray();
            ArrayList<Character> wrong = new ArrayList<Character>();
            char[] progress= new char[WORD.getNumLetters()];
            for(int i=0;i<progress.length;i++)
            {
                progress[i]="_".charAt(0);
            }

            int choice = 0;   
            //this outer while loop makes sure that either 1 or 2 was entered for difficulty. Prompts user to re-enter a difficulty
            while (choice!=1 && choice!=2)
            {
                System.out.println("Please Enter 1 for easy, enter 2 for hard: q");

                //exception caused by not entering an integer for difficulty is caught. Prompts user to re-enter a difficulty
                boolean isCorrect=false;
                while (isCorrect==false)
                {
                    try
                    {

                        //nextInt will throw InputMismatchException
                        //if the next token does not match the Integer
                        //regular expression, or is out of range
                        Scanner scan1=new Scanner (System.in);
                        choice=scan1.nextInt();
                        isCorrect=true;
                    }
                    catch(InputMismatchException exception)
                    {
                        //Print "This is not an integer"
                        //when user put other than integer
                        System.out.print("This is not an integer, " );
                        System.out.println("please enter 1 or 2: ");
                    }
                }
            }

            System.out.println('\f');
            Hangman hangman1=new Hangman();
            hangman1.changeDifficulty(choice); 
            //where the main things happen
            int count=0;
            System.out.println("\n\nPart of Speech: " + WORD.getPartOfSpeech());

            while(count<hangman1.max)
            {   
                frame.repaint();
                String guess1="asdf";
                System.out.print("\nLetters: " + WORD.getNumLetters());
                boolean repeat=true;
                boolean exception=false;
                //Checks if input is valid. Input must be only one letter and have not been guessed yet.
                while(guess1.length()!=1 || repeat==true)
                {
                    repeat=false;
                    System.out.println("\n \nGuess a letter: "); 
                    
                    //catches exception if number is entered instead of letter
                    try{
                        Scanner scan=new Scanner(System.in);
                        guess1=scan.next();
                        exception=true;
                    } catch(InputMismatchException e) {
                        System.out.println("Please do not enter a number, enter a letter: ");
                    }
                    
                    if(guess1.length()!=1){
                        System.out.println("\n \nPlease enter one letter");

                    }
                    if(guess1.length()==1){
                        for(int i=0;i<progress.length;i++)
                        {
                            if (Character.toLowerCase(guess1.charAt(0))==Character.toLowerCase((progress[i])))
                            {
                                repeat=true;
                            }
                        }
                        if(wrong.contains(guess1.charAt(0)))
                        {
                            repeat=true;
                        }
                        if (repeat)
                        {
                            System.out.println("\nYou have already entered this letter, please enter a new one.");
                        }
                    }
                }
                System.out.println('\f');

                char guess=guess1.charAt(0);

                boolean correct=false;

                System.out.println("Your current progress is: "); 

                //Checks to see if the guess is a letter in the word. If it is, it will add the character guess into progress array and print it. 
                //Makes guesses case insensitive, but will make proper nouns have first letter capital even if guess was lowercase when progress is displayed.
                for(int i=0;i<letters.length;i++)
                {
                    if(Character.toLowerCase(letters[i])==Character.toLowerCase(guess))
                    {
                        if (WORD.getPartOfSpeech().equals("Proper Noun")&& i==0)
                        {

                            progress[i]=Character.toUpperCase(guess);
                            correct=true;
                        }
                        else
                        {
                            progress[i]=Character.toLowerCase(guess);
                            correct=true;
                        }
                    }
                    System.out.print(progress[i]);
                }
                
                //adds incorrect letters to array, draws parts of Hangman when guesses are incorrect 
                if(correct==false)
                {
                    wrong.add(guess);
                    count++;
                    yy.nextCount();
                    frame.add(yy);
                    frame.setVisible(true);
                }

                System.out.println("\nYou have guessed incorrectly: "+ "\t\t" + "Guesses Left: "+ + (hangman1.max-count));   
                for(int i=0;i<wrong.size();i++)
                {
                    System.out.print(wrong.get(i) + " ");
                }
                
                //prints clue according to amount of incorrect guesses 
                if(correct==false)
                {
                    if (count==2)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hint1());
                    }
                    else if(count==3)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hint2());
                    }
                    else if(count==4)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hintCategory());
                    }
                    else if(count==5)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.getFinalHint());
                    }
                }
                if (Arrays.equals( letters,  progress))
                {
                    System.out.println ("\n\nCongrats, you have guessed the word");
                    count=hangman1.max;
                    words.remove(index);
                }
            }
            
            if (!Arrays.equals( letters,  progress))
            {
                frame.repaint();
                System.out.println("\nYou Lost!!!\n");
                System.out.println("The word was: " + WORD.getWord() + "\n"); 
            }
            System.out.println("Keep Going? Enter Y to continue, anything else to quit: ");
            Scanner scan = new Scanner(System.in);
            next = scan.nextLine();
            if(scan.equals("y")) 
                yy.resetCount();
        }
        System.exit(0);
    }

    //method to link a variable for maximum guesses to a chosen difficulty
    public void changeDifficulty(int choice1)
    {
        if (choice1==1)
        {
            max=9;
        }
        else if (choice1==2)
        {
            max=6;
        }
    }

}