import javax.swing.JButton;	
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JFrame;

public class Brick_breaker extends JFrame{
	public static void main(String[] args) {
		for(int i =1;i<11;i++) {
			bricks[i-1]=i;
		}
		new Brick_breaker();
	}
	
	private static JButton b;
	private JFrame k;
	private static int[] bricks= new int[10];
	private boolean end_game=false;
	private DrawingComponent drawing;
	private Brick_breaker start_game;
	private int ball_x=500;
	private int ball_y=400;
	private int platform_x=450;
	private int platform_y=750;
	private Graphics g;
	
	Brick_breaker(){
		
		k = new JFrame();
		Clicklistener click= new Clicklistener();
		b=new JButton("click me");
		
		k.setDefaultCloseOperation(EXIT_ON_CLOSE);
		k.setLayout(null);
		k.setSize(1000, 800);
		k.setVisible(true);
		k.setLocationRelativeTo(null);
		
		b.setBounds(400, 300, 150, 80);
		k.add(b);
		b.addActionListener(click);
	
	 }

		class Clicklistener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b) {
					//k.getContentPane().removeAll();
					//k.remove(b);
					//k.add(moving_panel);
					//k.repaint();
					start_game= new Brick_breaker();
					start_game.run();
					
				}
			}
		}
		
		public void paint(Graphics g){
			super.paint(g);
			g.setColor(Color.green);
			g.drawRect(platform_x, platform_y, 100, 100);
			g.setColor(Color.red);
			g.drawOval(ball_x,ball_y,50,50);
		}
		
		public void run() {

			k.remove(b);
			
			while(!end_game) {
				drawing = new DrawingComponent();
				k.repaint();
				k.add(drawing);
			}
				
		}
		
		//private void movement(java.awt.event.KeyEvent event) {
			//int key = event.getKeyCode();
			
			//switch(key) {
				//case KeyEvent.VK_RIGHT:
					
			//}
		//}
		
	}

	class DrawingComponent extends JComponent{
		public void paint(Graphics graph0) {
			Graphics2D graph = (Graphics2D) graph0;
			
		}
	}