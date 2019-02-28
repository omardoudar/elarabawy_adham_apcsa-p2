//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Adham Elarabawy

public class RayDown{
	public static boolean go(int[] numArray){
		for (int i = 1; i < numArray.length; i++) {
			if (numArray[i] >= numArray[i - 1]) return false;
		}
		return true;
	}
}