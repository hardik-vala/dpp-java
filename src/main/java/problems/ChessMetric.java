package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


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
		int numMoves = this.numMoves;

		Queue<int[]> frontierCoords = new LinkedList<int[]>();
		frontierCoords.add(this.start);
		
		int[] coord;
		while (numMoves > 0) {
			Iterator<int[]> it = frontierCoords.iterator();
			
			for (coord = it.next(); it.hasNext(); it.remove()) {
				boolean canAccLeftCoord = coord[0] > 0;
				boolean canAccBotCoord = coord[1] < (this.size - 1);
				boolean canAccRightCoord = coord[0] < (this.size - 1);
				boolean canAccTopCoord = coord[1] > 0;
				
				if (canAccLeftCoord) {
					this.numWays[coord[0] - 1][coord[1]]++;
					int[] coordToAdd = {coord[0] - 1, coord[1]};
					frontierCoords.add(coordToAdd);
				}
				if (canAccBotCoord) {
					this.numWays[coord[0]][coord[1] + 1]++;
					int[] coordToAdd = {coord[0], coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord) {
					this.numWays[coord[0] + 1][coord[1]]++;
					int[] coordToAdd = {coord[0] + 1, coord[1]};
					frontierCoords.add(coordToAdd);
				}
				if (canAccTopCoord) {
					this.numWays[coord[0]][coord[1] - 1]++;
					int[] coordToAdd = {coord[0], coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccLeftCoord && canAccBotCoord) {
					this.numWays[coord[0] - 1][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccBotCoord && canAccRightCoord) {
					this.numWays[coord[0] + 1][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord && canAccTopCoord) {
					this.numWays[coord[0] + 1][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccTopCoord && canAccLeftCoord) {
					this.numWays[coord[0] - 1][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				boolean canAccLeftLeftCoord = coord[0] > 1;
				boolean canAccBotBotCoord = coord[1] < (this.size - 2);
				boolean canAccRightRightCoord = coord[0] < (this.size - 2);
				boolean canAccTopTopCoord = coord[1] > 1;
				
				if (canAccLeftLeftCoord && canAccTopCoord) {
					this.numWays[coord[0] - 2][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] - 2, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccLeftCoord && canAccTopTopCoord) {
					this.numWays[coord[0] - 1][coord[1] - 2]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] - 2};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccRightCoord && canAccTopTopCoord) {
					this.numWays[coord[0] + 1][coord[1] - 2]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] - 2};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightRightCoord && canAccTopCoord) {
					this.numWays[coord[0] + 2][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] + 2, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccRightRightCoord && canAccBotCoord) {
					this.numWays[coord[0] + 2][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] + 2, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord && canAccBotBotCoord) {
					this.numWays[coord[0] + 1][coord[1] + 2]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] + 2};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccLeftCoord && canAccBotBotCoord) {
					this.numWays[coord[0] - 1][coord[1] + 2]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] + 2};
					frontierCoords.add(coordToAdd);
				}
				if (canAccLeftLeftCoord && canAccBotCoord) {
					this.numWays[coord[0] - 2][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] - 2, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
			}
			
			numMoves--;
		}
		
		return this.numWays[this.end[0]][this.end[1]];
	}
	
}
