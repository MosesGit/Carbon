package Carbon;

import java.awt.*;

public class Bullet
{
	private int x, y, height, width;
	private double vel, dx, dy, angle;
	private Rectangle rect;
	private Color col;
	
	public Bullet(int x, int y, double v, double a, int h, int w, Color c)
	{
		this.x = x;
		this.y = y;
		vel = v;
		dx = 0;
		dy = 0;
		height = h;
		width = w;
		angle = a;
		rect = new Rectangle(x, y, width, height);
		col = c;
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
	
	public void move()
	{
		dx = vel * Math.cos(angle);
		dy = vel * Math.sin(angle);
		x += dx;
		y += dy;
		rect.setLocation(x, y);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(col);
		g.fillOval(x, y, width, height);
	}
	
	public void kill()
	{
		x = 0;
		y = 0;
		vel = 0;
		dx = 0;
		dy = 0;
		height = 0;
		width = 0;
		rect = null;
		col = null;
	}
}