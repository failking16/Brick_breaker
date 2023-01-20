import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick_example_map {
	public int[][] map;
	public int brick_width;
	public int brick_height;
	
	public Brick_example_map(int row,int column) {
		map=new int[row][column];
		for(int []map1 :map) {
			for(int j=0;j<map[0].length;j++) {
				map1[j]=1;
			}
		}
		brick_width=540/column;
		brick_height=150/row;
	}
	
	public void draw(Graphics2D g) {
		for(int i = 0; i<map.length;i++) {
			for(int j = 0; j<map[0].length; j++) {
				if(map[i][j]>0) {
					g.setColor(Color.red);
					g.fillRect(j*brick_width+80, i*brick_height+50, brick_width, brick_height);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.BLACK);
					g.drawRect(j*brick_width+80, i*brick_height+50, brick_width, brick_height);
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row,int column) {
		map[row][column]=value;
	}
}
