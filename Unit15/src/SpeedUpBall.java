//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables
	private int xSpeed;
	private int ySpeed;
   public SpeedUpBall()
   {
	   super(200,200);
	   xSpeed = 1;
		ySpeed = 1;
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
	   xSpeed = 1;
	   ySpeed = 1;

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);



   }
   public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
   public void setXSpeed( int xSpd )
   {
	   xSpeed = xSpd;
   }

   public void setYSpeed( int ySpd )
   {
	   ySpeed = ySpd;
   }
   public void increaseSpeed(int spd) {
	   if((spd <= 2 && spd > 0) || spd >= -2 && spd < 0) {
		   if(spd < 0) {
			   xSpeed--;
			   
		   }
		   if(spd > 0) {
			   xSpeed++;
			   
		   }
		 }
   }
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window,Color.white);
	       setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      draw(window);
   }
}

