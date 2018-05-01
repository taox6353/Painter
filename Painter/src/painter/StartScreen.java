package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class StartScreen {
	public StartScreen(){
	}
	
	public void draw(Graphics window){
		window.setColor(Color.BLACK);
		window.drawString("PAINTER by Xavier Tao", 100, 150);
		window.drawString("This is a paint application. Explore the functions and have fun!", 100, 170);
		window.drawString("2018 AP Computer Science A", 100, 190);
		window.drawString("Credits to Derek N. for graphics advice. ", 100, 210);
		window.drawString("If you would like to retrieve your autosaved drawing, go to src/painter/SAVEFILE.png and save that picture. ", 100, 230);
		window.drawString("[Click anywhere to dismiss this message] ", 100, 250);
	}
	public void getOut(Graphics window){
		window.setColor(Color.WHITE);
		window.fillRect(100, 100, 600, 500);
	}
}
