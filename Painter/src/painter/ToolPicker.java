package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ToolPicker {
	
	int x;
	int y;
	int size;
	Image image;
	Color color;
	
	public ToolPicker(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/colorpickertoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		color = Color.WHITE;
		x=225;
		y=0;
		size=30;
		window.drawImage(image,x,y,size,size,null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	
	public Color picker()
	  { 
		JFrame frame = new JFrame();
	    frame.setAlwaysOnTop(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    return JColorChooser.showDialog(frame,"Pick a color",color);
	  }
}
