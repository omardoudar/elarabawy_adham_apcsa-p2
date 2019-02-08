//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
		String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};
		for(String vowel : vowels){
			if (String.valueOf(a.charAt(0)).equals(vowel) || String.valueOf(a.charAt(a.length()-1)).equals(vowel)){
				return "yes";
			}
		}
		return "no";
	}
}