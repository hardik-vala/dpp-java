package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * The description and specifications of the <i>ChessMetric</i> problem are outlined
 * <a href="http://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482">here</a>.
 * 
 * @author Hardik Vala
 */
public class ChessMetric {

	/** Size of the board (size x size chess board). */
	private int size;
	/** Starting (x, y) coordinates of kingknight. */
	private int[] start;
	/** Ending (x, y) coordinates of kingknight. */
	private int[] end;
	/** # of kingknight moves. */
	private int numMoves;

	/** The value at (i, j) is the # of distinct ways to each coordinates (i, j) from the start
	 * position. */
	private long[][] numWays;

	/**
	 * Constructor.
	 *
	 * @param size - Size of the board.
	 * @param start - Start position.
	 * @param end - End position.
	 * @param numMoves - # of moves.
	 */
	public ChessMetric(int size, int[] start, int[] end, int numMoves) {
		this.size = size;
		this.start = start;
		this.end = end;
		this.numMoves = numMoves;

		this.numWays = new long[size][size];
	}

	/**
	 * Counts the # of distinct ways to move the kingknight from the start to the end position using
	 * exactly the given # of movies.
	 *
	 * @return # of distinct ways.
	 */
	public long count() {
		List<int[]> frontierCoords = new LinkedList<int[]>();
		frontierCoords.add(this.start);
		
		List<int[]> newFrontierCoords;
		int[] coord;
		for (int n = this.numMoves; n > 0; n--) {
			newFrontierCoords = new LinkedList<int[]>();

			Iterator<int[]> it = frontierCoords.iterator();
			while(it.hasNext()) {
				coord = it.next();

				boolean canMoveLeft = coord[1] > 0;
				boolean canMoveDown = coord[0] < (this.size - 1);
				boolean canMoveRight = coord[1] < (this.size - 1);
				boolean canMoveUp = coord[0] > 0;
				
				if (canMoveLeft) {
					this.numWays[coord[0]][coord[1] - 1]++;
					newFrontierCoords.add(new int[] {coord[0], coord[1] - 1});
				}
				if (canMoveDown) {
					this.numWays[coord[0] + 1][coord[1]]++;
					newFrontierCoords.add(new int[] {coord[0] + 1, coord[1]});
				}
				if (canMoveRight) {
					this.numWays[coord[0]][coord[1] + 1]++;
					newFrontierCoords.add(new int[] {coord[0], coord[1] + 1});
				}
				if (canMoveUp) {
					this.numWays[coord[0] - 1][coord[1]]++;
					newFrontierCoords.add(new int[] {coord[0] - 1, coord[1]});
				}
				
				// Can move one tile diagonally in the SW direction.
				if (canMoveLeft && canMoveDown) {
					this.numWays[coord[0] + 1][coord[1] - 1]++;
					newFrontierCoords.add(new int[] {coord[0] + 1, coord[1] - 1});
				}
				// Can move one tile diagonally in the SE direction.
				if (canMoveDown && canMoveRight) {
					this.numWays[coord[0] + 1][coord[1] + 1]++;
					newFrontierCoords.add(new int[] {coord[0] + 1, coord[1] + 1});
				}
				// Can move one tile diagonally in the NE direction.
				if (canMoveRight && canMoveUp) {
					this.numWays[coord[0] - 1][coord[1] + 1]++;
					newFrontierCoords.add(new int[] {coord[0] - 1, coord[1] + 1});
				}
				// Can move one tile diagonally in the NW direction.
				if (canMoveUp && canMoveLeft) {
					this.numWays[coord[0] - 1][coord[1] - 1]++;
					newFrontierCoords.add(new int[] {coord[0] - 1, coord[1] - 1});
				}
				
				boolean canMoveLeftLeft = coord[1] > 1;
				boolean canMoveDownDown = coord[0] < (this.size - 2);
				boolean canMoveRightRight = coord[1] < (this.size - 2);
				boolean canMoveUpUp = coord[0] > 1;
				
				// Can move in an L-shape two tiles to the left and then one tile up.
				if (canMoveLeftLeft && canMoveUp) {
					this.numWays[coord[0] - 1][coord[1] - 2]++;
					newFrontierCoords.add(new int[] {coord[0] - 1, coord[1] - 2});
				}
				// Can move in an L-shape two tiles up and then one tile left.
				if (canMoveLeft && canMoveUpUp) {
					this.numWays[coord[0] - 2][coord[1] - 1]++;
					newFrontierCoords.add(new int[] {coord[0] - 2, coord[1] - 1});
				}
				
				// Can move in an L-shape two tiles up and then one tile right.
				if (canMoveRight && canMoveUpUp) {
					this.numWays[coord[0] - 2][coord[1] + 1]++;
					newFrontierCoords.add(new int[] {coord[0] - 2, coord[1] + 1});
				}
				// Can move in an L-shape two tiles to the right and then one tile up.
				if (canMoveRightRight && canMoveUp) {
					this.numWays[coord[0] - 1][coord[1] + 2]++;
					newFrontierCoords.add(new int[] {coord[0] - 1, coord[1] + 2});
				}
				
				// Can move in an L-shape two tiles to the right and then one tile down.
				if (canMoveRightRight && canMoveDown) {
					this.numWays[coord[0] + 1][coord[1] + 2]++;
					newFrontierCoords.add(new int[] {coord[0] + 1, coord[1] + 2});
				}
				// Can move in an L-shape two tiles down and then one tile right.
				if (canMoveRight && canMoveDownDown) {
					this.numWays[coord[0] + 2][coord[1] + 1]++;
					newFrontierCoords.add(new int[] {coord[0] + 2, coord[1] + 1});
				}
				
				// Can move in an L-shape two tiles down and then one tile left.
				if (canMoveLeft && canMoveDownDown) {
					this.numWays[coord[0] + 2][coord[1] - 1]++;
					newFrontierCoords.add(new int[] {coord[0] + 2, coord[1] - 1});
				}
				// Can move in an L-shape two tiles to the left and then one tile down.
				if (canMoveLeftLeft && canMoveDown) {
					this.numWays[coord[0] + 1][coord[1] - 2]++;
					newFrontierCoords.add(new int[] {coord[0] + 1, coord[1] - 2});
				}
			}

			frontierCoords = newFrontierCoords;
		}
		
		return this.numWays[this.end[0]][this.end[1]];
	}
	
}
