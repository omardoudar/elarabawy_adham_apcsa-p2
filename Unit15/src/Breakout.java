
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int BALL_THRESHOLD = 0; //DEBUG: lower to make rounds end faster
	private final int FUDGE_FACTOR_1 = 545; //upper paddle restriction
	private final int FUDGE_FACTOR_2 = 92; //lower paddle restriction
	
	private Ball ball;
	private Paddle leftPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int speed = 2;
	private int brickX = 3;
	private int brickY = 2;
	private int spacing= 6;
	private Color brickColor = new Color(77,38,0);
	private ArrayList<Brick> brickList;
	
	Graphics2D twoDGraph;
	Graphics graphToBack;
	
	public Breakout(int WIDTH, int HEIGHT){
		SCREEN_WIDTH = WIDTH;
		SCREEN_HEIGHT = HEIGHT;
		gameStart(3);
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
	  
   }
   
   public void gameStart(int health) {
	   	//populating the screen with the bricks.
	   	populateBricks(health);
	   	
		//instance init
		ball = new Ball(200,200,10,10,-1,-1);
		leftPaddle = new Paddle(0,0,40,40,Color.BLACK,speed);
		keys = new boolean[4];
		ball.setColor(new Color(0,153,0));
   
		setBackground(Color.WHITE);
		setVisible(true);
   }
   
   public void restart() {
	   	gameStart(3);
   }
   public void paint(Graphics window)
   {
	   	graphicsInit(window);
	   	
	   	//draw all of the bricks
		for(Brick i : brickList) {
			i.draw(graphToBack);
		}
		
		//draw ball and paddle
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);

		//check and act accordingly to all collisions involving balls
		ballCollisionDetection();
		
		//round check
		if(brickList.size()<=BALL_THRESHOLD) restart();
		
		//check and act accordingly to all collisions involving bricks
		brickCollisionDetection();
		
		//check and act accordingly to all collisions involving paddles
		paddleCollisionDetection();
				
		//move the paddle according to keyboard input from the user
		paddleMotionFromKeyboard(window);		

		twoDGraph.drawImage(back, null, 0, 0);
	}
   public void graphicsInit(Graphics window) {
	    twoDGraph = (Graphics2D)window;
		back = (BufferedImage)(createImage(getWidth(),getHeight()));
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		graphToBack = back.createGraphics();
   }
   public void paddleMotionFromKeyboard(Graphics window) {
	   if(keys[0] == true) leftPaddle.moveDownAndDraw(window);
	   if(keys[1] == true) leftPaddle.moveUpAndDraw(window);
	   if(keys[2] == true) leftPaddle.moveLeftAndDraw(window);
	   if(keys[3] == true) leftPaddle.moveRightAndDraw(window);
   }
   public void paddleCollisionDetection() {
	   //paddle hits top/bottom wall 
	   if(!(leftPaddle.getY()>=FUDGE_FACTOR_2 && leftPaddle.getY()<= FUDGE_FACTOR_1 - leftPaddle.getHeight())){
		   if(leftPaddle.getY() <=FUDGE_FACTOR_2) leftPaddle.setY(FUDGE_FACTOR_2);
 			if(leftPaddle.getY() >=FUDGE_FACTOR_1-leftPaddle.getHeight()) leftPaddle.setY(FUDGE_FACTOR_1-leftPaddle.getHeight());
 		}
	   
 		//paddle hits right/left wall
 		if(!(leftPaddle.getX()>=FUDGE_FACTOR_2 && leftPaddle.getX()<=FUDGE_FACTOR_1 - leftPaddle.getWidth())){
 			if(leftPaddle.getX()<= FUDGE_FACTOR_2) leftPaddle.setX(FUDGE_FACTOR_2);
 			if(leftPaddle.getX() >= FUDGE_FACTOR_1-leftPaddle.getWidth()) leftPaddle.setX(FUDGE_FACTOR_1 -leftPaddle.getWidth());
 		}
 		
 		//ensure that the paddle is always going the right speed
 		leftPaddle.setSpeed(speed);

   }
   public void ballCollisionDetection() {
	   //ball hits right/left borders
	   ball.setXSpeed(((ball.getX() <= 0 || ball.getX() >= SCREEN_WIDTH) ? -1 : 1) * ball.getXSpeed());
	   
	   
		//ball hits top/bottom borders
	   ball.setYSpeed((ball.getY() <= 0 || ball.getY() >= SCREEN_HEIGHT) ? -1 : 1 * ball.getYSpeed());

		//ball hits right side of paddle
		if((ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()) && (ball.getX() > leftPaddle.getX()) && (ball.getY() >= leftPaddle.getY()) && (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight() - 2)){
			if(ball.getXSpeed() < 0) ball.setXSpeed(-ball.getXSpeed());
			else ball.setX(ball.getX() + ball.getWidth());
			
		}
		
		//ball hits left side of paddle
		if ((ball.getX()+ ball.getWidth() >= leftPaddle.getX()) && (ball.getX() < leftPaddle.getX() + leftPaddle.getWidth()) && (ball.getY() >= leftPaddle.getY()) && (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight() - 2)){
			if(ball.getXSpeed() > 0) ball.setXSpeed(-ball.getXSpeed());
			else ball.setX(ball.getX() - ball.getWidth());
	    }
		
		//ball hits top of paddle
		if((ball.getY()+ ball.getHeight() >= leftPaddle.getY()) && (ball.getY() < leftPaddle.getY() + leftPaddle.getHeight()) && (ball.getX() >= leftPaddle.getX()) && (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()-2)){
			if(ball.getYSpeed() < 0) ball.setY(ball.getY() - ball.getHeight());	
			else ball.setYSpeed(-ball.getYSpeed());
		}
		
		//ball hits bottom of paddle
		if ((ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()) && (ball.getY() > leftPaddle.getY()) && (ball.getX() >= leftPaddle.getX()) && (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()-2)){
				if(ball.getYSpeed() > 0) ball.setY(ball.getY() + ball.getHeight());
				else ball.setYSpeed(-ball.getYSpeed());
	    }
   }
   public void brickCollisionDetection() {
	   ArrayList<Brick> bricksToRemove = new ArrayList<Brick>();
		for(Brick brick : brickList) {
			if(((ball.getX() + ball.getWidth() >= brick.getX()) && (ball.getX() <= brick.getX() + brick.getWidth())) && 
					((ball.getY() + ball.getHeight() >= brick.getY() && (ball.getY() <= brick.getY() + brick.getHeight())))) {
				bricksToRemove.add(brick);
				if(ball.getX() == brick.getX() + brick.getWidth() || ball.getX() + ball.getWidth() == brick.getX()) ball.setXSpeed(-ball.getXSpeed());
				else ball.setYSpeed(-ball.getYSpeed());
				break;
			}
		}
		for(Brick brick : bricksToRemove) {
			brick.getHit();
			if(brick.checkIfDead()) brickList.remove(brick);
		}	
	}
   
   public void populateBricks(int health) {
	   brickList = new ArrayList<Brick>();
	   int xVal = 5;
	   int yVal = 5;
	   //top bar 1
	   while(xVal < SCREEN_WIDTH - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   xVal += 45;
	   }
	   xVal = 5;
	   yVal = 50;
	   //top bar 2
	   while(xVal < SCREEN_WIDTH - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   xVal += 45;
	   }
	   
	   //bottom bar 1
	   xVal = 95;
	   yVal = SCREEN_HEIGHT - 10;
	   while(xVal < SCREEN_WIDTH - 95) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   xVal += 45;
	   }
	   
	   //bottom bar 2
	   xVal = 95;
	   yVal = SCREEN_HEIGHT - 55;
	   while(xVal < SCREEN_WIDTH - 95) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   xVal += 45;
	   }
	   
	   //left bar 1
	   xVal = 5;
	   yVal = 95;
	   while(yVal < SCREEN_HEIGHT - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   yVal += 45;
	   }
	   //left bar 2
	   xVal = 50;
	   yVal = 95;
	   
	   while(yVal < SCREEN_HEIGHT - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   yVal += 45;
	   }
	   
	   //right bar 1
	   yVal = 95;
	   xVal = SCREEN_HEIGHT - 10;
	   while(yVal < SCREEN_HEIGHT - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   yVal += 45;
	   }
	   
	   //right bar 2
	   yVal = 95;
	   xVal = SCREEN_HEIGHT - 55;
	   while(yVal < SCREEN_HEIGHT - 5) {
		   brickList.add(new Brick(xVal, yVal, 40, 40, brickColor, health));
		   yVal += 45;
	   }
   }
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'A' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
		case 'W' : keys[0]=false; break;
		case 'S' : keys[1]=false; break;
		case 'A' : keys[2]=false; break;
		case 'D' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(2);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}