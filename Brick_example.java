import javax.swing.JFrame;

public class Brick_example {

	public static void main(String[] args) {
		JFrame main_part = new JFrame();
		gameplay_ex game_play = new gameplay_ex();
		main_part.setBounds(10,10,700,600);
		main_part.setTitle("Brick breaker game xmpl");
		main_part.setResizable(false);
		main_part.setVisible(true);
		main_part.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_part.add(game_play);
		
	}

}
