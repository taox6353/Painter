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
}
