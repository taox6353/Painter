package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class ToolPencil {
	
	int x;
	int y;
	int size;
	Image image;
	
	public ToolPencil(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/penciltoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		x=120;
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

	public void draw(Graphics window,int x,int y,Color color,int size){
		window.setColor(color);
		window.fillRect(x, y, size, size);
	}
}
