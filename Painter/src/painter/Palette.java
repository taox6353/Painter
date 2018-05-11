package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Palette {
	Color[] cols = {Color.RED, Color.ORANGE, Color.YELLOW,Color.GREEN, Color.CYAN, Color.BLUE, Color.PINK, Color.MAGENTA,Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK};
	
	public Palette(){
	}
	
	public Palette(Graphics window){
		window.setColor(Color.BLACK);
		window.drawString("Basic Colors", 420, 25);
		int cmult = 20;
		for(int i=0;i<cols.length;i++){
				window.setColor(cols[i]);
				window.fillRect(500+i*cmult, 10, 20, 20);
		}
	
	}
	public Color[] getCols(){
		return cols;
	}
}
