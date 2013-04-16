package Carbon;

import java.awt.*;
import javax.swing.*;

public class Obstacle
{
	private int x, y;
	private int width, height;
	private Rectangle rect;
	int score, hp, space, r;
	private Image im, bg;
	private String name;
	boolean  re;
	int k;
		
	public Obstacle()
	{
		im = new ImageIcon("assets/graphics/Obstacle.png").getImage();
		bg = new ImageIcon("assets/graphics/Background 2.png").getImage();
		width = im.getWidth(null);
		height = im.getHeight(null);
		k = bg.getWidth(null);
		x = 400 - width;
		y = 500 - height;
		hp = 100;
		score = 0;
		space = 0;
		r = 0;
		rect = new Rectangle(x, y, width, height);
		re = false;
	}
	
	public Obstacle(int x, int y)
	{
		im = new ImageIcon("assets/graphics/Obstacle.png").getImage();
		bg = new ImageIcon("assets/graphics/Background 2.png").getImage();
		width = im.getWidth(null);
		height = im.getHeight(null);
		k = bg.getWidth(null);
		this.x=x;
		this.y=y;
		hp = 100;
		score = 0;
		space = 0;
		r = 0;
		rect = new Rectangle(x, y, width, height);
		re = false;
	}
	
	//Get methods
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getBWidth()
	{
		return k;
	}
	public int getHeight()
	{
		return height;
	}
	public void setName(String s)
	{
		name = s;
	}
	public String getName()
	{
		return name;
	}
	public Image getImage()
	{
		return im;
	}
	
	//Set methods
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Draw methods
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.drawImage(im, x, y, null);
	}
	public void undraw(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
	}
}