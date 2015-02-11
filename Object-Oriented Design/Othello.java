/*
Othello is played as follows: 
Each Othello piece is white on one side and black on the other. 
When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom, it is said to be captured and its color is flippeed.
On your turn, you must capture at least one of your opponent's pieces.
The game ends when either user has no more valid moves.
The win is assigned to the person with the most pieces. 
Implement the object-oriented design for Othello.
*/

//class: board, piece, game, player
//enum: color, direction

public enum Direction{
	left, right, up, down
}

public enum Color{
	White, Black
}

public class Game{
	private Player[] players;
	private static Game instance;
	private Board board;
	private final int ROWS = 10;
	private final int COLS = 10;

	private Game(){
		board = new Board(ROWS, COLS);
		players = new Player[2];
		players[0] = new Player(Color.Black);
		players[1] = new Player(Color.White);

	}

	public static Game getInstance(){
		if (istance == null){
			instance = new Game();
		}
		return instance;
	}
	public Board getBoard(){
		return board;
	}
}

public class Player{
	private Color color;

	public Player(Color c){
		color = c;
	}
	public Color getColor(){
		return color;
	}

	public int getScore(){
		return Game.getInstance().getBoard().getScoreForColor(color);
	}

	public boolean playPiece(int row, int col){
		return Game.getInstance().getBoard().placeColor(row, col, color);
	}
}

public class Piece{
	private Color color;

	public Piece(Color c){
		color = c;
	}

	public void flip(){
		if (color == Color.Black){
			color = Color.White;
		}
		else
			color = Color.Black;
	}

	public Color getColor(){
		return color;
	}
}

public class Board{
	private int blackCount = 0;
	private int whiteCount = 0;
	private Piece[][] board;

	public Board(int rows, int cols){
		board = new Piece[rows][cols];
	}

	//initialize center black and white pieces
	public void initialize(){
		int middleRow = board.length / 2;
		int middleCol = board[middleRow].length / 2;
		board[middleRow][middleCol] = new Piece(Color.White);
		board[middleRow + 1][middleCol] = new Piece(Color.Black);
		board[middleRow + 1][middleCol + 1] = new Piece(Color.White);
		board[middleRow][middleCol + 1] = new Piece(Color.Black);
		blackCount = 2;
		whiteCount = 2;
	}

	public boolean placeColor(int row, int col, Color color){
		if (board[row][col] != null)
			return false;

		//attemp to flip each of the four directions
		int[] results = new int[4];
		results[0] = flipSection(row - 1, col, color, Direction.up);
		results[1] = flipSection(row + 1, col, color, Direction.down);
		results[2] = flipSection(row, col - 1, color, Direction.left);
		results[3] = flipSection(row, col + 1, color, Direction.right);

		int flipped = 0;
		for (int result : results){
			if (result > 0)
				flipped += result;
		}

		if (flipped < 0)
			return false;

		board[row][col] = new Piece(color);
		updateScore(color, flipped + 1);
		return true;
	}

	public int flipSection(int row, int col, Color color, Direction d){
		int r = 0, c = 0;
		switch(d){
			case up:
				r = -1;
				break;
			case down:
				r = 1;
				break;
			case left:
				c = -1; 
				break;
			case right:
				c = 1;
				break;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == null)
			return -1;
		if (board[row][col].getColor == color)
			return 0;

		int flipped = flipSection(row + r, col - c, color, d);
		if (flipped < 0)
			return -1;

		board[row][col].flip();
		return flipped + 1;
	}	

	public void updateScore(Color newColor, int newPieces){
		if (newColor == Color.Black){
			whiteCount -= newPieces - 1;
			blackCount += newPieces;
		}
		else{
			whiteCount += newPieces;
			blackCount -= newPiece - 1;
		}
	}

	public int getScoreForColor(Color c){
		if (c == Color.black)
			return blackCount;
		else
			return whiteCount;
	}
}

public class Location{
	private int row;
	private int col;
	public Location(int r, int c){
		row = r;
		col = c;
	}

	public boolean isSameAs(int r, int c){
		return row == r && col == c;
	}

	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
}

public class AUtomator{
	private Player[] players;
	private Player lastPlayer = null;
	public ArrayList<Location> remainingMoves = new ArrayList<Location>();
	private static Automator instance;

	private Automator(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				Location loc = new Location(i, j);
				remainingMoves.add(loc);
			}
		}
	}

	public static Automator getInstance(){
		if (instance == null)
			instance = new Automator();
		return instance;
	}

	public void initialize(Player[] ps){
		players = ps;
		lasterPlayer = player[1];
	}

	public void shuffle(){
		for (int i = 0; i < remainingMoves.size(); i++){
			int t = AssortedMethods.randomIntInRange(i, remainingMoves.size() - 1);
			Location other = remainingMoves.get(t);
			Location current = remainingMoves.get(i);
			remainingMoves.set(t, current);
			remainingMoves.set(i, other);
		}
	}

	public void removeLocation(int r, int c){
		for (int i = 0; i < remainingMoves.size(); i++){
			Location loc = remainingMoves.get(i);
			if (loc.isSameAs(r, c)){
				remainingMoves.remove(i);
			}
		}
	}

	public Location getLocation(int index){
		return remainingMoves.get(index);
	}

	public boolean playRandom(){
		Board board = Game.getInstance().getBoard();
		shuffle();
		lastPlayer = lastPlayer == player[0] ? player[1] : player[0];
		String color = lastPlayer.getColor().toString();
		for (int i = 0; i < remainingMoves.size(); i++){
			Location loc = remainingMoves.get(i);
			boolean success = lastPlayer.playPiece(loc.getRow(), loc.getCol());

			if (success){
				return true;
			}
		}
		return false;
	}

	public boolean isOver(){
		if (player[0].getScore() == 0 || player[1].getScore() == 0){
			return true;
		}
		return false;
	}
}
public class Solution{
	public static void main(String args[]){
		Game game = Game.getInstance();
		game.getBoard().initialize();
		Automator automator = Automator.getInstance();
		while (!automator.isOver() && automator.playRandom())
	}
}