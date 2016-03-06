package problems;

import java.util.HashSet;

/**
 * The description and specifications of the <i>Avoid Roads</i> problem are outlined here:
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 * 
 * @author Hardik Vala
 */
public class AvoidRoads {

	public static long numWays (int width, int length, String[] bad) {
		long[][] numWays = new long[width + 1][length + 1];
	
		HashSet<BadBlock> badBlocks = parseBad(bad);
		
		if ((width > 0) && !badBlocks.contains(new BadBlock(0, 0, 1, 0))) numWays[1][0] = 1;	
		if ((length > 0) && !badBlocks.contains(new BadBlock(0, 0, 0, 1))) numWays[0][1] = 1;
		
		for (int i = 0; i <= width; i++) {
			for (int j = 0; j <= length; j++) {
				if ((i > 0) && !badBlocks.contains(new BadBlock(i - 1, j, i, j))) numWays[i][j] += numWays[i - 1][j];
				if ((j > 0) && !badBlocks.contains(new BadBlock(i, j - 1, i, j))) numWays[i][j] += numWays[i][j - 1];
			}
		}
		
		return numWays[width][length];
	}
	
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
	 * Convenience class for handling "bad" blocks.
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
			return ((this.x1 == bb.x1) && (this.y1 == bb.y1) && (this.x2 == bb.x2) && (this.y2 == bb.y2));
		}
		
		public int hashCode () {
			return (new Integer(this.x1)).hashCode() + 2 * (new Integer(this.y1)).hashCode() + 3 * (new Integer(this.x2)).hashCode() + 5 * (new Integer(this.y2)).hashCode();  
		}
		
		public String toString () {
			return this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2;
		}
	}
}
