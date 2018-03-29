import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tetronimo {
	
	private TetrominoShape shape;
	private Color color;
	private int[][] coordinates;
	
	public static final int boxSize = 20;
	public static final Color lightBlue = new Color(3, 243, 241);
	public static final Color darkBlue = new Color(3, 0, 235);
	public static final Color orange = new Color(246, 155, 1);
	public static final Color yellow = new Color(237, 242, 6);
	public static final Color green = new Color(5, 239, 7);
	public static final Color purple = new Color(164, 4, 229);
	public static final Color red = new Color(234, 4, 4);

	public static void main(String[] args) {
		//this is just me being dumb and trying to draw stuff ignore
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 500));
		TetrisPanel panel = new TetrisPanel();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public Tetronimo(TetrominoShape s) {
		shape = s;
		assignColor();
	}

	public void assignColor() {
		switch (shape) {
			case I:
				color = lightBlue;
				break;
			case J:
				color = darkBlue;
				break;
			case L:
				color = orange;
				break;
			case O:
				color = yellow;
				break;
			case S:
				color = green;
				break;
			case T:
				color = purple;
				break;
			case Z:
				color = red;
				break;
			default: 
				color = Color.magenta; //if something goes wrong it'll be very pink
				break;
		}
	}
}