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
		window.drawString("PAINTER by Xavier Tao", 400, 450);
		window.drawString("This is your typical paint application. Choose a color, and begin painting!", 250, 500);
		window.drawString("2018 AP Computer Science A", 400, 550);
	}
}
