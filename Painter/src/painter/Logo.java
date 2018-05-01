package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Logo {
	
	Image logo;
	
	public Logo(Graphics window){
		try
		{
			logo = ImageIO.read(new File("src/painter/logo.png"));
		}
		catch(Exception e)
		{
			System.out.println("Icon could not be found or read. ");
		}
		window.drawImage(logo,0,0,70,70,null);
	}
}
