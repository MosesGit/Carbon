package Carbon;

import java.awt.*;

public class Bullet
{
	private int x, y, height, width, damage, r, l;
	private double vel, dx, dy, angle, X, Y;
	private Rectangle rect;
	private Color col;
	
	public Bullet(int x, int y, double v, double a, int h, int w, Color c, int d, int rr, int ll)
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
		damage = d;
		r = rr;
		l = ll;
		X = 0;
		Y = 0;
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
	public Rectangle getRect()
	{
		return rect;
	}
	public int getDamage()
	{
		return damage;
	}
	
	public void move()
	{
		dx = 2 * vel * Math.cos(angle);
		dy = 2 * vel * Math.sin(angle);
		x += dx;
		y += dy;
		
		if(r == 1)
			X += 10;
		//if(l == 1)
		//	X -= 10;
		
		rect.setLocation(x + (int) Math.round(X), y + (int) Math.round(Y));
	}
	
	public void draw(Graphics g)
	{
		g.setColor(col);
		g.fillOval(x + (int) Math.round(X), y + (int) Math.round(Y), width, height);
	}
	
	public void kill()
	{
		x = 0;
		y = 0;
		vel = 0;
		dx = 0;
		dy = 0;
		angle = 0;
		height = 0;
		width = 0;
		r = 0;
		l = 0;
		damage = 0;
		X = 0;
		Y = 0;
		rect = null;
		col = null;
	}
}