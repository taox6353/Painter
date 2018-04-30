package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class SquarePencil {
	
	Image image;
	
	public SquarePencil(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/penciltoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		window.drawImage(image,80,5,30,30,null);
	}

	public void draw(Graphics window,int x,int y,Color color,int size){
		window.setColor(color);
		window.fillRect(x, y, size, size);
	}
}
