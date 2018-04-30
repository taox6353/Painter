package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Brush {
	
	public Brush(){
	}

	public void draw(Graphics window,int x,int y,Color color,int size){
		window.setColor(color);
		window.fillOval(x, y, size, size);
	}
}
