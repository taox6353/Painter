package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class ToolFillRect {
	
	int x;
	int y;
	int size;
	Image image;
	
	public ToolFillRect(Graphics window){
		try
		{
			image = ImageIO.read(new File("src/painter/fillrecttoolico.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		x=190;
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
		//rect dragged from top left to bottom right
		if(x2-x1>0&&y2-y1>0){
			window.fillRect(x1, y1, x2-x1, y2-y1);
		}
		//rect dragged from bottom right to top left
		else if(x2-x1<0&&y2-y1<0){
			window.fillRect(x2, y2, x1-x2, y1-y2);
		}
		//rect dragged from bottom left to top right
		else if(x2>x1&&y1>y2){
			window.fillRect(x1, y2, x2-x1, y1-y2);
		}
		//rect dragged from top right to bottom left
		else if(x2<x1&&y2>y1){
			window.fillRect(x2, y1, x1-x2, y2-y1);
		}
	}
}
