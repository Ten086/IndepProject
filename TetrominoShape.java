import java.awt.Color;

public enum TetrominoShape {
	I (new Color(3, 243, 241), "I", new int[][] {{0,0},{0,1},{0,2},{0,3}}, new double[] {0.5, 1.5}),
	J (new Color (3, 0, 235), "J", new int[][] {{0,1},{1,1},{2,1},{2,0}}, new double[] {1.0, 1.0}),
	L (new Color(246, 155, 1), "L", new int[][] {{0,0},{1,0},{2,0},{2,1}}, new double[] {1.0, 0.0}),
	O (new Color(237, 242, 6), "O", new int[][] {{0,0},{0,1},{1,0},{1,1}}, new double[] {0.5, 0.5}),
	S (new Color (5, 239, 7), "S", new int[][] {{1,0},{1,1},{0,1},{0,2}}, new double[] {1.0, 1.0}),
	T (new Color(164, 4, 229), "T", new int[][] {{0,0},{0,1},{0,2},{1,1}}, new double[] {0.0, 1.0}),
	Z (new Color(234, 4, 4), "Z", new int[][] {{0,0},{0,1},{1,1},{1,2}}, new double[] {0.0, 1.0});
	
	private Color color;
	private String name;
	
	private int[][] coords;
	private double[] COR; 
	
	private TetrominoShape(Color clr, String n, int[][] c, double[] cor) {
		color = clr;
		name = n;
		coords = c;
		COR = cor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public int[][] getCoords() {
		return coords;
	}
	
	public String toString() {
		return name;
	}
	
	public double[] getCOR() {
		return COR;
	}
	
}
