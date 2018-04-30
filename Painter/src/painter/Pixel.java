package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Pixel {
	
	public Pixel(){
	}

	public void draw(Graphics window,int x,int y,Color color,int size){
		window.setColor(color);
		window.fillRect(x, y, size, size);
	}
}
