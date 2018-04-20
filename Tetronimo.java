public class Tetromino {
	
	TetrominoShape shape;
	int[][] position = new int[4][2];
	
	public Tetromino(TetrominoShape s) {
		shape = s;
		position = shape.getCoords();
	}
	
	public Tetromino() {
		TetrominoShape[] shapes = {TetrominoShape.I, TetrominoShape.J, TetrominoShape.L,
				TetrominoShape.O, TetrominoShape.S, TetrominoShape.T, TetrominoShape.Z};
		int randomIndex = (int) (Math.random() * (shapes.length));
		shape = shapes[randomIndex];
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
		position = shape.getCoords();
		changePos(0, 4);
	}
	
	public void changePos(int rShift, int cShift) {
		for (int[] coord : position) {
			coord[0] += rShift;
			coord[1] += cShift;
		}
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
	/*public void rotate() {
		int posLength = position.length;
		int[] rows = new int[posLength];
		int[] cols = new int[posLength];
		for (int i = 0; i < posLength; i++) {
			rows[i] = position[i][0];
			cols[i] = position[i][1];
			position[i][0] = cols[i];
			position[i][1] = rows[i];
		}
	}*/
	
}
