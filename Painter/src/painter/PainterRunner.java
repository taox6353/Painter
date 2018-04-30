package painter;

import javax.swing.*;
import java.awt.Component;

public class PainterRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	//private JLabel statusbar;
	
	public PainterRunner()
	{
		super("Painter by Xavier Tao");
		setSize(WIDTH,HEIGHT);

		Painter theProg = new Painter();
		((Component)theProg).setFocusable(true);

		getContentPane().add(theProg);
		
		//statusbar = new JLabel("default");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		PainterRunner run = new PainterRunner();
	}
}