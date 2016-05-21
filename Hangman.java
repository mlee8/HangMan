//Michael Lee, David Hou, Jayden Cho
import java.util.*;
import java.lang.*;

public class Hangman 
{
    private int max=0;
    public static void main(String[] args) 
    {

        //create instance things and lists you'll need later

        Word a=new NameWord("michael", "Proper Noun", "First Letter is M");
        Word b=new NameWord("david", "Proper Noun", "First Letter is D");
        ArrayList<Word> words=new ArrayList<Word>();
        words.add(a);
        words.add(b);
        String next="y";
        while (next.equals("Y") || next.equals("y"))
        {
            int index=(int)(Math.random()*words.size());
            Word WORD=words.get(index);
            char[] letters=WORD.getWord().toCharArray();
            List wrong = new ArrayList();
            char[] progress= new char[WORD.getNumLetters()];
            for(int i=0;i<progress.length;i++)
            {
                progress[i]="_".charAt(0);
            }

            System.out.println("Enter 1 for easy, enter 2 for hard: ");
            int choice=0;
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

            Hangman hangman1=new Hangman();
            hangman1.changeDifficulty(choice); 
            //where the main things happen
            int count=0;
            System.out.println("\n\nPart of Speech: " + WORD.getPartOfSpeech());

            while(count<hangman1.max)
            {      
                String guess1="asdf";
                System.out.print("\nLetters: " + WORD.getNumLetters());
                boolean repeat=true;
                while(guess1.length()!=1 || repeat==true)
                {
                   repeat=false;
                    Scanner scan=new Scanner(System.in);
                    System.out.println("\n \nGuess a letter: ");   
                    guess1=scan.nextLine();
                    if(guess1.length()!=1){
                        System.out.println("\n \nPlease one letter");

                    }
                    if(guess1.length()==1){
                        for(int i=0;i<progress.length;i++)
                        {
                            if (guess1.charAt(0)==(progress[i]))
                            {
                                
                                repeat=true;
                            }
                            
                            
                        }
                        if (repeat)
                            {
                                System.out.println("\nYou have already entered this letter, please enter a new one.");
                            }
                    }

                }
                char guess=guess1.charAt(0);

                boolean correct=false;

                System.out.println("Your current progress is: "); 
                
                for(int i=0;i<letters.length;i++)
                {

                    if(letters[i]==guess)
                    {
                      
                        progress[i]=guess;
                        correct=true;
                    
                    }
                    System.out.print(progress[i]);
                }
                if(correct==false)
                {
                    wrong.add(guess);
                    count++;
                }

                System.out.println("\nYou have guessed: "+ "\t\t" + "Guesses Left: "+ + (hangman1.max-count));   

                for(int i=0;i<wrong.size();i++)
                {
                    System.out.print(wrong.get(i) + " ");
                }
                if(correct==false)
                {
                    if (count==3)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hint1());
                    }
                    else if(count==4)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hint2());
                    }
                    else if(count==5)
                    {
                        System.out.println("\n\nCLUE:"+ WORD.hintCategory());
                    }
                    else if(count==6)
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
                System.out.println("\nYou Lost!!!\n");
                System.out.println("The word was: " + WORD.getWord() + "\n");
            }
            System.out.println("Keep Going? Enter Y to continue, anything else to quit: ");
            Scanner scan = new Scanner(System.in);
            next = scan.nextLine();

        }
        System.exit(0);
    }

    public void changeDifficulty(int choice1)
    {
        if (choice1==1)
        {
            max=10;
        }
        else if (choice1==2)
        {
            max=7;
        }
    }

}