/*
Created by Team C.A.R.B.O.N.
Moses Chen, Jinmyeong Kim, Vivek Kunnath, and Avash Chapagain
Computer Systems Research, 3rd period
12/15/2012
*/

package Carbon;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame
{
	static JFrame frame;
	static MenuPanel myPanel;
	static Panel panel;
	static Store store;
	private static int w, h;
	private static Image background;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private ImageIcon newgame, continuegame, options, exitgame;
	private ImageIcon newgame2, continuegame2, options2, exitgame2;
	private static Insets insets;
	
	public Menu(int w, int h)
	{
		background = new ImageIcon("assets/Main Menu.png").getImage();
		newgame = new ImageIcon("assets/New Game.png");
		continuegame = new ImageIcon("assets/Continue Game.png");
		options = new ImageIcon("assets/Options.png");
		exitgame = new ImageIcon("assets/Exit Game.png");
		
		newgame2 = new ImageIcon("assets/New Game 2.png");
		continuegame2 = new ImageIcon("assets/Continue Game 2.png");
		options2 = new ImageIcon("assets/Options 2.png");
		exitgame2 = new ImageIcon("assets/Exit Game 2.png");
		
		myPanel = new MenuPanel(background);
		myPanel.setLayout(null);
		myPanel.setBackground(Color.BLACK);
		myPanel.setFocusable(true);
		myPanel.requestFocusInWindow();
		
		panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		
		button1 = new JButton(newgame);
		button2 = new JButton(continuegame);
		button3 = new JButton(options);
		button4 = new JButton(exitgame);
		
		button1.setBounds(w/2 - 200, h - 500, 400, 75);
		button2.setBounds(w/2 - 200, h - 375, 400, 75);
		button3.setBounds(w/2 - 200, h - 250, 400, 75);
		button4.setBounds(w/2 - 200, h - 125, 400, 75);
		
		button1.setBorder(BorderFactory.createEmptyBorder());
		button2.setBorder(BorderFactory.createEmptyBorder());
		button3.setBorder(BorderFactory.createEmptyBorder());
		button4.setBorder(BorderFactory.createEmptyBorder());
		
		MenuListener ourListener = new MenuListener();
		button1.addActionListener(ourListener);
		button2.addActionListener(ourListener);
		button3.addActionListener(ourListener);
		button4.addActionListener(ourListener);
		button1.addMouseListener(ourListener);
		button2.addMouseListener(ourListener);
		button3.addMouseListener(ourListener);
		button4.addMouseListener(ourListener);
		
		myPanel.add(button1);
		myPanel.add(button2);
		button2.setEnabled(false);
		myPanel.add(button3);
		myPanel.add(button4);
	}
	
	public class MenuPanel extends JPanel
	{
		private Image image;
		
		public MenuPanel(Image image)
		{
			this.image = image;
		}
		
		protected void paintComponent(Graphics g)
		{
			g.drawImage(image, 0, 0, null);
		}
	}
	
	private class MenuListener implements ActionListener, MouseListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean saved = false;
			if (e.getSource() == button1)
			{
				if(saved == true)
					button2.setEnabled(true);
				else
				{
					try
					{
						String n = JOptionPane.showInputDialog("Enter name: ");
						if (n != null && n.length() > 0)
						{
							panel.c = new Character();
							panel.c.setName(n);
							button2.setEnabled(true);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(panel);
							frame.getContentPane().revalidate(); 
							frame.getContentPane().repaint();
							panel.setFocusable(true);
							panel.requestFocusInWindow();
							saved = true;
							panel.c.setLocation(100 - panel.c.getWidth(), 500 - panel.c.getHeight());
							panel.keys.clear();
							panel.bullets.clear();
						}
					}
					catch (NumberFormatException ex)
					{
						
					}
				}
			}
			
			else if (e.getSource() == button2)
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.getContentPane().revalidate(); 
				frame.getContentPane().repaint();
				panel.setFocusable(true);
				panel.requestFocusInWindow();
				panel.keys.clear();
			}
			
			else if (e.getSource() == button3)
				JOptionPane.showMessageDialog(frame, "Options are under development.");
			
			else if (e.getSource() == button4)
				System.exit(0);
		}
		
		public void mouseEntered(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setIcon(newgame2);
			else if (e.getSource() == button2)
				button2.setIcon(continuegame2);
			else if (e.getSource() == button3)
				button3.setIcon(options2);
			else if (e.getSource() == button4)
				button4.setIcon(exitgame2);
		}
		public void mouseExited(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setIcon(newgame);
			else if (e.getSource() == button2)
				button2.setIcon(continuegame);
			else if (e.getSource() == button3)
				button3.setIcon(options);
			else if (e.getSource() == button4)
				button4.setIcon(exitgame);
		}
		public void mousePressed(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button2)
				button2.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button3)
				button3.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button4)
				button4.setBorder(new LineBorder(Color.RED, 2));
		}
		public void mouseClicked(MouseEvent e){}
		public void mouseReleased(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button2)
				button2.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button3)
				button3.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button4)
				button4.setBorder(BorderFactory.createEmptyBorder());
		}
	}
	
	public static void main(String[] args)
	{
		frame = new JFrame("C.A.R.B.O.N.");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		Menu menu = new Menu(1366, 768);
		store = new Store(1366, 768);
		
		w = dim.width;
		h = dim.height;
		
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		frame.getContentPane().add(myPanel);
		frame.setLocation(w/2 - 1366/2, h/2 - 768/2);
		frame.setUndecorated(false);
		frame.setResizable(false);
		frame.pack();
		insets = frame.getInsets();
		frame.setSize(new Dimension(1366 + insets.right + insets.left, 768 + insets.top + insets.bottom));
		frame.setVisible(true);
	}
}