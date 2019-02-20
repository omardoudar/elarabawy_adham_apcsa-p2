
public class Magpie2
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
		return response;
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
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Huh?";
		}
		else if (whichResponse == 5)
		{
			response = "Why?";
		}
		

		return response;
	}
}
