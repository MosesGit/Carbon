package Carbon;

import java.awt.*;
import javax.swing.*;

public class Patrol
{
	private int width, height, x, y, health, ammo;
	private Rectangle rect;
	private Color col;
	private Image still;
	
	public Patrol()
	{
		still = new ImageIcon("assets/graphics/Enemy.png").getImage();
		width = still.getWidth(null);
		height = still.getHeight(null);
		x = 1000;
		y = 500 - height;
		health = 100;
		ammo = 100;
		rect = new Rectangle(x, y, width, height);
		col = Color.BLACK;
	}
	
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		keepInBounds();
	}
	
	public void move()
	{
		if (x - Menu.panel.c.getX() > 750 && x - Menu.panel.c.getX() < 1000)
			moveLeft();
		else if (x - Menu.panel.c.getX() < 250 && Menu.panel.c.getX() > 500)
			moveRight();
	}
	
	public void moveLeft()
	{
		moveLeft(5);
	}
	
	public void moveLeft(int dx)
	{
		x -= dx;
		keepInBounds();
	}
	
	public void moveRight()
	{
		moveRight(5);
	}
	
	public void moveRight(int dx)
	{
		x += dx;
		keepInBounds();
	}
	
	public void jump()
	{
		
	}
	
	public void crouch()
	{
		
	}
	
	public void keepInBounds()
	{
		if(x < 0)
			x = 0;
		if(y < 0)
			y = 0;
		if(x + width > Menu.frame.getWidth())
			x = Menu.frame.getWidth() - width;
		if(y + height > Menu.frame.getHeight())
			y = Menu.frame.getHeight() - height;
		rect.setLocation(x, y);
	}
	
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
	
	public int getHeight()
	{
		return height;
	}
	
	public Image getImage()
	{
		return still;
	}
	
	public Bullet shoot(int n, int a, int r, int l)
	{
		ammo--;
		return new Bullet(x + 85, y + 28, n, a, 3, 6, col, 25, r, l);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(x, y, width, height);
		g.drawImage(still, x, y, null);
	}
}