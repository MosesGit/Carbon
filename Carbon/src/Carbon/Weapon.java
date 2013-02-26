package Carbon;

import java.awt.*;
import javax.swing.*;

public class Weapon
{
	private int x, y, offsetX, offsetY, width, height, ammo, clips, damage;
	private double angle;
	private Image wep, muzzle;
	private Color col;
	private Rectangle rect;
	
	public Weapon(int x, int y, int a, int c, int d)
	{
		this.x = x;
		this.y = y;
		offsetX = 30;
		offsetY = 2;
		wep = new ImageIcon("assets/graphics/Pistol.png").getImage();
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
	
	//Weapon methods
	public Bullet shoot(double n, double a)
	{
		ammo--;
		return new Bullet(x + offsetX, y + offsetY, n, a, 3, 6, col);
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