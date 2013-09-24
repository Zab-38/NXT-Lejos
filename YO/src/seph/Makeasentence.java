package seph;

import java.util.Random;

public class Makeasentence {

	String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
	String pronouns = "a:an";
	String identify = "You:I:He:She:Phil:Mr. Uvula";
	String Verb = "Ate:Killed:Urinated:Painted:Licked:Salivated";
	String noun = "Bird:Bladder:Korean Sweatshop:Turtle Nipple:Male Earlobe:Piece of Troll Feces:Antelope:Excavation Rig:Islamic Mosquito";

	String[] identifyAsArray = identify.split(":");
	String[] verbAsArray = Verb.split(":");
	String[] nounAsArray = noun.split(":");
	String[] pronounAsArray = pronouns.split(":");

	private boolean isConsonant(char ch)
	{
		String firstChar = "";
		firstChar += ch;

		if(consonants.contains(firstChar))return true;
		
		else return false;
			
	}

	public void makeSentence() {
		int Identifyindex = new Random().nextInt(identifyAsArray.length);
		int Verbindex = new Random().nextInt(verbAsArray.length);
		int Nounindex = new Random().nextInt(nounAsArray.length);
		
		String randomIdentification = identifyAsArray[Identifyindex];
		String randomVerb = verbAsArray[Verbindex];
		String randomNoun = nounAsArray[Nounindex];
		String pronoun = "";

		char firstLetter = randomNoun.charAt(0);
		
		if(isConsonant(firstLetter))
		{
			//do something if first letter is a consonant
			pronoun = pronounAsArray[0];
		}
		else
		{
			//it is not a consonant
			
			pronoun = pronounAsArray[1];
		}



		
		System.out.println(randomIdentification + " " + randomVerb + " " + pronoun
				+ " " + randomNoun + ".");
   
	}


	public static void main(String[] args) {


		Makeasentence ms = new Makeasentence();
		
		for(int i = 0; i < 10; i++)
		{
			ms.makeSentence();
		}
		
	}
}

/**
 * String[] Identify = {"You:I:He:She:Phil"}; String[] Verb =
 * {"Ate:Killed:Urinated:Painted:Licked"}; String[] Noun =
 * {"Bird:My Bladder:Mr. T's sweatshop:Antelope:Male Earlobes"}; String[]
 * wordsAsArray = Identify.split(":"); String randomWord = wordsAsArray[index];
 * int index = new Random().nextInt(Makeasentence.length);
 */

