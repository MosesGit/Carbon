package Carbon;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
 
public class Character
{
	private int width, height, bWidth, bHeight, x, y, wx, wy, mx, my;
	private int health, maxHealth, score, click, w, r, money, speed;
	//jt = check if in jump, jl = time of jump, ft, ftt = related to jump 
	private int jt, jl, ft, ftt, down, ri, le;
	private double xDifference, yDifference, angle;
	private Rectangle rect;
	private Weapon weap;
	private Image image, right, left, moveRight, moveLeft, jump, bg;
	private String name;
	//mR = moving right, mL = moving left
	private boolean mR, mL, fired, jumped, reload;
	private ArrayList<Obstacle> obstacles;
	
	//Amount to offset weapon image by so it lines up with the hand
	private int offX, pX, rX, sX, sgX, aX, snX;
	private int offY, pY, rY, sY, sgY, aY, snY;
	private int offXL, pXL, rXL, sXL, sgXL, aXL, snXL;
	private int offYL, pYL, rYL, sYL, sgYL, aYL, snYL;
	
	//Distance from player to point of gun
	private int disX, pistolX, revolverX, smgX, shotgunX, assaultX, sniperX;
	private int disY, pistolY, revolverY, smgY, shotgunY, assaultY, sniperY;
	
	//Weapons
	private Weapon pistol, revolver, smg, shotgun, assault, sniper;
	
	public Character()
	{
		right = new ImageIcon("assets/graphics/Character.png").getImage();
		left = new ImageIcon("assets/graphics/Character 2.png").getImage();
		moveRight = new ImageIcon("assets/graphics/Character.png").getImage();
		moveLeft = new ImageIcon("assets/graphics/Character 2.png").getImage();
		image = right;
		bg = new ImageIcon("assets/graphics/Background 2.png").getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		bWidth = bg.getWidth(null);
		bHeight = bg.getHeight(null);
		x = 100 - width;
		y = 500 - height;
		wx = 0;
		wy = 0;
		mx = x - width/2;
		my = y - height/2;
		health = 75;
		maxHealth = 100;
		score = 0;
		click = 0;
		w = 0;
		r = 0;
		money = 1000;
		speed = 10;
		xDifference = 0;
		yDifference = 0;
		angle = 0;
		rect = new Rectangle(x, y, 40, height);
		fired = false;
		jumped = false;
		reload = false;
		pX = 93;
		pY = 42;
		rX = 92;
		rY = 41;
		sX = 85;
		sY = 37;
		sgX = 90;
		sgY = 40;
		aX = 60;
		aY = 34;
		snX = 56;
		snY = 31;
		pXL = -75;
		pYL = -42;
		rXL = -92;
		rYL = -41;
		sXL = -85;
		sYL = -37;
		sgXL = -90;
		sgYL = -40;
		aXL = -60;
		aYL = -34;
		snXL = -56;
		snYL = -31;
		pistol = new Weapon(x + pX, y + pY, 100, 10, 10, "Pistol");
		revolver = new Weapon(x + rX, y + rY, 150, 6, 20, "Revolver");
		smg = new Weapon(x + sX, y + sY, 200, 6, 5, "SMG");
		shotgun = new Weapon(x + sgX, y + sgY, 75, 10, 10, "Shotgun");
		assault = new Weapon(x + aX, y + aY, 500, 10, 25, "Assault Rifle");
		sniper = new Weapon(x + snX, y + snY, 50, 10, 100, "Sniper Rifle");
		weap = pistol;
		offX = pX;
		offY = pY;
		jt = 0;
		jl = 0;
		ft = 0;
		ftt = 0;
		down = 0;
		ri = 0;
		le = 0;
		obstacles = new ArrayList<Obstacle>();
	}
	
