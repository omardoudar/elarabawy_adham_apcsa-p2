//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Adham Elarabawy

import static java.lang.System.*;

public class BiggestDouble
{
	private double one, two, three, four;

	public BiggestDouble(){
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d){
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d){
		this.one = a;
		this.two = b;
		this.three = c;
		this.four = d;
	}

	public double getBiggest(){
		double a = Math.max(this.one, this.two);
		double b = Math.max(this.three, this.four);
		if (a > b){
			return a;
		}
		else{
			return b;
		}
	}

	public String toString(){
	   return this.one + ", " + this.two + ", " + this.three + ", " + this.four + "\n" + "biggest = " + getBiggest();
	}
}