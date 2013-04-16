package Carbon;

import java.awt.*;
import javax.swing.*;

public class Weapon
{
	private int x, y, oX, oY, offsetX, offsetY, width, height, ammo, clips, damage;
	private double angle;
	private String name;
	private Image wep, muzzle;
	private Color col;
	private Rectangle rect;
	
	public Weapon(int x, int y, int a, int c, int d, String s)
	{
		this.x = x;
		this.y = y;
		offsetX = 30;
		offsetY = 2;
		name = s;
		wep = new ImageIcon("assets/graphics/" + name + ".png").getImage();
		width = wep.getWidth(null);
		height = wep.getHeight(null);
		ammo = a;
		clips = c;
		damage = d;
		angle = 0;
		col = Color.BLACK;
		rect = new Rectangle();
	}
	
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	public int getOffsetX()
	{
		return offsetX;
	}
	public int getOffsetY()
	{
		return offsetY;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public int getAmmo()
	{
		return ammo;
	}
	public String getName()
	{
		return name;
	}
	
	//Mutator methods
	public void weaponUpdate(boolean l, String s, int o)
	{
		wep = new ImageIcon("assets/graphics/" + name + s + ".png").getImage();
		if (l)
		{
			x += o;
		}
	}
	
	//Weapon methods
	public Bullet shoot(double n, double a, int r, int l)
	{
		ammo--;
		return new Bullet(x + offsetX, y + offsetY, n, a, 3, 6, col, 25, r, l);
	}
	public void reload()
	{
		ammo += 10;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(wep, x, y, null);
	}
}