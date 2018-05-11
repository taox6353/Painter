package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartScreen {
	public StartScreen(){
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Makes icon
	    ImageIcon icon = new ImageIcon("src/painter/logo.png");
		JOptionPane.showMessageDialog(frame, "PAINTER by Xavier Tao\n"
				+ "2018 AP Computer Science A\n"
				+ "This is a paint application. Have fun!\n"
				+ "Special thanks to Derek Nakanishi for advice and help with graphics. \n\n"
				+ "Helpful Tips: \n"
				+ "Draw (drag) SLOWLY to make strokes. \n"
				+ "Draw (drag) QUICKLY to experiment with splattering. \n"
				+ "You may only draw inside the bordered region. Tools will stay in effect if cursor is released outside of the region. \n"
				+ "If you would like to retrieve your autosaved drawing, go to src/painter/SAVEFILE.png and save that picture. \n"
				+ "\n[Click OK to start painting!]","PAINTER by Xavier Tao",JOptionPane.INFORMATION_MESSAGE,icon);
	}
	
//	public void draw(Graphics window){
//		
//		(No longer being used: Updated to JFrame dialogue box)
//	    
//		window.setColor(Color.BLACK);
//		window.drawString("", 100, 150);
//		window.drawString("", 100, 170);
//		window.drawString("", 100, 190);
//		window.drawString("If you would like to retrieve your autosaved drawing, go to src/painter/SAVEFILE.png and save that picture. ", 100, 210);
//		window.drawString("Helpful Tips: ", 100, 250);
//		window.drawString("DRAW (DRAG) SLOWLY TO MAKE STROKES.  ", 100, 270);
//		window.drawString("DRAW (DRAG) FAST TO EXPERIMENT WITH A SPLATTERING EFFECT. ", 100, 290);
//		window.drawString("You may only draw inside the bordered region. Tools will stay in effect if cursor is released outside of the region. ", 100, 310);
//		window.drawString("[Click anywhere to dismiss this message]", 100, 330);
//	}
	public void getOut(Graphics window){
		window.setColor(Color.WHITE);
		window.fillRect(100, 100, 800, 800);
	}
}
