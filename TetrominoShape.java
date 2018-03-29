import java.awt.Color;

public enum TetrominoShape {
	I (new Color(3, 243, 241)),
	J (new Color (3, 0, 235)),
	L (new Color(246, 155, 1)),
	O (new Color(237, 242, 6)),
	S (new Color (5, 239, 7)),
	T (new Color(164, 4, 229)),
	Z (new Color(234, 4, 4));
	
	private Color color;
	//int[][] points   double[] center of rotation  
	private TetrominoShape(Color clr) {
		color = clr;
	}
	
	public Color getColor() {
		return color;
	}
}
