package painter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolSave extends JPanel{
	int x;
	int y;
	int lengthwidth;
	Image image;
	
	public ToolSave(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/savetoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		x=70;
		y=0;
		lengthwidth=30;
		window.drawImage(image,x,y,lengthwidth,lengthwidth,null);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getsize() {
		return lengthwidth;
	}
	

}