	public void setObstacles(ArrayList<Obstacle> obs)
	{
		obstacles = obs;
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
		moveLeft(speed);
		weaponLeft();
		mR = false;
		mL = true;
		le = 1;
	}
	public void moveLeft(int dx)
	{
		for (Obstacle ob:obstacles)
		{
			if (((getY() + getHeight() > ob.getY() && getY()<ob.getY()) || (getY() < ob.getY() + ob.getHeight() &&
					getY() + getHeight() > ob.getY() + ob.getHeight()) || (getY()>ob.getY() && getY() + getHeight()<ob.getY() + ob.getHeight())) &&
					getX() - dx < ob.getX() + ob.getWidth() && getX() - dx > ob.getX())
			{
				le = -1;
				x -= getX() - ob.getX() - ob.getWidth();
			}
		}
		if (le >= 0)
			x -= dx;
		keepInBounds();
		le = 1;
	}
	public void moveRight()
	{
		moveRight(speed);
		weaponRight();
		mL = false;
		mR = true;
		ri = 1;
	}
	public void moveRight(int dx)
	{
		for (Obstacle ob:obstacles)
		{
			if (((getY() + getHeight() > ob.getY() && getY() < ob.getY()) || (getY()< ob.getY() + ob.getHeight()
					&& getY() + getHeight() > ob.getY() + ob.getHeight()) || (getY()>ob.getY() && getY() + getHeight() < ob.getY() + ob.getHeight()))
					&& getX() + dx+getWidth() > ob.getX() && getX() + dx+getWidth() < ob.getX() + ob.getWidth())
			{
				ri=-1;
				x+= ob.getX() - getX() - getWidth();
			}
		}
		if(ri >= 0)
			x += dx;
		keepInBounds();
		ri = 1;
	}
	public void moveUp(int dy)
	{
		int up = 1;
		int DTU = 0;
		int kb = 0;
		for (Obstacle ob:obstacles)
		{
			if (getY() - dy > ob.getY()  && getY() - dy < ob.getY() + ob.getHeight() && (getX() + getWidth() > ob.getX()
					&& getX()  < ob.getX() + ob.getWidth()))
			{
				up = 0;
				//System.out.println(ob.getWidth());
				if(kb == 0)
					DTU = getY() - (ob.getY() + ob.getHeight());
				if(DTU > getY() - (ob.getY() + ob.getHeight()))
					DTU= getY() - (ob.getY() + ob.getHeight());
				kb++;
			}
		}
		if (jt == 1)
		{
			jl++;
			if(jl < 10 && up == 1)
			{
				y -= dy;
				//if( jl>6)
				//y+= dy/3;
			}
			else 
			{
				jt=0;
				y-= DTU;
			}
		}
		if (jl >= 10)
			jt = 0;
		if(jt == 0)
			jl = 0;
		keepInBounds();
	}
	public void moveDown(int dy)
	{
		down = 1;
		int DTD = 0;
		int ka = 0;
		for (Obstacle ob:obstacles)
		{
			if (500 - height < y + dy + ft || (getY() + getHeight() + dy + ft < ob.getY()+ ob.getHeight() && getY() + getHeight() + dy + ft > ob.getY() &&
					(getX() + getWidth() > ob.getX() && getX() < ob.getX() + ob.getWidth())))
			{
				down = 0;
				if(ka == 0)
					DTD = getY() - (ob.getY() + ob.getHeight());
				if(DTD > getY() - (ob.getY() + ob.getHeight()))
					DTD = getY() - (ob.getY() + ob.getHeight());
				ka++;
			}
		}
		if(down == 1)
		{
			y += dy + ft;
			ftt++;
			if(ft <= 20 && ftt % 2 == 0)
				ft++;
		}
		if(down == 0)
			ft = 0;
		keepInBounds();
	}
	public void stopR()
	{
		ri = 0;
	}
	public void stopL()
	{
		le = 0;
	}
	public void jump()
	{
		if (down == 0)
			jt = 1;
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
		if(x + width > bWidth)
			x = bWidth - width;
		if (y + height > Menu.frame.getHeight())
			y = Menu.frame.getHeight() - height;
		if (mR)
			image = moveRight;
		//Toolkit.getDefaultToolkit().createImage("e:/java/spin.gif");
		if (mL)
			image = moveLeft;
		rect.setLocation(x + 48, y);
		weap.setLocation(x + offX, y + offY);
		wx = weap.getOffsetX();
		wy = weap.getOffsetY();
		mR = false;
		mL = false;
	}
	
