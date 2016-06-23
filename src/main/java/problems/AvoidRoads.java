package problems;

import java.util.HashSet;


/**
 * The description and specifications of the <i>Avoid Roads</i> problem are outlined
 * <a href="http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709">here</a>.
 * 
 * @author Hardik Vala
 */
public class AvoidRoads {

	/** Width of city grid in blocks. */
	private int width;
	/** Length of city grid in blocks. */
	private int length;
	/** Bad blocks, each in the format "a b c d", denoting a from corner a,b to corner c,d. */
	private String[] bad;

	/** Stores the number of distinct ways to get to i,j from 0,0. */
	private long[][] numWays;

	/**
	 * Constructor.
	 *
	 * @param width - City width.
	 * @param length - City length.
	 * @param bad - Bad blocks.
	 */
	public AvoidRoads(int width, int length, String[] bad) {
		this.width = width;
		this.length = length;
		this.bad = bad;

		this.numWays = new long[this.width + 1][this.length + 1];
	}

	/**
	 * Convenience class for handling a bad block.
	 * 
	 * @author Hardik
	 */
	private static class BadBlock {
		private int x1, y1, x2, y2;
		
		private BadBlock (int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		
		public boolean equals (Object o) {
			if (!(o instanceof BadBlock)) return false;

			BadBlock bb = (BadBlock) o;
			return ((this.x1 == bb.x1)
				&& (this.y1 == bb.y1)
				&& (this.x2 == bb.x2)
				&& (this.y2 == bb.y2));
		}
		
		public int hashCode () {
			return (new Integer(this.x1)).hashCode() + 2 * (new Integer(this.y1)).hashCode() +
				3 * (new Integer(this.x2)).hashCode() + 5 * (new Integer(this.y2)).hashCode();  
		}
		
		public String toString () {
			return this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2;
		}
	}

	// Parses bad blocks given in string format.
	private static HashSet<BadBlock> parseBad (String[] bad) {
		HashSet<BadBlock> badBlocks = new HashSet<BadBlock>();
		
		if (bad.length != 0) {
			for (int i = 0; i < bad.length; i++) {
				String[] badBlockCoordinates = bad[i].split(" ");
				
				int x1 = Integer.parseInt(badBlockCoordinates[0]);
				int y1 = Integer.parseInt(badBlockCoordinates[1]);
				int x2 = Integer.parseInt(badBlockCoordinates[2]);
				int y2 = Integer.parseInt(badBlockCoordinates[3]);
				
				if ((x1 <= x2) && (y1 <= y2)) badBlocks.add(new BadBlock(x1, y1, x2, y2));
				else badBlocks.add(new BadBlock(x2, y2, x1, y1));
			}
		}
		
		return badBlocks;
	}

	/**
	 * Counts the # of distinct paths from the corner of 0,0 that lead to the destination
	 * width, height.
	 *
	 * @return # of distinct paths.
	 */
	public long count() {
		HashSet<BadBlock> badBlocks = parseBad(this.bad);
		
		if ((this.width > 0) && !badBlocks.contains(new BadBlock(0, 0, 1, 0)))
			this.numWays[1][0] = 1;	
		if ((this.length > 0) && !badBlocks.contains(new BadBlock(0, 0, 0, 1)))
			this.numWays[0][1] = 1;
		
		for (int i = 0; i <= this.width; i++) {
			for (int j = 0; j <= this.length; j++) {
				if ((i > 0) && !badBlocks.contains(new BadBlock(i - 1, j, i, j)))
					this.numWays[i][j] += this.numWays[i - 1][j];

				if ((j > 0) && !badBlocks.contains(new BadBlock(i, j - 1, i, j)))
					this.numWays[i][j] += this.numWays[i][j - 1];
			}
		}
		
		return this.numWays[this.width][this.length];
	}
	
}
