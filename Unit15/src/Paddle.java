//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	  this(10, 10);
   }

   public Paddle(int x, int y)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(5);
   }
   
   public Paddle (int x, int y, int spee)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(spee);
   }
   
   public Paddle (int x, int y, int width, int height, int spee)
   {
	   super (x, y, width, height, Color.BLACK);
	   setSpeed(spee);
   }
   
   public Paddle (int x, int y, int width, int height, Color col, int spee)
   {
	   super (x, y, width, height, col);
	   setSpeed(spee);
   }
   
   public void setSpeed(int spee)
   {
	   speed = spee;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()-speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()+speed);
	   draw(window);
   }

   public int getSpeed()
   {
	   return speed;
   }   
   
   public String toString()
   {
	   return super.toString()+" "+speed;
   }
   //add a toString() method
}