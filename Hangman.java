import java.util.*;
import java.lang.*;
import java.io.IOException;
public class Hangman 
{
    private int max=0;
    public static void main(String[] args) throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        //create instance things and lists you'll need later

        Word a=new NameWord("michael", "Proper Noun", "First Letter is M");
        Word b=new NameWord("david", "Proper Noun", "First Letter is D");
        ArrayList<Word> words=new ArrayList<Word>();
        words.add(a);
        words.add(b);

        Word WORD=words.get((int)(Math.random()*words.size()));
        char[] letters=WORD.getWord().toCharArray();
        List wrong = new ArrayList();
        char[] progress= new char[WORD.getNumLetters()];
        for(int i=0;i<progress.length;i++)
        {
            progress[i]="_".charAt(0);
        }

        Scanner scan1=new Scanner (System.in);
        System.out.println("Enter 1 for easy, enter 2 for hard: ");
        int choice=scan1.nextInt();
        Hangman hangman1=new Hangman();
        hangman1.changeDifficulty(choice);

        //where the main things happen
        int count=1;
        
        while(wrong.size()<hangman1.max)
        {
            
            Scanner scan=new Scanner(System.in);
            System.out.println("\n \n \nGuess a letter: ");   
            String guesss = scan.nextLine();
            char guess = guesss.charAt(0);
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
            System.out.println("\nYou have guessed: ");   
            for(int i=0;i<wrong.size();i++)
            {
                System.out.print(wrong.get(i));
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
                else if(count>5)
                {
                    System.out.println("\n\nCLUE:"+ WORD.getFinalHint());
                }
                
                count++;
            }
            
            if (Arrays.equals( letters,  progress))
            {
                System.out.println ("\n\nCongrats, you have guessed the word");
                System.exit(0);
            }
            
            
        }
      
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
