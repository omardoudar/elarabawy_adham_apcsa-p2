//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame2 extends JFrame
{
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;

	public TheGame2()
	{
		super("Breakout");
		setSize(WIDTH + 37,HEIGHT + 55);

		Breakout game = new Breakout(WIDTH, HEIGHT);

		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		TheGame2 run = new TheGame2();
	}
}