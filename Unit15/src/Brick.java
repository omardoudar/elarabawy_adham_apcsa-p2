import java.awt.Color;
import java.awt.Graphics;
public class Brick extends Block
{
	private int health;
	
	public Brick() {
		super(20,20);
		setHealth(1);
	}
	public Brick(int x, int y) {
		super(x,y);
		setHealth(1);
	}
	public Brick(int x, int y, int Health) {
		super(x,y);
		setHealth(Health);
	}
	public Brick(int x, int y, int width, int height) {
		super(x,y,width,height);
		setHealth(1);
	}
	public Brick(int x, int y, int width, int height, int Health) {
		super(x,y,width,height);
		setHealth(Health);
	}
	public Brick(int x, int y, int width, int height, Color color,int Health) {
		super(x,y,width,height,color);
		setHealth(Health);
	}
	
	public void getHit() {
		health--;
		checkIfDead();
	}
	public boolean checkIfDead() {
		if(health <= 0) return true;
		if(health == 1) super.setColor(new Color(255, 179, 102));
		if(health == 2) super.setColor(new Color(179, 89, 0));
		return false;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
	}
	public void Draw(Graphics window) {
		   if(!checkIfDead())
			      draw(window);
	 }

	
}