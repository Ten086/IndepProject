import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetrisPanel extends JPanel {
	
	private int width = 500;
	private int height = 500;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g, 50, 10);
	}
	//hecc pls help
	/*public void drawGrid(Graphics g, int margin, int squareSize) {
		this.setPreferredSize(500, 500);
		//horiz
		for (int i = margin; i <= width - margin; i += squareSize) {
			g.drawRect(margin, i, width - 2 * margin, 1);
		}
		for (int i = margin; i <= height - margin; i += squareSize) {
			g.drawRect(i, margin, 1, height - 2 * margin);
		}
	}*/
	
	public void drawGrid(Graphics g, int margin, int numBoxes) {
		int boxSize = width / numBoxes;
		int lineLength = width - (2 * margin);
		System.out.println("width: " + width + " boxSize: " + boxSize);
		for (int i = 0; i <= numBoxes; i++) {
			g.drawRect((i * boxSize) + margin, margin, 1, lineLength);
			g.drawRect(margin, (i * boxSize) + margin, lineLength, 1);
		}
	}
	private void setPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}