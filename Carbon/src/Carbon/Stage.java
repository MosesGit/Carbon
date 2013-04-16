package Carbon;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Stage
{
	private int m;
	private Image back;
	static ArrayList<Enemy> enemies;
	static ArrayList<Obstacle> obstacles;
	
	Obstacle ob1, ob2, ob3, ob4, ob5, ob6, ob7;
	
	public Stage(int l, int n)
	{
		m = l;
		back = new ImageIcon("assets/graphics/" + m + "/" + n).getImage();
		//panel.c.setLocation(100 - panel.c.getWidth(), 500 - panel.c.getHeight());
	}
}