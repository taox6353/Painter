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
		window.drawString("PAINTER by Xavier Tao", 250, 200);
		window.drawString("This is your typical paint application. Explore the functions and have fun!", 250, 225);
		window.drawString("2018 AP Computer Science A", 250, 250);
		window.drawString("Click anywhere to dismiss this message. ", 250, 275);
		window.drawString("Credits to Derek N. for logo advice. ", 250, 300);
	}
	public void getOut(Graphics window){
		window.setColor(Color.WHITE);
		window.fillRect(100, 100, 600, 500);
	}
}
