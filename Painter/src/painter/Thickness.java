package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Thickness {
	
	public Thickness(){
	}
	
	public Thickness(Graphics window){
		window.setColor(Color.BLACK);
		window.drawString("Thickness Spectrum", 375, 55);
		window.setColor(Color.LIGHT_GRAY);
		window.fillRect(500, 40, 80, 20);
		window.setColor(Color.WHITE);
		window.drawString("THIN", 505, 55);
		window.setColor(Color.GRAY);
		window.fillRect(580, 40, 80, 20);
		window.setColor(Color.WHITE);
		window.drawString("THICK", 585, 55);
		window.setColor(Color.DARK_GRAY);
		window.fillRect(660, 40, 80, 20);
		window.setColor(Color.WHITE);
		window.drawString("VERY THICK", 665, 55);
	}
}
