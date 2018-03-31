
public class Tetromino {
	
	TetrominoShape shape;
	int[][] position = new int[4][2];
	
	public Tetromino(TetrominoShape s) {
		shape = s;
		position = shape.getCoords();
	}
	
	public TetrominoShape getShape() {
		return shape;
	}
	
	public void printPos() {
		for (int[] coords : position) {
			System.out.print("row " + coords[0] + ", col " + coords[1] + " | ");
		}
	}
	
	public int[][] getPos() {
		return position;
	}
	
	public void changePos(int rShift, int cShift) {
		for (int[] coord : position) {
			coord[0] += rShift;
			coord[1] += cShift;
		}
	}
}
