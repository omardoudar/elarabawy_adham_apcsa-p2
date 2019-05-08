//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{
	private int xSpeed;
	private int ySpeed;
   //constructors
   public BlinkyBall()
   {
		super(200,200);
		xSpeed = 1;
		ySpeed = 1;
   }

   public BlinkyBall(int x, int y)
   {
	   super(x,y);
	   xSpeed = 1;
		ySpeed = 1;

   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
	   super(x,y,wid,ht);
	   xSpeed = 1;
		ySpeed = 1;


   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,xSpd,ySpd);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);


   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col,xSpd,ySpd);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);


   }
   public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
	 public void setXSpeed(int x) {
		   xSpeed = x;
	   }
	   public void setYSpeed(int y) {
		   ySpeed = y;
	   }
   public Color randomColor()
   {
   		int r = (int) (Math.random() * 255);		//use Math.random()
 		int g = (int) (Math.random() * 255);
 		int b = (int) (Math.random() * 255);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   draw(window,randomColor());
       setX(getX()+xSpeed);
       setY(getY()+ySpeed);
       draw(window,randomColor());
   }
}