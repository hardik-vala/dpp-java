package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The description and specifications of the <i>ChessMetric</i> problem are outlined here:
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
 * 
 * @author Hardik Vala
 */
public class ChessMetric {

	public static long howMany (int size, int[] start, int[] end, int numMoves) {
		long[][] howMany = new long[size][size];
		
		Queue<int[]> frontierCoords = new LinkedList<int[]>();
		frontierCoords.add(start);
		
		int[] coord;
		while (numMoves > 0) {
			Iterator<int[]> it = frontierCoords.iterator();
			
			for (coord = it.next(); it.hasNext(); it.remove()) {
				boolean canAccLeftCoord = coord[0] > 0;
				boolean canAccBotCoord = coord[1] < (size - 1);
				boolean canAccRightCoord = coord[0] < (size - 1);
				boolean canAccTopCoord = coord[1] > 0;
				
				if (canAccLeftCoord) {
					howMany[coord[0] - 1][coord[1]]++;
					int[] coordToAdd = {coord[0] - 1, coord[1]};
					frontierCoords.add(coordToAdd);
				}
				if (canAccBotCoord) {
					howMany[coord[0]][coord[1] + 1]++;
					int[] coordToAdd = {coord[0], coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord) {
					howMany[coord[0] + 1][coord[1]]++;
					int[] coordToAdd = {coord[0] + 1, coord[1]};
					frontierCoords.add(coordToAdd);
				}
				if (canAccTopCoord) {
					howMany[coord[0]][coord[1] - 1]++;
					int[] coordToAdd = {coord[0], coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccLeftCoord && canAccBotCoord) {
					howMany[coord[0] - 1][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccBotCoord && canAccRightCoord) {
					howMany[coord[0] + 1][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord && canAccTopCoord) {
					howMany[coord[0] + 1][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccTopCoord && canAccLeftCoord) {
					howMany[coord[0] - 1][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				boolean canAccLeftLeftCoord = coord[0] > 1;
				boolean canAccBotBotCoord = coord[1] < (size - 2);
				boolean canAccRightRightCoord = coord[0] < (size - 2);
				boolean canAccTopTopCoord = coord[1] > 1;
				
				if (canAccLeftLeftCoord && canAccTopCoord) {
					howMany[coord[0] - 2][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] - 2, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccLeftCoord && canAccTopTopCoord) {
					howMany[coord[0] - 1][coord[1] - 2]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] - 2};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccRightCoord && canAccTopTopCoord) {
					howMany[coord[0] + 1][coord[1] - 2]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] - 2};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightRightCoord && canAccTopCoord) {
					howMany[coord[0] + 2][coord[1] - 1]++;
					int[] coordToAdd = {coord[0] + 2, coord[1] - 1};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccRightRightCoord && canAccBotCoord) {
					howMany[coord[0] + 2][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] + 2, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
				if (canAccRightCoord && canAccBotBotCoord) {
					howMany[coord[0] + 1][coord[1] + 2]++;
					int[] coordToAdd = {coord[0] + 1, coord[1] + 2};
					frontierCoords.add(coordToAdd);
				}
				
				if (canAccLeftCoord && canAccBotBotCoord) {
					howMany[coord[0] - 1][coord[1] + 2]++;
					int[] coordToAdd = {coord[0] - 1, coord[1] + 2};
					frontierCoords.add(coordToAdd);
				}
				if (canAccLeftLeftCoord && canAccBotCoord) {
					howMany[coord[0] - 2][coord[1] + 1]++;
					int[] coordToAdd = {coord[0] - 2, coord[1] + 1};
					frontierCoords.add(coordToAdd);
				}
			}
			
			numMoves--;
		}
		
		return howMany[end[0]][end[1]];
	}
	
}
