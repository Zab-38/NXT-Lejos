package seph;
import java.awt.List;
import java.util.Random;

  
public class Makeasentence {
	
	
	
 public static void main(String[] args) {
	 String Identify = "You:I:He:She:Phil";
	 String Verb = "Ate:Killed:Urinated:Painted:Licked";
	 String Noun = "Bird:My Bladder:Mr. T's sweatshop:Antelope:Male Earlobes";
		String[] IdentifyAsArray = Identify.split(":");
		String[] VerbAsArray = Verb.split(":");
		String[] NounAsArray = Noun.split(":");

		int Identifyindex = new Random().nextInt(IdentifyAsArray.length);
		int Verbindex = new Random().nextInt(VerbAsArray.length);
		int Nounindex = new Random().nextInt(NounAsArray.length);

		String randomIdentification = Identifyindex[index];
		String randomVerb = Verbindex[index];
		String randomNoun = Nounindex[index];
		System.out.println(randomIdentification + randomVerb + "a" + randomNoun);
}}
    
/**String[] Identify = {"You:I:He:She:Phil"};
String[] Verb = {"Ate:Killed:Urinated:Painted:Licked"};
String[] Noun = {"Bird:My Bladder:Mr. T's sweatshop:Antelope:Male Earlobes"};
String[] wordsAsArray = Identify.split(":");
String randomWord = wordsAsArray[index];
int index = new Random().nextInt(Makeasentence.length);
*/    
   



