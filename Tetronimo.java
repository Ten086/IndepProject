public class Tetromino {
	
	TetrominoShape shape;
	int[][] position = new int[4][2];
	TetrominoShape[] shapes = {TetrominoShape.I, TetrominoShape.J, TetrominoShape.L,
				TetrominoShape.O, TetrominoShape.S, TetrominoShape.T, TetrominoShape.Z};
	
	public Tetromino(TetrominoShape s) {
		shape = s;
		position = shape.getCoords();
	}
	
	public Tetromino() {
		
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
	
	public void setInitialPos() {
		changePos(0, 4);
	}
	
	public void changePos(int rShift, int cShift) {
		for (int[] coord : position) {
			coord[0] += rShift;
			coord[1] += cShift;
		}
	}
}
