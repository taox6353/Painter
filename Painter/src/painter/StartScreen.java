package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class StartScreen {
	public StartScreen(){
	}
	
	public void draw(Graphics window){
		
//		JFrame frame = new JFrame();
//	    frame.setAlwaysOnTop(true);
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //try making a popup JDialog or something
	    
		window.setColor(Color.BLACK);
		window.drawString("PAINTER by Xavier Tao: 2018 AP Computer Science A", 100, 150);
		window.drawString("This is a paint application. Explore the functions and have fun!", 100, 170);
		window.drawString("Credits to Derek N. for graphics advice. ", 100, 190);
		window.drawString("If you would like to retrieve your autosaved drawing, go to src/painter/SAVEFILE.png and save that picture. ", 100, 210);
		window.drawString("Helpful Tips: ", 100, 250);
		window.drawString("DRAW (DRAG) SLOWLY TO MAKE STROKES.  ", 100, 270);
		window.drawString("DRAW (DRAG) FAST TO EXPERIMENT WITH A SPLATTERING EFFECT. ", 100, 290);
		window.drawString("You may only draw inside the bordered region. Tools will stay in effect if cursor is released outside of the region. ", 100, 310);
		window.drawString("[Click anywhere to dismiss this message]", 100, 330);
	}
	public void getOut(Graphics window){
		window.setColor(Color.WHITE);
		window.fillRect(100, 100, 800, 800);
	}
}
