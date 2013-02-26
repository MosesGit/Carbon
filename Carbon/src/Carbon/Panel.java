package Carbon;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class Panel extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
	static Panel mainPanel;
	static Character c;
	static Enemy e;
	Image bi;
	Graphics bg;
	static ArrayList<Integer> keys;
	static ArrayList<Bullet> bullets;
	static ArrayList<Enemy> enemies;
	boolean redraw = true;
	
	public Panel()
	{
		c = new Character();
		e = new Enemy();
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		keys = new ArrayList<Integer>();
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
	}
	
	public void paint(Graphics g)
	{
		if (getWidth() != Menu.frame.getWidth() || getHeight() != Menu.frame.getHeight())
			Menu.frame.setPreferredSize(new Dimension(Menu.frame.getWidth() * 2 - getWidth(), Menu.frame.getHeight() * 2 - getHeight()));
		if (bg == null)
		{
			while (bi == null)
				bi = createImage(Menu.frame.getWidth(), Menu.frame.getHeight());
			while (bg == null)
				bg = bi.getGraphics();
		}
		draw(bg);
		paintShot(bg);
		
		g.drawImage(bi, 0, 0, this);
		repaint();
	}
	
	public void paintShot(Graphics g)
	{
			for(Bullet b:bullets)
				b.draw(g);
			update();
	}
	
	public void draw(Graphics g)
	{
		c.undraw(g);
		update();
		
		if(redraw)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Menu.frame.getWidth(), Menu.frame.getHeight());
			redraw = false;
		}
		
		c.getWeapon().draw(g);
		c.draw(g);
		e.draw(g);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("FFF Galaxy", Font.PLAIN, 12));
		g.drawString("Name: " + c.getName(), 50, 600);
		g.drawString("HP: " + c.getHealth(), 50, 625);
		g.drawString("Ammo: " + c.getWeapon().getAmmo(), 50, 650);
		g.drawString("Score: " + c.getScore(), 50, 675);
		g.drawString("Location: " + c.getMX() + " " + c.getMY(), 50, 700);
		
		g.setColor(Color.WHITE);
		g.fillRect(c.getX() + 41, c.getY() - 25, c.getMaxHealth() / 2, 5);
		g.setColor(Color.GREEN);
		g.fillRect(c.getX() + 41, c.getY() - 25, c.getHealth() / 2, 5);
	}
	
	public void update()
	{
		try
		{
			Thread.sleep(5);
		}
		catch(Exception e){}
		
		if (keys.contains(KeyEvent.VK_D))
			c.moveRight();
		if (keys.contains(KeyEvent.VK_A))
			c.moveLeft();
		if (keys.contains(KeyEvent.VK_W))
			c.jump();
		if (keys.contains(KeyEvent.VK_S))
			c.crouch();
		if (keys.contains(KeyEvent.VK_R))
		{
			c.addR();
			c.setReload(true);
		}
		if (!keys.contains(KeyEvent.VK_R))
			c.setReload(false);
		if (keys.contains(KeyEvent.VK_P))
		{
			//keys.remove(new Integer(KeyEvent.VK_P));
			Menu.frame.getContentPane().removeAll();
			Menu.frame.getContentPane().add(Menu.myPanel);
			Menu.frame.getContentPane().revalidate(); 
			Menu.frame.getContentPane().repaint();
			Menu.myPanel.setFocusable(true);
			Menu.myPanel.requestFocusInWindow();
		}
		if (keys.contains(KeyEvent.VK_O))
		{
			//keys.remove(new Integer(KeyEvent.VK_O));
			Menu.frame.getContentPane().removeAll();
			Menu.frame.getContentPane().add(Menu.store.storepanel);
			Menu.frame.getContentPane().revalidate(); 
			Menu.frame.getContentPane().repaint();
			Menu.myPanel.setFocusable(true);
			Menu.myPanel.requestFocusInWindow();
		}
		
		if (c.getSpace() >= 1 && c.getWeapon().getAmmo() > 0 && c.getFired() == false)
		{
			Bullet newBullet = c.shoot();
			bullets.add(newBullet);
			c.setSpace(0);
		}
		if (c.getR() >= 1 && c.getReload() == false)
		{
			c.reload();
			c.setR(0);
		}
		for (int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).move();
			if ((bullets.get(i).getX() > Menu.frame.getWidth() + 10) || (bullets.get(i).getX() < 0))
			{
				bullets.get(i).kill();
				bullets.remove(i);
				i--;
				continue;
			}
			if ((bullets.get(i).getY() > Menu.frame.getHeight() + 10) || (bullets.get(i).getY() < 0))
			{
				bullets.get(i).kill();
				bullets.remove(i);
				i--;
				continue;
			}
		}
	}
	
	//Listener methods
	public void keyPressed(KeyEvent e)
	{
		if (!(Panel.keys.contains(e.getKeyCode())))
			keys.add(e.getKeyCode());
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e)
	{
		keys.remove(new Integer(e.getKeyCode()));
	}
	
	public void mouseMoved(MouseEvent e)
	{
		c.setMX(e.getX());
		c.setMY(e.getY());
	}
	public void mousePressed(MouseEvent e)
	{
		c.addSpace();
		c.setFired(true);
	}
	public void mouseReleased(MouseEvent e)
	{
		c.setFired(false);
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseDragged(MouseEvent arg0)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
}