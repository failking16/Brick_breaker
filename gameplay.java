import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Brick_example_gameplay extends JPanel implements KeyListener,ActionListener{
	
	private boolean play=false;
	private int score=0;
	private int totalbricks=21;
	private Timer timer;
	private int delay;
	private int playerX=310;
	private int ball_x=120;
	private int ball_y=350;
	private int ball_dir_x=-1;
	private int ball_dir_y=-2;
	private Brick_example_map map;
	
	public Brick_example_gameplay(){
		map=new Brick_example_map(3,7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		map.draw((Graphics2D) g);
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(691, 0, 3, 592);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+score, 590, 30);
		
		g.setColor(Color.yellow);
		g.fillRect(playerX,550,100,8);
	
		g.setColor(Color.RED);
		g.fillOval(ball_x, ball_y, 30, 30);
	
		if(ball_x>560) {
			play=false;
			ball_dir_x=0;
			ball_dir_y=0;
			g.setColor(Color.BLACK);
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("gameover" + score,190 ,300);
			
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("press enter", 190, 360);
		}
		
		if(totalbricks==0) {
			play=false;
			ball_dir_x=-1;
			ball_dir_y=-2;
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("gameover" + score,190 ,300);
			
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("press enter", 190, 360);
		}
		g.dispose();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			if(new Rectangle(ball_x,ball_y,20,20).intersects(new Rectangle(playerX,550,10,8))) {
				ball_dir_y=-ball_dir_y;
			}
			A:
			for(int i =0;i<map.map.length;i++) {
				for(int j =0; j<map.map[0].length;j++) {
					if(map.map[i][j]>0) {
						int brickX=j*map.brick_width+80;
						int brickY=i*map.brick_height+50;
						int brick_w=map.brick_width;
						int brick_h=map.brick_height;
						
						Rectangle rect = new Rectangle(brickX,brickY,brick_w,brick_h);
						Rectangle ballrec= new Rectangle(ball_x,ball_y,30,30);
						Rectangle brickrect=rect;
						
						if(ballrec.intersects(brickrect)) {
							map.setBrickValue(0,i,j);
							totalbricks--;
							score+=5;
							
							if(ball_x+19<=brickrect.x || ball_x+1 >=brickrect.x+brick_w) {
								ball_dir_x=-ball_dir_x;
							}else {
								ball_dir_y=-ball_dir_y;
							}
							break A;
						}
					}
				}
				ball_x+=ball_dir_x;
				ball_y+=ball_dir_y;
				if(ball_x < 0 || ball_x>670) {
					ball_dir_x=-ball_dir_x;
				}
				if(ball_y<0) {
					ball_dir_y=-ball_dir_y;
				}
				repaint();
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX<600) {
				Right();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playerX>=10) {
				Left();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			ball_x=120;
			ball_y=350;
			ball_dir_x=-1;
			ball_dir_y=-2;
			score=0;
			playerX=310;
			totalbricks=21;
			map=new Brick_example_map(3,7);
			repaint();
		}
	}
	
	public void Right() {
		play=true;
		playerX+=20;
	}
	
	public void Left() {
		play =true;
		playerX-=20;
	}
	
	public void keyTyped(KeyEvent e) {
		throw new UnsupportedOperationException("unsupported");
	}
	
	public void KeyReleased(KeyEvent e) {
		throw new UnsupportedOperationException("unsupported");.
		
	}
	
}
