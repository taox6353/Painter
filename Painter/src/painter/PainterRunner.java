package painter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class PainterRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	//private JLabel statusbar;
	Painter theProg;
	
	public PainterRunner()
	{
		super("Painter by Xavier Tao");
		setSize(WIDTH,HEIGHT);

		theProg = new Painter();
		((Component)theProg).setFocusable(true);

		getContentPane().add(theProg);
		
		//statusbar = new JLabel("default");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		save();
	}

	public static void main( String args[] )
	{
		PainterRunner run = new PainterRunner();
	}
	public void save()
	{
		try
        {
			BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	        Graphics2D graphics2D = image.createGraphics();
	        theProg.paint(graphics2D);
	        ImageIO.write(image,"png", new File("/Desktop/SAVEFILE.png"));
	        		//+ "////Painter/src/painter/SAVEFILE.png"));
        }
        catch(Exception exception)
        {
            System.out.println("Could not be saved. "+System.getProperty("user.home"));
        }
		
	}
}