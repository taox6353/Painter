package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.*;

public class Painter extends Canvas implements MouseListener, MouseMotionListener, Runnable/*, KeyListener*/
{
	
	//instance vars
	private BufferedImage back;
	private boolean mouseDown;
	private Color color;
	private int size;
	
//	private int r;
//	private int g;
//	private int b;
	
	private int X = 0;
	private int Y = 0;
	
	private int cursorX = 0;
	private int cursorY = 0;
	
	Pixel pix;
//	private ArrayList<Palette> colorz;
	
	
	
	
	
	public Painter(){
		setBackground(Color.WHITE);
		
		pix = new Pixel();
		mouseDown = false;
		color = Color.BLACK;
		size = 10;
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	public void update(Graphics window)
	{
		   paint(window);
	}
	public void paint( Graphics window )
	{
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics graphToBack = back.createGraphics();

		
		Palette palette = new Palette(graphToBack);
		Thickness thicknesses = new Thickness(graphToBack);
		
		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(20, 690, 600, 12);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Cursor Position: "+cursorX+", "+cursorY+"\t | Color selected: "+color.toString().substring(9)+" \t | Size: "+size, 20, 700);
		
		if(cursorY>=10&&cursorY<=30&&cursorX>=500&&cursorX<=500+20*palette.getCols().length){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Select a color by clicking on it. ", 20, 680);
		}
		else if(cursorY>=40&&cursorY<=60&&cursorX>=500&&cursorX<=740){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Select a thickness by clicking anywhere along the thickness spectrum. ", 20, 680);
		}
		else{
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(20, 670, 700, 12);
		}
		
		if(mouseDown == true){
			if(Y>=10&&Y<=30&&X>=500&&X<=500+20*palette.getCols().length){
				color = palette.getCols()[(int)(X-500)/20];
			}
			else if(Y>=40&&Y<=60&&X>=500&&X<=740){
				size = (int)(((double)(X-500)/(740-500))*100);
			}
			else
				pix.draw(graphToBack,X,Y,color,size);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void mouseClicked(MouseEvent event){
		repaint();
	}
	public void mousePressed(MouseEvent event){
		X = event.getX();
		Y = event.getY();
		mouseDown = true;
		repaint();
		
	}
	public void mouseReleased(MouseEvent event){
		mouseDown = false;
		repaint();
	}
	public void mouseEntered(MouseEvent event){
		repaint();
	}
	public void mouseExited(MouseEvent event){
		repaint();
	}
	public void mouseDragged(MouseEvent event){
		X=event.getX();
		Y=event.getY();
		mouseDown = true;
		repaint();
	}
	public void mouseMoved(MouseEvent event){
		cursorX=event.getX();
		cursorY=event.getY();
		repaint();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}
	
}
