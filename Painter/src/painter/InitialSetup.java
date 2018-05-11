package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class InitialSetup {
	
	Image logo;
	
	public InitialSetup(Graphics window){
		//Load in logo
		try
		{
			logo = ImageIO.read(new File("src/painter/logo.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		window.drawImage(logo,0,0,70,70,null);
		
		//Thickness bar
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
