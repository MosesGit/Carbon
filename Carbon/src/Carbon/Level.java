package Carbon;

import java.util.ArrayList;

public class Level
{
	private int n;
	static ArrayList<Stage> stages;
	
	public Level()
	{
		n = 1 + (int)(Math.random() * ((5 - 1) + 1));
		System.out.println(n);
	}
}