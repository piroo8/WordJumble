import java.util.Scanner;
/**
 * WordJumble
 *
 * Program will determine and print a list all of the “word” possibilities from a set of letters input by the user.
 * 
 * @author Pierre Ishak
 * 
 * @version Dec 16, 2020
 */
public class WordJumbleIshP
{
  public static void main(String[] args) 
  {
    String word="",jumblet="",allWords="";
    
    printProgramDescription();
    word = getWord();
    jumbleWords(word, jumblet);
  }
  /**
   * Prints out program description to the user
   */
  public static void printProgramDescription()
  {
    //Prints Program Description
    System.out.println("Hello!\nThis program will determine and print a list all of the “word” possibilities from a set of letters entered by you.");
  }
  /**
   * Gets user input that isn't empty that user wants to be jumbled
   * 
   * @return The user's input that will be jumbled
   */
  public static String getWord()
  {
    Scanner input = new Scanner(System.in);
    String inputStr="",errMsg;
    boolean isNotValidCode = true;
    
    do
    {  
      System.out.println("\nPlease enter a word: "); 
      inputStr = input.nextLine();
      
      errMsg = "Sorry, \" " + inputStr + " \" is empty";
      
      if (inputStr == null)
      {
        break;
      }
      
      try
      {   
        if(inputStr.trim().replaceAll(" ","").isEmpty())
        {
          Integer.parseInt("a");
        }
        
        isNotValidCode = false;  
      }
      catch (NumberFormatException error)
      {
        System.out.print(errMsg);
      }
      
    }while(isNotValidCode);
    
    return inputStr;
  }
  /**
   * Jumbles the user inputted word to create all posible combinations.
   * 
   * @param word The remaining letters in the word still to jumble
   * @param jumbLet The letters already used to create
   */
  public static void jumbleWords(String word, String jumbLet) 
  {
    int pos;
    String remainingLetters;
    String origWord = word;
    String origJumbledLetters = jumbLet;
    String allWords="";
    
    if (word.length() == 1) 
    {
      allWords += jumbLet + word + "\n";
    } 
    else 
    {
      for (pos = 0; pos < origWord.length(); pos++) 
      {
        remainingLetters = origWord.substring(0, pos) + origWord.substring(pos + 1, origWord.length());
        //recursive call to jumbleWords()
        jumbleWords(remainingLetters,origJumbledLetters + origWord.charAt(pos));
      }
    }
    printResults(allWords);
  }
  /**
   * Prints out all the combinations of the words in on string
   * 
   * @param allWords All the combinations of the words in on string
   */
  public static void printResults(String allWords)
  {
    System.out.print(allWords);
  }
}