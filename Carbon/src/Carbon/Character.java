package Carbon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Character
{
	private int width, height, x, y, wx, wy, mx, my, health, maxHealth, score, space, r;
	private double xDifference, yDifference, angle;
	private Rectangle rect;
	private Weapon weap;
	private Color col;
	private Image still, bg;
	private String name, weapon;
	private boolean fired, reload;
		
	public Character()
	{
		still = new ImageIcon("assets/Character.png").getImage();
		bg = new ImageIcon("assets/Background.png").getImage();
		width = still.getWidth(null);
		height = still.getHeight(null);
		x = 100 - width;
		y = 500 - height;
		wx = 0;
		wy = 0;
		mx = x - width/2;
		my = y - height/2;
		health = 75;
		maxHealth = 100;
		score = 0;
		space = 0;
		r = 0;
		xDifference = 0;
		yDifference = 0;
		angle = 0;
		rect = new Rectangle(x, y, 40, height);
		col = Color.BLACK;
		fired = false;
		reload = false;
		weap = new Weapon(x + 100, y + 40, 100, 10, 100);
		weapon = "pistol";
		//width += weap.getWidth();
	}
	
	//Movement and location methods
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		keepInBounds();
	}
	public void moveLeft()
	{
		moveLeft(7);
	}
	public void moveLeft(int dx)
	{
		x -= dx;
		keepInBounds();
	}
	public void moveRight()
	{
		moveRight(7);
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
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x + width > Menu.frame.getWidth())
			x = Menu.frame.getWidth() - width;
		if (y + height > Menu.frame.getHeight())
			y = Menu.frame.getHeight() - height;
		rect.setLocation(x + 48, y);
		if (weapon.equals("pistol"))
			weap.setLocation(x + 90, y + 40);
		wx = weap.getOffsetX();
		wy = weap.getOffsetY();
	}
	
	//Get methods
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getMX()
	{
		return mx;
	}
	public int getMY()
	{
		return my;
	}
	public int getHealth()
	{
		return health;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public int getScore()
	{
		return score;
	}
	public int getSpace()
	{
		return space;
	}
	public int getR()
	{
		return r;
	}
	public String getName()
	{
		return name;
	}
	public Weapon getWeapon()
	{
		return weap;
	}
	public Image getImage()
	{
		return still;
	}
	public boolean getFired()
	{
		return fired;
	}
	public boolean getReload()
	{
		return reload;
	}
	
	//Set methods
	public void setMX(int n)
	{
		mx = n;
	}
	public void setMY(int n)
	{
		my = n;
	}
	public void setName(String s)
	{
		name = s;
	}
	public void setR(int n)
	{
		r = n;
	}
	public void setSpace(int n)
	{
		space = n;
	}
	public void setWeapon(Weapon w, String s)
	{
		weap = w;
		weapon = s;
	}
	public void setFired(boolean b)
	{
		fired = b;
	}
	public void setReload(boolean b)
	{
		reload = b;
	}
	//Other mutator methods
	public void takeDamage(int n)
	{
		health -= n;
	}
	public void addR()
	{
		r++;
	}
	public void addSpace()
	{
		space++;
	}
	
	//Weapon methods
	public Bullet shoot()
	{
		xDifference = mx - wx;
		yDifference = my - wy;
		angle = Math.atan2(xDifference, yDifference);
		return(weap.shoot(10, angle));
	}
	public void reload()
	{
		weap.reload();
		space = 0;
	}
	
	//Draw methods
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.drawImage(still, x, y, null);
	}
	public void undraw(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
	}
}