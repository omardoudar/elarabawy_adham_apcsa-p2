//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph, tempTime;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=0.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		this.distance = dist;
		this.hours = hrs;
		this.minutes = mins;
	}

	public void setNums(int dist, int hrs, int mins)
	{
		this.distance = dist;
		this.hours = hrs;
		this.minutes = mins;
	}

	public void calcMPH()
	{
		if (minutes > 0){
			tempTime = minutes/60.0;
			mph = distance/tempTime;
		} else {
			System.out.println("debug");
			mph = 0.0;
		}
	}

	public void print()
	{
		System.out.println(distance + " miles in " + hours + " hours and " + minutes + " minutes = " + mph);
	}
}