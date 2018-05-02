package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.event.MouseListener;
import java.awt.event.*;

public class Painter extends Canvas implements MouseListener, MouseMotionListener, Runnable/*, KeyListener*/
{
	
	//instance vars
	private BufferedImage back;
	private boolean mouseDown;
	private Color color;
	private int size;
	private boolean firstload;
	private String tool;
	
	private boolean pencilselected;
	private boolean eraserselected;
	private boolean brushselected;
	private boolean pickerselected;
	private boolean lineselected;
	
	
//	private int r;
//	private int g;
//	private int b;
	
	private int X = 0;
	private int Y = 0;
	private int Xrel = 0;
	private int Yrel = 0;
	private int Xpress = 0;
	private int Ypress = 0;
	
	private int cursorX = 0;
	private int cursorY = 0;
	
	private boolean justUp = false;
	
	ToolPencil pencil;
	ToolEraser eraser;
	ToolBrush brush;
	ToolSave save;
	ToolPicker picker;
	ToolLine line;
//	private ArrayList<Palette> colorz;
	
	
	public Painter(){
		setBackground(Color.WHITE);
		
		
		mouseDown = false;
		color = Color.BLACK;
		size = 15;
		firstload = true;
		tool = "Pencil";
		
		pencilselected=true;
		eraserselected=false;
		brushselected=false;
		lineselected=false;
		
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
		//Loading background
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics graphToBack = back.createGraphics();
		
		//Loads first screen
		if(firstload){
		StartScreen ss = new StartScreen();
		ss.draw(graphToBack);
		if(mouseDown){
			ss.getOut(graphToBack);
			firstload = false;
			}
		}
		//Loads toolbar elements
		graphToBack.drawLine(0, 70, 800, 70);
		Palette palette = new Palette(graphToBack);
		Thickness thicknesses = new Thickness(graphToBack);
		Logo logo = new Logo(graphToBack);
		eraser = new ToolEraser(graphToBack);
		pencil = new ToolPencil(graphToBack);
		brush = new ToolBrush(graphToBack);
		save = new ToolSave(graphToBack);
		picker = new ToolPicker(graphToBack);
		line = new ToolLine(graphToBack);
		
		//Recognizes tool
		if(pencilselected){
			tool = "Pencil";
		}
		else if(eraserselected){
			tool = "Eraser";
		}
		else if(brushselected){
			tool = "Brush";
		}
		else if(lineselected){
			tool = "Line Drawer";
		}
		else
			tool = "None selected";
		
		//Status message updater
		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(20, 710, 600, 12);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Cursor Position: "+cursorX+", "+cursorY+"\t | Tool selected: "+tool+"\t | Color selected: "+color.toString().substring(9)+" \t | Size: "+size, 20, 720);
		
		//Cursor hovering over color bar
		if(cursorY>=10&&cursorY<=30&&cursorX>=500&&cursorX<=500+20*palette.getCols().length){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Select a color by clicking on it. ", 20, 700);
		}
		//Cursor hovering over size spectrum picker
		else if(cursorY>=40&&cursorY<=60&&cursorX>=500&&cursorX<=740){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Select a thickness by clicking anywhere along the thickness spectrum. ", 20, 700);
		}
		//Cursor hovering over pencil tool
		else if(cursorY>=pencil.getY()&&cursorY<=pencil.getY()+pencil.getSize()&&cursorX>=pencil.getX()&&cursorX<=pencil.getX()+pencil.getSize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Pencil Tool: The standard tool that draws square pixels. ", 20, 700);
		}
		//Cursor hovering over eraser tool
		else if(cursorY>=eraser.getY()&&cursorY<=eraser.getY()+eraser.getSize()&&cursorX>=eraser.getX()&&cursorX<=eraser.getX()+eraser.getSize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Eraser Tool: Your classic Pink Pearl eraser. Erase anything, anytime. ", 20, 700);
		}
		//Cursor hovering over brush tool
		else if(cursorY>=brush.getY()&&cursorY<=brush.getY()+brush.getSize()&&cursorX>=brush.getX()&&cursorX<=brush.getX()+brush.getSize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Brush Tool: All of the pencil goodness, just smoother. ", 20, 700);
		}
		//Cursor hovering over save tool
		else if(cursorY>=save.getY()&&cursorY<=save.getY()+save.getsize()&&cursorX>=save.getX()&&cursorX<=save.getX()+save.getsize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Save Tool: [edit] This is now a vestigial tool! Your artwork is automatically saved upon closing the window! How nice is that? ", 20, 700);
		}
		//Cursor hovering over color picker tool
		else if(cursorY>=picker.getY()&&cursorY<=picker.getY()+picker.getSize()&&cursorX>=picker.getX()&&cursorX<=picker.getX()+picker.getSize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("[Nonfunctional]Color Picker Tool: Don't feel like using the default colors? Pick your own! ", 20, 700);
		}
		//Cursor hovering over line tool
		else if(cursorY>=line.getY()&&cursorY<=line.getY()+line.getSize()&&cursorX>=line.getX()&&cursorX<=line.getX()+line.getSize()){
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Line Tool: Want a thin, straight line? Use this!   NOTE: This is a single use tool. To use again, reclick the tool icon. ", 20, 700);
		}
		//Hovering over nothing, hide message
		else{
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(20, 690, 700, 12);
		}
		
		//Hot areas: clicking on stuff does stuff
		if(mouseDown == true){
			//Clicked on color bar
			if(Y>=10&&Y<=30&&X>=500&&X<=500+20*palette.getCols().length){
				color = palette.getCols()[(int)(X-500)/20];
			}
			//Clicked on size spectrum picker
			else if(Y>=40&&Y<=60&&X>=500&&X<=740){
				size = (int)(((double)(X-500)/(740-500))*100);
			}
			//Clicked on pencil tool
			else if(Y>=pencil.getY()&&Y<=pencil.getY()+pencil.getSize()&&X>=pencil.getX()&&X<=pencil.getX()+pencil.getSize()){
				pencilselected = true;
				eraserselected = false;
				brushselected = false;
				lineselected = false;
			}
			//Clicked on eraser tool
			else if(Y>=eraser.getY()&&Y<=eraser.getY()+eraser.getSize()&&X>=eraser.getX()&&X<=eraser.getX()+eraser.getSize()){
				pencilselected = false;
				eraserselected = true;
				brushselected = false;
				lineselected = false;
			}
			//Clicked on brush tool
			else if(Y>=brush.getY()&&Y<=brush.getY()+brush.getSize()&&X>=brush.getX()&&X<=brush.getX()+brush.getSize()){
				pencilselected = false;
				eraserselected = false;
				brushselected = true;
				lineselected = false;
			}
			//Clicked on save
			else if(Y>=save.getY()&&Y<=save.getY()+save.getsize()&&X>=save.getX()&&X<=save.getX()+save.getsize()){
//				save.save();
			}
			//Clicked on color picker tool---doesn't work
//			else if(cursorY>=picker.getY()&&cursorY<=picker.getY()+picker.getSize()&&cursorX>=picker.getX()&&cursorX<=picker.getX()+picker.getSize()){
//				pickerselected=true;
//			}
			//Clicked on line tool
			else if(cursorY>=line.getY()&&cursorY<=line.getY()+line.getSize()&&cursorX>=line.getX()&&cursorX<=line.getX()+line.getSize()){
				pencilselected = false;
				eraserselected = false;
				brushselected = false;
				lineselected = true;
			}
			//Draws on canvas with pencil
			else if(pencilselected&&Y>70){
				pencil.draw(graphToBack,X,Y,color,size);
				if(mouseDown&&cursorY<=70){
					mouseDown = false;
				}
			}
			//Draws on canvas with eraser
			else if(eraserselected){
				eraser.draw(graphToBack, X, Y, color, size);
			}
			//Draws on canvas with brush
			else if(brushselected&&Y>70){
				brush.draw(graphToBack,X,Y,color,size);
			}
			
		}
		//Draws on canvas using line tool
		if(justUp&&lineselected&&Y>70&&Ypress>70&&Yrel>70){
			justUp = false;
			lineselected = false;
			line.draw(graphToBack,Xpress,Ypress,Xrel,Yrel,color);
		}
		
		//colorpicker doesn't work
//		if(pickerselected){
//			pickerselected=false;
//			Color newcolor =  picker.picker();
//			color = newcolor;
//		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void mouseClicked(MouseEvent event){
		repaint();
	}
	public void mousePressed(MouseEvent event){
		mouseDown = true;
		
		if(lineselected&&cursorY>70){
			Xpress = event.getX();
			Ypress = event.getY();
		}
		else{
			X = event.getX();
			Y = event.getY();
		}
			
		repaint();
		
	}
	public void mouseReleased(MouseEvent event){
		mouseDown = false;
		Xrel = event.getX();
		Yrel = event.getY();
		justUp = true;
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