	//Get methods
	public int getWidth()
	{
		return rect.width;
	}
	public int getHeight()
	{
		return rect.height;
	}
	public int getRectWidth()
	{
		return width;
	}
	public int getBWidth()
	{
		return bWidth;
	}
	public int getBHeight()
	{
		return bHeight;
	}
	public int getX()
	{
		return x + 48;
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
	public int getClick()
	{
		return click;
	}
	public int getR()
	{
		return r;
	}
	public int getW()
	{
		return w;
	}
	public int getMoney()
	{
		return money;
	}
	public int getSpeed()
	{
		return speed;
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
		return image;
	}
	public boolean getFired()
	{
		return fired;
	}
	public boolean getReload()
	{
		return reload;
	}
	public boolean getJumped()
	{
		return jumped;
	}
	public int getOffX()
	{
		return offX;
	}
	public int getOffY()
	{
		return offY;
	}
	public int getPX()
	{
		return pX;
	}
	public int getPY()
	{
		return pY;
	}
	public int getRX()
	{
		return rX;
	}
	public int getRY()
	{
		return rY;
	}
	public int getSX()
	{
		return sX;
	}
	public int getSY()
	{
		return sY;
	}
	public int getSGX()
	{
		return sgX;
	}
	public int getSGY()
	{
		return sgY;
	}
	public int getAX()
	{
		return aX;
	}
	public int getAY()
	{
		return aY;
	}
	public int getSNX()
	{
		return snX;
	}
	public int getSNY()
	{
		return snY;
	}
	public Weapon getPistol()
	{
		return pistol;
	}
	public Weapon getRevolver()
	{
		return revolver;
	}
	public Weapon getSMG()
	{
		return smg;
	}
	public Weapon getShotgun()
	{
		return shotgun;
	}
	public Weapon getAssault()
	{
		return assault;
	}
	public Weapon getSniper()
	{
		return sniper;
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
	public void setMoney(int m)
	{
		money = m;
	}
	public void setName(String s)
	{
		name = s;
	}
	public void setR(int n)
	{
		r = n;
	}
	public void setW(int n)
	{
		w = n;
	}
	public void setClick(int n)
	{
		click = n;
	}
	public void setWeapon(Weapon w)
	{
		weap = w;
	}
	public void setFired(boolean b)
	{
		fired = b;
	}
	public void setReload(boolean b)
	{
		reload = b;
	}
	public void setJumped(boolean b)
	{
		jumped = b;
	}
	public void setOffX(int x)
	{
		offX = x;
	}
	public void setOffY(int y)
	{
		offY = y;
	}
	//Other mutator methods
	public void takeDamage(int n)
	{
		health -= n;
	}
	public void addClick()
	{
		click++;
	}
	public void addR()
	{
		r++;
	}
	public void addW()
	{
		w++;
	}
	
	//Weapon methods
	public void updateWeapons()
	{
		pistol = new Weapon(x + pX, y + pY, 100, 10, 10, "Pistol");
		revolver = new Weapon(x + rX, y + rY, 150, 6, 20, "Revolver");
		smg = new Weapon(x + sX, y + sY, 200, 6, 5, "SMG");
		shotgun = new Weapon(x + sgX, y + sgY, 75, 10, 10, "Shotgun");
		assault = new Weapon(x + aX, y + aY, 500, 10, 25, "Assault Rifle");
		sniper = new Weapon(x + snX, y + snY, 50, 10, 100, "Sniper Rifle");
	}
	public void weaponRight()
	{
		if (weap.getName().equals("Pistol"))
			weap.weaponUpdate(false, "", pX);
		if (weap.getName().equals("Revolver"))
			weap.weaponUpdate(false, "", rX);
		if (weap.getName().equals("SMG"))
			weap.weaponUpdate(false, "", sX);
		if (weap.getName().equals("Shotgun"))
			weap.weaponUpdate(false, "", sgX);
		if (weap.getName().equals("Assault Rifle"))
			weap.weaponUpdate(false, "", aX);
		if (weap.getName().equals("Sniper Rifle"))
			weap.weaponUpdate(false, "", snX);
	}
	public void weaponLeft()
	{
		if (weap.getName().equals("Pistol"))
			weap.weaponUpdate(true, " 2", pXL);
		if (weap.getName().equals("Revolver"))
			weap.weaponUpdate(true, " 2", rXL);
		if (weap.getName().equals("SMG"))
			weap.weaponUpdate(true, " 2", sXL);
		if (weap.getName().equals("Shotgun"))
			weap.weaponUpdate(true, " 2", sgXL);
		if (weap.getName().equals("Assault Rifle"))
			weap.weaponUpdate(true, " 2", aXL);
		if (weap.getName().equals("Sniper Rifle"))
			weap.weaponUpdate(true, " 2", snXL);
	}
	public Bullet shoot()
	{
		xDifference = mx - wx - 170;
		yDifference = y - my;
		angle = Math.atan2(yDifference, xDifference);
		if (angle > Math.PI/2)
			angle = Math.PI/2;
		if (angle < -1 * Math.PI/2)
			angle = Math.PI/-2;
		return(weap.shoot(10, -angle, ri, le));
	}
	public void reload()
	{
		weap.reload();
	}
	
	//Draw methods
	public void draw(Graphics g)
	{
		//Clear color
		//g.setColor(new Color(0, 0, 0, 0));
		g.setColor(new Color(100, 100, 100, 100));
		g.fillRect(x, y, width, height);
		//White rectangle for testing
		g.setColor(Color.WHITE);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.drawImage(image, x, y, null);
	}
	public void undraw(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
	}
}