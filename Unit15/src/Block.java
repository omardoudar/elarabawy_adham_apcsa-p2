//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 100;
		width = 10;
		height = 10;
		color = Color.GREEN;

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y) {
		setPos(x,y);
		width = 10;
		height = 10;
		color = Color.GREEN;
	}
	public Block(int x, int y, int width) {
		setPos(x , y);
		setWidth(width);
		height = 10;
		color = Color.GREEN;
		
	}
	
	public Block(int x, int y, int width, int height) {
		setPos(x,y);
		setWidth(width);
		setHeight(height);
		color = Color.GREEN;
	}
	
	public Block(int x, int y, int width, int height, Color color) {
		setPos(x,y);
		setWidth(width);
		setHeight(height);
		setColor(color);
	}
   //add the other set methods
	public void setPos(int x , int y) {
		setX(x);
		setY(y);
	  }
	   
	  public void setX(int x) {
		  xPos = x;
	  }
	   
	  public void setY(int y) {
		  yPos = y;
	  }
	   
	  public void setHeight(int h) {
		  height = h;
	  }
	   
	  public void setWidth(int w) {
		  width = w;
	   }

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
	   window.setColor(color);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		Block temp = (Block) obj;
		if(xPos == temp.getX() && yPos == temp.getY() && width == temp.getWidth() && height == temp.getHeight() && color.getRGB() == temp.getColor().getRGB()) {
			return true;
		}
		return false;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}   
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}
   //add the other get methods
    
	public String toString() {
		return xPos + "," + yPos + "," + width + "," + height + "," + color.toString();
	}
   //add a toString() method  - x , y , width, height, color
}