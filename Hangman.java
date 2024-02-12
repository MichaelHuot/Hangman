// Michael Huot
// Hang Man
import java.util.*;

public class Hangman
{
   // Create method to have computer pick random word from the word bank
   public static String getWord( String [] wordBank)
   {
      Random rand = new Random();
      int i = rand.nextInt(20);
      String randomWord = wordBank[i];
      return randomWord;
   }
   // create method to print hangman based on number of wrong guesses
   public static void Drawing(int num)
   {
      if (num == 0)
      {
         System.out.println("______");
         System.out.println(" |    |\n |\n |\n |\n |\n_|_");
         System.out.println("");
         System.out.println();   
      }
      else if (num == 1)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |\n |\n |\n_|_");
         System.out.println("");
         System.out.println();   
      }
      else if (num == 2)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |    |\n |    |\n |\n_|_");
         System.out.println("");
         System.out.println(); 
      }
      else if (num == 3)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |   \\|\n |    |\n |\n_|_");
         System.out.println("");
         System.out.println(); 
      }
      else if (num == 4)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |   \\|/\n |    |\n |\n_|_");
         System.out.println("");
         System.out.println(); 
      }
      else if (num == 5)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |   \\|/\n |    |\n |   /\n_|_");
         System.out.println("");
         System.out.println(); 
      }
      else if (num == 6)
      {
         System.out.println("______");
         System.out.println(" |    |\n |    O\n |   \\|/\n |    |\n |   / \\\n_|_");
         System.out.println("");
         System.out.println(); 
      }
   }
   
   // Create method to show the user the word with the letter they guessed
   public static void Printword(String word,   List<Character> userGuesses)
   { 
      int i;
      System.out.println("\nLook at secret word: ");
      for (i = 0; i < word.length(); i++)
      {
         if(userGuesses.contains(word.charAt(i)))
         {
            System.out.print(word.charAt(i));
         } 
         else
         {
            System.out.print("-");
         }
      }
   }

   static Scanner scan = new Scanner (System.in); 
   public static void main(String [] args)
   {  
      // Create list of words 
     String [] wordBank = { "HELPS", "BANKS", "STARS", "TROPHY", "LIGHTNING", "BOX", "COMPUTER", "PLAYSTATION",      
                            "LAPTOP", "WALL", "BATTERY", "DOG", "SPARTAN", "WINDED", "SPLIT", "CARES", "KEYBOARD", "MOUSE", "CONDITION", "DRIVE"};
     
     // Create a list with all letters
     List<String> letterBank = new ArrayList<>();
     letterBank.add("A");
     letterBank.add("B");
     letterBank.add("C");
     letterBank.add("D");
     letterBank.add("E");
     letterBank.add("F");
     letterBank.add("G");
     letterBank.add("H");
     letterBank.add("I");
     letterBank.add("J");
     letterBank.add("K");
     letterBank.add("L");
     letterBank.add("N");
     letterBank.add("O");
     letterBank.add("P");
     letterBank.add("Q");
     letterBank.add("R");
     letterBank.add("S");
     letterBank.add("T");
     letterBank.add("U");
     letterBank.add("V");
     letterBank.add("W");
     letterBank.add("X");
     letterBank.add("Y");
     letterBank.add("Z");
     
     // Get word from word bank
     String word = getWord(wordBank);
 
     
     // Create null list of the user guesses
     List<Character> userGuesses = new ArrayList<>();
     
     // Initialize variables
     int count = 0;
     int correctletters = 0;
     boolean solved = false;
     
     // Welcome message to user 
     System.out.println("Welcome to hangman! \n");
     Printword(word, userGuesses);
     // Create while loop to run game until the user guesses the word or the user gets 6 wrong answers
     while (count < 6)
    {
        // Ask user for letter
        System.out.print("\n\nEnter a letter: ");
        String guess = scan.next().toUpperCase();
        char charGuess = guess.charAt(0);
        userGuesses.add(charGuess);
        
        // Check if the the guess is in the word and print results to user
        if (word.contains(guess))
        {
        // Create a for loop to see if the users guess is equal to each character in string
         int i;
         for (i=0; i<=word.length()-1; i++)
            {
              char letter = word.charAt(i);
              if ( letter == charGuess)
                  correctletters +=1;
            }
         Printword(word, userGuesses);
         System.out.println();
         System.out.println("\nYou got a letter correct.");
         Drawing(count);
         letterBank.remove(guess);
         System.out.println("Remaining Letters:");
         System.out.println(letterBank + "\n");
         
         // Check if the user got the word right
         if (correctletters == word.length())
            {
               System.out.println("YOU WIN!!");
               solved = true;
               break;
            }
            
        
        }
        else
        {   
         count += 1;
         System.out.println("\nThat letter isnt in the word.\n");
         Printword(word, userGuesses);
         System.out.println();
         Drawing(count);
         letterBank.remove(guess);
         System.out.println("Remaining Letters:");
         System.out.println(letterBank + "\n");
        }
        
     
      
        } 
      
       if (solved == false)
       {
         System.out.println("YOU LOST! The word was " + word + ".");
       }
       
       
   }
   
   
}