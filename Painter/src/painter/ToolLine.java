package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class ToolLine {
	
	int x;
	int y;
	int size;
	Image image;
	
	public ToolLine(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/linetoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		x=120;
		y=35;
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

	public void draw(Graphics window,int x1,int y1,int x2,int y2,Color color){
		window.setColor(color);
		window.drawLine(x1, y1, x2, y2);
	}
}
