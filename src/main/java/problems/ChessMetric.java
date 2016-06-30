package problems;

import java.util.HashMap;
import java.util.Map;


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

	// Convenience class for storing a coordinate on the chess board.
	private static class Coordinate {

		private int[] coordinates;

		private Coordinate(int x, int y) {
			this.coordinates = new int[] {x, y};
		}

		private int getX() {
			return this.coordinates[0];
		}

		private int getY() {
			return this.coordinates[1];
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Coordinate)) return false;

			Coordinate c = (Coordinate) o;
			return (this.coordinates[0] == c.coordinates[0]
				&& this.coordinates[1] == c.coordinates[1]);
		}
		
		@Override
		public int hashCode() {
			return (new Integer(this.coordinates[0])).hashCode()
				+ 2 * (new Integer(this.coordinates[1])).hashCode();  
		}
		
		@Override
		public String toString() {
			return "(" + this.coordinates[0] + " " + this.coordinates[1] + ")";
		}

	}

	/**
	 * Counts the # of distinct ways to move the kingknight from the start to the end position using
	 * exactly the given # of movies.
	 *
	 * @return # of distinct ways.
	 */
	public long count() {
		Map<Coordinate, Long> frontierCoords = new HashMap<Coordinate, Long>();
		frontierCoords.put(new Coordinate(this.start[1], this.start[0]), 1L);
		
		Map<Coordinate, Long> newFrontierCoords;
		Coordinate coord;
		int x;
		int y;
		long count;
		for (int n = this.numMoves; n > 0; n--) {
			newFrontierCoords = new HashMap<Coordinate, Long>();

			for (Map.Entry<Coordinate, Long> e : frontierCoords.entrySet()) {
				coord = e.getKey();
				x = coord.getX();
				y = coord.getY();
				count = e.getValue();

				boolean canMoveLeft = x > 0;
				boolean canMoveDown = y < (this.size - 1);
				boolean canMoveRight = x < (this.size - 1);
				boolean canMoveUp = y > 0;
				
				if (canMoveLeft) {
					long oldCount = this.numWays[y][x - 1];
					this.numWays[y][x - 1] += count;
					Coordinate c = new Coordinate(x - 1, y);
					newFrontierCoords.put(c, oldCount + count);
				}
				if (canMoveDown) {
					long oldCount = this.numWays[y + 1][x];
					this.numWays[y + 1][x] += count;
					Coordinate c = new Coordinate(x, y + 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				if (canMoveRight) {
					long oldCount = this.numWays[y][x + 1];
					this.numWays[y][x + 1] += count;
					Coordinate c = new Coordinate(x + 1, y);
					newFrontierCoords.put(c, oldCount + count);
				}
				if (canMoveUp) {
					long oldCount = this.numWays[y - 1][x];
					this.numWays[y - 1][x] += count;
					Coordinate c = new Coordinate(x, y - 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				
				// Can move one tile diagonally in the SW direction.
				if (canMoveLeft && canMoveDown) {
					long oldCount = this.numWays[y + 1][x - 1];
					this.numWays[y + 1][x - 1] += count;
					Coordinate c = new Coordinate(x - 1, y + 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move one tile diagonally in the SE direction.
				if (canMoveDown && canMoveRight) {
					long oldCount = this.numWays[y + 1][x + 1];
					this.numWays[y + 1][x + 1] += count;
					Coordinate c = new Coordinate(x + 1, y + 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move one tile diagonally in the NE direction.
				if (canMoveRight && canMoveUp) {
					long oldCount = this.numWays[y - 1][x + 1];
					this.numWays[y - 1][x + 1] += count;
					Coordinate c = new Coordinate(x + 1, y - 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move one tile diagonally in the NW direction.
				if (canMoveUp && canMoveLeft) {
					long oldCount = this.numWays[y - 1][x - 1];
					this.numWays[y - 1][x - 1] += count;
					Coordinate c = new Coordinate(x - 1, y - 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				
				boolean canMoveLeftLeft = x > 1;
				boolean canMoveDownDown = y < (this.size - 2);
				boolean canMoveRightRight = x < (this.size - 2);
				boolean canMoveUpUp = y > 1;
				
				// Can move in an L-shape two tiles to the left and then one tile up.
				if (canMoveLeftLeft && canMoveUp) {
					long oldCount = this.numWays[y - 1][x - 2];
					this.numWays[y - 1][x - 2] += count;
					Coordinate c = new Coordinate(x - 2, y - 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move in an L-shape two tiles up and then one tile left.
				if (canMoveLeft && canMoveUpUp) {
					long oldCount = this.numWays[y - 2][x - 1];
					this.numWays[y - 2][x - 1] += count;
					Coordinate c = new Coordinate(x - 1, y - 2);
					newFrontierCoords.put(c, oldCount + count);
				}
				
				// Can move in an L-shape two tiles up and then one tile right.
				if (canMoveRight && canMoveUpUp) {
					long oldCount = this.numWays[y - 2][x + 1];
					this.numWays[y - 2][x + 1] += count;
					Coordinate c = new Coordinate(x + 1, y - 2);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move in an L-shape two tiles to the right and then one tile up.
				if (canMoveRightRight && canMoveUp) {
					long oldCount = this.numWays[y - 1][x + 2];
					this.numWays[y - 1][x + 2] += count;
					Coordinate c = new Coordinate(x + 2, y - 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				
				// Can move in an L-shape two tiles to the right and then one tile down.
				if (canMoveRightRight && canMoveDown) {
					long oldCount = this.numWays[y + 1][x + 2];
					this.numWays[y + 1][x + 2] += count;
					Coordinate c = new Coordinate(x + 2, y + 1);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move in an L-shape two tiles down and then one tile right.
				if (canMoveRight && canMoveDownDown) {
					long oldCount = this.numWays[y + 2][x + 1];
					this.numWays[y + 2][x + 1] += count;
					Coordinate c = new Coordinate(x + 1, y + 2);
					newFrontierCoords.put(c, oldCount + count);
				}
				
				// Can move in an L-shape two tiles down and then one tile left.
				if (canMoveLeft && canMoveDownDown) {
					long oldCount = this.numWays[y + 2][x - 1];
					this.numWays[y + 2][x - 1] += count;
					Coordinate c = new Coordinate(x - 1, y + 2);
					newFrontierCoords.put(c, oldCount + count);
				}
				// Can move in an L-shape two tiles to the left and then one tile down.
				if (canMoveLeftLeft && canMoveDown) {
					long oldCount = this.numWays[y + 1][x - 2];
					this.numWays[y + 1][x - 2] += count;
					Coordinate c = new Coordinate(x - 2, y + 1);
					newFrontierCoords.put(c, oldCount + count);
				}
			}

			frontierCoords = newFrontierCoords;
		}
		
		return this.numWays[this.end[0]][this.end[1]];
	}
	
}
