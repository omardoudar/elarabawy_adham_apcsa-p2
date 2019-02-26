//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Adham Elarabawy

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors{
	private String playChoice;
	private String choice;

	public RockPaperScissors(){
		setPlayers("");
	}

	public RockPaperScissors(String player){
		setPlayers(player);
	}

	public void setPlayers(String player){
		playChoice = player.toUpperCase();
		int choice = 0;
		choice = (int) (Math.random() * 3);
		switch (choice){
		case 0:
			choice = 'R';
			break;
		case 1:
			choice = 'S';
			break;
		case 2:
			choice = 'P';
			break;
		}
		
	}

	public String determineWinner(){
		String win = "";
		if (playChoice.equals(choice)){
			win = "!Draw Game!";
		}
		else if (playChoice.equals("R")){
			if (choice.equals("P")){
				win = "!Computer wins <<Paper Covers Rock>>!";
			}
			else{
				win = "!Player wins <<Rock Breaks Scissors>>!";
			}
		}
		else if (playChoice.equals("P")){
			if (choice.equals("R")){
				win = "!Player wins <<Paper Covers Rock>>!";
			}
			else{
				win = "!Computer wins <<Scissors Cuts Paper>>!";
			}
		}
		else if (playChoice.equals("S")){
			if (choice.equals("R")){
				win = "!Computer wins <<Rock Breaks Scissors>>!";
			}
			else{
				win = "!Player wins <<Sissors Cuts Paper>>!";
			}
		}
		return win;	
	}

	public String toString(){
		String outpt= "Player had " + playChoice + "\n" + "Computer had " + choice;
		return outpt;
	}
}