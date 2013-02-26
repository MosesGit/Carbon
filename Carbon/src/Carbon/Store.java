package Carbon;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Store
{
	static StorePanel storepanel;
	static int w, h;
	static Image background;
	
	private JLabel weapons, upgrades;
	
	//Weapons
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	//Upgrades
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	
	private JButton button11;
	private JButton button12;
	
	private ImageIcon blank, blank2;
	
	public Store(int w, int h)
	{
		background = new ImageIcon("assets/graphics/Store Menu.png").getImage();
		blank = new ImageIcon("assets/graphics/Button.png");
		blank2 = new ImageIcon("assets/graphics/Button 2.png");
		
		storepanel = new StorePanel(background);
		storepanel.setLayout(null);
		storepanel.setBackground(Color.BLACK);
		storepanel.setFocusable(true);
		storepanel.requestFocusInWindow();
		
		button1 = new JButton("Revolver (Under Development)", blank);
		button2 = new JButton("SMG (Under Development)", blank);
		button3 = new JButton("Shotgun (Under Development)", blank);
		button4 = new JButton("Assault Rifle (Under Development)", blank);
		button5 = new JButton("Sniper Rifle (Under Development)", blank);
		button6 = new JButton("Spare Batteries (Under Development)", blank);
		button7 = new JButton("Redundant Systems (Under Development)", blank);
		button8 = new JButton("Explosive Proximity Alarm (Under Development)", blank);
		button9 = new JButton("Mark I Armor (Under Development)", blank);
		button10 = new JButton("Layered Armor (Under Development)", blank);
		button11 = new JButton("Exit to Main Menu", blank);
		button12 = new JButton("Continue Game", blank);
		
		//Left
		button1.setBounds(50, h - 600, 400, 75);
		button2.setBounds(50, h - 500, 400, 75);
		button3.setBounds(50, h - 400, 400, 75);
		button4.setBounds(50, h - 300, 400, 75);
		button5.setBounds(50, h - 200, 400, 75);
		
		button11.setBounds(250, h - 100, 400, 75);
		
		//Right
		button6.setBounds(w - 450, h - 600, 400, 75);
		button7.setBounds(w - 450, h - 500, 400, 75);
		button8.setBounds(w - 450, h - 400, 400, 75);
		button9.setBounds(w - 450, h - 300, 400, 75);
		button10.setBounds(w - 450, h - 200, 400, 75);
		
		button12.setBounds(w - 650, h - 100, 400, 75);
		
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Arial", Font.BOLD, 18));
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setVerticalTextPosition(JButton.CENTER);
		
		button2.setForeground(Color.WHITE);
		button2.setFont(new Font("Arial", Font.BOLD, 18));
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setVerticalTextPosition(JButton.CENTER);
		
		button3.setForeground(Color.WHITE);
		button3.setFont(new Font("Arial", Font.BOLD, 18));
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setVerticalTextPosition(JButton.CENTER);
		
		button4.setForeground(Color.WHITE);
		button4.setFont(new Font("Arial", Font.BOLD, 18));
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setVerticalTextPosition(JButton.CENTER);
		
		button5.setForeground(Color.WHITE);
		button5.setFont(new Font("Arial", Font.BOLD, 18));
		button5.setHorizontalTextPosition(JButton.CENTER);
		button5.setVerticalTextPosition(JButton.CENTER);
		
		button6.setForeground(Color.WHITE);
		button6.setFont(new Font("Arial", Font.BOLD, 18));
		button6.setHorizontalTextPosition(JButton.CENTER);
		button6.setVerticalTextPosition(JButton.CENTER);
		
		button7.setForeground(Color.WHITE);
		button7.setFont(new Font("Arial", Font.BOLD, 18));
		button7.setHorizontalTextPosition(JButton.CENTER);
		button7.setVerticalTextPosition(JButton.CENTER);
		
		button8.setForeground(Color.WHITE);
		button8.setFont(new Font("Arial", Font.BOLD, 18));
		button8.setHorizontalTextPosition(JButton.CENTER);
		button8.setVerticalTextPosition(JButton.CENTER);
		
		button9.setForeground(Color.WHITE);
		button9.setFont(new Font("Arial", Font.BOLD, 18));
		button9.setHorizontalTextPosition(JButton.CENTER);
		button9.setVerticalTextPosition(JButton.CENTER);
		
		button10.setForeground(Color.WHITE);
		button10.setFont(new Font("Arial", Font.BOLD, 18));
		button10.setHorizontalTextPosition(JButton.CENTER);
		button10.setVerticalTextPosition(JButton.CENTER);
		
		button11.setForeground(Color.WHITE);
		button11.setFont(new Font("Arial", Font.BOLD, 18));
		button11.setHorizontalTextPosition(JButton.CENTER);
		button11.setVerticalTextPosition(JButton.CENTER);
		
		button12.setForeground(Color.WHITE);
		button12.setFont(new Font("Arial", Font.BOLD, 18));
		button12.setHorizontalTextPosition(JButton.CENTER);
		button12.setVerticalTextPosition(JButton.CENTER);
		
		button1.setBorder(BorderFactory.createEmptyBorder());
		button2.setBorder(BorderFactory.createEmptyBorder());
		button3.setBorder(BorderFactory.createEmptyBorder());
		button4.setBorder(BorderFactory.createEmptyBorder());
		button5.setBorder(BorderFactory.createEmptyBorder());
		button6.setBorder(BorderFactory.createEmptyBorder());
		button7.setBorder(BorderFactory.createEmptyBorder());
		button8.setBorder(BorderFactory.createEmptyBorder());
		button9.setBorder(BorderFactory.createEmptyBorder());
		button10.setBorder(BorderFactory.createEmptyBorder());
		button11.setBorder(BorderFactory.createEmptyBorder());
		button12.setBorder(BorderFactory.createEmptyBorder());
		
		StoreListener ourListener = new StoreListener();
		
		button1.addActionListener(ourListener);
		button2.addActionListener(ourListener);
		button3.addActionListener(ourListener);
		button4.addActionListener(ourListener);
		button5.addActionListener(ourListener);
		button6.addActionListener(ourListener);
		button7.addActionListener(ourListener);
		button8.addActionListener(ourListener);
		button9.addActionListener(ourListener);
		button10.addActionListener(ourListener);
		button11.addActionListener(ourListener);
		button12.addActionListener(ourListener);
		
		button1.addMouseListener(ourListener);
		button2.addMouseListener(ourListener);
		button3.addMouseListener(ourListener);
		button4.addMouseListener(ourListener);
		button5.addMouseListener(ourListener);
		button6.addMouseListener(ourListener);
		button7.addMouseListener(ourListener);
		button8.addMouseListener(ourListener);
		button9.addMouseListener(ourListener);
		button10.addMouseListener(ourListener);
		button11.addMouseListener(ourListener);
		button12.addMouseListener(ourListener);
		
		storepanel.add(button1);
		storepanel.add(button2);
		storepanel.add(button3);
		storepanel.add(button4);
		storepanel.add(button5);
		storepanel.add(button6);
		storepanel.add(button7);
		storepanel.add(button8);
		storepanel.add(button9);
		storepanel.add(button10);
		storepanel.add(button11);
		storepanel.add(button12);
	}
	
	private class StorePanel extends JPanel
	{
		private Image image;
		
		public StorePanel(Image image)
		{
			this.image = image;
		}
		
		protected void paintComponent(Graphics g)
		{
			g.drawImage(image, 0, 0, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 32));
			g.drawString("Weapons    Credits", 185, 150);
			g.drawString("Upgrades   Credits", 1045, 150);
		}
	}
	
	private class StoreListener implements ActionListener, MouseListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == button1)
			{
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			}
			else if (e.getSource() == button2)
			{
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			}
			else if (e.getSource() == button3)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button4)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button5)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button6)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button7)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button8)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button9)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button10)
				JOptionPane.showMessageDialog(Menu.frame, "Under Development.");
			else if (e.getSource() == button11)
			{
				Menu.frame.getContentPane().removeAll();
				Menu.frame.getContentPane().add(Menu.myPanel);
				Menu.frame.getContentPane().revalidate(); 
				Menu.frame.getContentPane().repaint();
				Menu.myPanel.setFocusable(true);
				Menu.myPanel.requestFocusInWindow();
			}
			else if (e.getSource() == button12)
			{
				Menu.frame.getContentPane().removeAll();
				Menu.frame.getContentPane().add(Menu.panel);
				Menu.frame.getContentPane().revalidate(); 
				Menu.frame.getContentPane().repaint();
				Menu.panel.setFocusable(true);
				Menu.panel.requestFocusInWindow();
				Menu.panel.keys.clear();
			}
		}
		
		public void mouseEntered(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setIcon(blank2);
			else if (e.getSource() == button2)
				button2.setIcon(blank2);
			else if (e.getSource() == button3)
				button3.setIcon(blank2);
			else if (e.getSource() == button4)
				button4.setIcon(blank2);
			else if (e.getSource() == button5)
				button5.setIcon(blank2);
			else if (e.getSource() == button6)
				button6.setIcon(blank2);
			else if (e.getSource() == button7)
				button7.setIcon(blank2);
			else if (e.getSource() == button8)
				button8.setIcon(blank2);
			else if (e.getSource() == button9)
				button9.setIcon(blank2);
			else if (e.getSource() == button10)
				button10.setIcon(blank2);
			else if (e.getSource() == button11)
				button11.setIcon(blank2);
			else if (e.getSource() == button12)
				button12.setIcon(blank2);
		}
		public void mouseExited(MouseEvent e)
		{
			if (e.getSource() == button1)
				button1.setIcon(blank);
			else if (e.getSource() == button2)
				button2.setIcon(blank);
			else if (e.getSource() == button3)
				button3.setIcon(blank);
			else if (e.getSource() == button4)
				button4.setIcon(blank);
			else if (e.getSource() == button5)
				button5.setIcon(blank);
			else if (e.getSource() == button6)
				button6.setIcon(blank);
			else if (e.getSource() == button7)
				button7.setIcon(blank);
			else if (e.getSource() == button8)
				button8.setIcon(blank);
			else if (e.getSource() == button9)
				button9.setIcon(blank);
			else if (e.getSource() == button10)
				button10.setIcon(blank);
			else if (e.getSource() == button11)
				button11.setIcon(blank);
			else if (e.getSource() == button12)
				button12.setIcon(blank);
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
			else if (e.getSource() == button5)
				button5.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button6)
				button6.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button7)
				button7.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button8)
				button8.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button9)
				button9.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button10)
				button10.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button11)
				button11.setBorder(new LineBorder(Color.RED, 2));
			else if (e.getSource() == button12)
				button12.setBorder(new LineBorder(Color.RED, 2));
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
			else if (e.getSource() == button5)
				button5.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button6)
				button6.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button7)
				button7.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button8)
				button8.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button9)
				button9.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button10)
				button10.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button11)
				button11.setBorder(BorderFactory.createEmptyBorder());
			else if (e.getSource() == button12)
				button12.setBorder(BorderFactory.createEmptyBorder());
		}
	}
}