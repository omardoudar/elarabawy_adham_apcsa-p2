public class Magpie4
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement, "dog") >= 0 || findKeyword(statement, "cat") >= 0)
		{
			response = "Tell me more about your pets.";
		}

		else if (findKeyword(statement, "teacher") >= 0 || findKeyword(statement, "Ms.") >= 0)
		{
			response = "That sounds like an amazing teacher.";
		}
		else if (statement.trim() == "" || statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "friend") >= 0)
		{
			response = "Tell me more about them.";
		}
		else if (findKeyword(statement, "me") >= 0 || findKeyword(statement, "myself") >= 0 || statement.indexOf("I") >= 0)
		{
			response = "Tell me more about you.";
		}
		else if (findKeyword(statement, "HAHA") >= 0)
		{
			response = "hehe";
		}
		else if (findKeyword(statement, "Thanks") >= 0)
		{
			response = "You're welcome!";
		}
		else if (findKeyword(statement, "happy") >= 0)
		{
			response = "Good.";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else
		{
			response = getRandomResponse();
		}

		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int ptrn = findKeyword(statement, "I", 0);

			if (ptrn >= 0 && findKeyword(statement, "you", ptrn) >= 0){
				response = transformYouMeStatement(statement);
			}
			else{
				response = getRandomResponse();
			}
		}
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals(".")){
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int ptrn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(ptrn + 6).trim();
		return "Would you be happy if you had  " + restOfStatement + "?";
	}	
	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI + 1);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
	

	
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given target is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param target the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of target in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String target, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int ptrn = phrase.toLowerCase().indexOf(target.toLowerCase(), startPos);
		
		//  Refinement--make sure the target isn't part of a word 
		while (ptrn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (ptrn > 0){
				before = phrase.substring (ptrn - 1, ptrn).toLowerCase();
			}
			if (ptrn + target.length() < phrase.length()){
				after = phrase.substring(ptrn + target.length(), ptrn + target.length() + 1).toLowerCase();
			}
			
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0)) 
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return ptrn;
			}
			
			ptrn = phrase.indexOf(target.toLowerCase(), ptrn + 1);
			
		}
		
		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given target is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param target the string to search for
	 * @return the index of the first occurrence of target in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String target)
	{
		return findKeyword (statement, target, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, please tell me more...";
		}
		else if (whichResponse == 1)
		{
			response = "Hmm... Interesting";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really believe that?";
		}
		else if (whichResponse == 3)
		{
			response = "Really? What!!?!";
		}
		else if (whichResponse == 4)
		{
			response = "What?";
		}
		else if (whichResponse == 5)
		{
			response = "Please explain why.";
		}

		return response;
	}

}
