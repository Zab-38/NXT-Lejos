package seph;
import java.awt.List;
import java.util.Random;

  
public class Makeasentence {
	
	
	
 public static void main(String[] args) {
	 String words = "Hi:Bye:Hello:Cheese:Puppies";
		String[] wordsAsArray = words.split(":");

		int index = new Random().nextInt(wordsAsArray.length);

		String randomWord = wordsAsArray[index];
		System.out.println=("Random word: '" + randomWord + "'. It is of length: " + randomWord.length());

}}
    
/**String[] Identify = {"You:I:He:She:Phil"};
String[] Verb = {"Ate:Killed:Urinated:Painted:Licked"};
String[] Noun = {"Bird:My Bladder:Mr. T's sweatshop:Antelope:Male Earlobes"};
String[] wordsAsArray = Identify.split(":");
String randomWord = wordsAsArray[index];
int index = new Random().nextInt(Makeasentence.length);
*/    
   



