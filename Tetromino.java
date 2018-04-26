import java.awt.Color;

public class Tetromino {
	
	private TetrominoShape shape;
	private int[][] position = new int[4][2];
	private double[] COR = new double[2];
	private Color color;
	
	public Tetromino(TetrominoShape s) {
		shape = s;
		position = getInitialPosCopy();
		color = shape.getColor();
	}
	
	public Tetromino() {
		TetrominoShape[] shapes = {TetrominoShape.I, TetrominoShape.J, TetrominoShape.L,
				TetrominoShape.O, TetrominoShape.S, TetrominoShape.T, TetrominoShape.Z};
		int randomIndex = (int) (Math.random() * (shapes.length));
		shape = shapes[randomIndex];
		position = getInitialPosCopy();
		color = shape.getColor();
	}
	
	public TetrominoShape getShape() {
		return shape;
	}
	
	public Color getColor() {
		return color;
	}
	public void printPos() {
		for (int[] coords : position) {
			System.out.print("row " + coords[0] + ", col " + coords[1] + " | ");
		}
	}
	
	public int[][] getInitialPosCopy() {
		int[][] orig = shape.getCoords();
		int[][] copy = new int[4][2];
		for (int i = 0; i < orig.length; i++) {
			for (int j = 0; j < orig[0].length; j++) {
				copy[i][j] = orig[i][j];
			}
		}
		return copy;
	}
	public int[][] getPos() {
		return position;
	}
	
	public Point getSetMino() {
		Point setMino = null;
		for (Point p : Point.getSetMinoList()) {
			if (shape == p.getShape()) {
				setMino = p;
			}
		}
		return setMino;
	}
	
	public int[] getLowestCoord() {
		int[] lowest = new int[2];
		for (int[] coords : position) {
			if (coords[0] > lowest[0]) {
				lowest = coords;
			}
		}
		return lowest;
	}
	
	public void setInitialPos() {
		position = getInitialPosCopy();
		changePos(0, 4);
	}
	
	public void changePos(int rShift, int cShift) {
		for (int[] coord : position) {
			coord[0] += rShift;
			coord[1] += cShift;
		}
		COR[0] += rShift;
		COR[1] += cShift;
	}
	
	public void rotateCCW() {
		double[][] tempPos = new double[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				tempPos[i][j] = position[i][j] - COR[j];
			}
		}
		Matrix tempMat = new Matrix(tempPos);
		tempMat.rotCClws();
		tempPos = tempMat.getMatrix();
		double[][] almostPos = new double[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				almostPos[i][j] = tempPos[i][j] + COR[j];
			}
		}
		int[][] intPos = new int[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				intPos[i][j] = (int) almostPos[i][j];
			}
		}
		position = intPos;
	}
	
	public void rotateCW() {
		double[][] tempPos = new double[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				tempPos[i][j] = position[i][j] - COR[j];
			}
		}
		Matrix tempMat = new Matrix(tempPos);
		tempMat.rotClws();
		tempPos = tempMat.getMatrix();
		double[][] almostPos = new double[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				almostPos[i][j] = tempPos[i][j] + COR[j];
			}
		}
		int[][] intPos = new int[position.length][position[0].length];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				intPos[i][j] = (int) almostPos[i][j];
			}
		}
		position = intPos;
	}
	
	
	public boolean atBottom() {
		boolean atBot = false;
		for (int[] coord : position) {
			if (coord[0] == Grid.ROWS - 1) {
				atBot = true;
			}
		}
		return atBot;
	}
	
	public boolean collidesLeft(TetrisArray array) {
		boolean collides = false;
		for (int[] coord : position) {
			for (Point p : Point.getSetMinoList()) {
				int row = coord[0];
				int col = coord[1];
				if (col >= 0 && array.getPoint(row, col - 1) == p) {
					collides = true;
				}
			}
		}
		return collides;
	}
	
	public boolean collidesRight(TetrisArray array) {
		boolean collides = false;
		for (int[] coord : position) {
			for (Point p : Point.getSetMinoList()) {
				int row = coord[0];
				int col = coord[1];
				if (col < Grid.COLS && array.getPoint(row, col + 1) == p) {
					collides = true;
				}
			}
		}
		return collides;
	}
	
	public boolean collidesBot(TetrisArray array) {
		boolean collides = false;
		for (int[] coord : position) {
			for (Point p : Point.getSetMinoList()) {
				int row = coord[0];
				int col = coord[1];
				if (row < Grid.ROWS && array.getPoint(row - 1, col) == p) {
					collides = true;
				}
			}
		}
		return collides;
	}
}
