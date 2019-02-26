//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Adham Elarabawy

import static java.lang.System.*;

public class TriangleFiveRunner{
   public static void main(String args[]){
	   TriangleFive run = new TriangleFive('C', 4);
	   out.println(run);
	   run.setLetter('A');
	   run.setAmt(5);
	   out.println(run);
	   run.setLetter('B');
	   run.setAmt(7);
	   out.println(run);
	   run.setLetter('X');
	   run.setAmt(6);
	   out.println(run);
	   run.setLetter('Z');
	   run.setAmt(8);
	   out.println(run);
   }
}