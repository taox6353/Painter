package painter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class PainterRunner extends JFrame implements WindowListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	//private JLabel statusbar;
	Painter theProg;
	private boolean closed = false;
	
	public PainterRunner()
	{
		super("Painter by Xavier Tao");
		setSize(WIDTH,HEIGHT);

		theProg = new Painter();
		((Component)theProg).setFocusable(true);

		getContentPane().add(theProg);
		this.addWindowListener(this);
		
		//statusbar = new JLabel("default");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		PainterRunner run = new PainterRunner();
	}
	public Painter getPainter(){
		return theProg;
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try
        {
			BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	        Graphics2D graphics2D = image.createGraphics();
	        theProg.paint(graphics2D);
	        ImageIO.write(image,"png", new File("src/painter/SAVEFILE.png"));
        }
        catch(Exception exception)
        {
            System.out.println("Could not be saved. ");//+System.getProperty("user.home"));
        }
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
}