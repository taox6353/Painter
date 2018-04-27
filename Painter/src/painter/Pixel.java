package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Pixel {
	int x = 0;
	int y = 0;
	Color col;
	public Pixel(){
		col = Color.WHITE;
	}
	public Pixel(int xCoord,int yCoord){
		x = xCoord;
		y = yCoord;
		col = Color.WHITE;
	}
	public void draw(Graphics window,Color color){
		col = color;
	}
}
