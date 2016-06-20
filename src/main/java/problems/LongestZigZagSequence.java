package problems;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * The description and specifications of the <i>Longest Zig-Zag Sequence</i> problem are outlined here:
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
 * 
 * @author Hardik Vala
 */
public class LongestZigZagSequence {
	
private static int[] SEQUENCE = {70,55,13,2,99,2,80,80,100,19,7,5,5,5,1000,32,32};
	
	// Testing
	public static void main(String[] args) {
		System.out.println("Sequence: " + Arrays.toString(SEQUENCE) + "\n");
		
		System.out.println("Index\t| Longest Len.\t| Longest Subsequence");
		System.out.println("_____________________________________________");
		
		LinkedList<Integer> LZS = null;
		for (int i = 0; i < SEQUENCE.length; i++) {
			LZS = getLZS_DP(SEQUENCE, i);
			System.out.println(i + "\t| " + LZS.size() + "\t\t| " + LZS);
		}
	}
	
	/* Returns the longest zig-zag sequence contained in the parameter sequence from
	 * index 0 to index n. */
	private static LinkedList<Integer> getLZS_DP (int[] sequence, int n) {
		int[][] LZSs = new int[n + 1][2];
		LZSs[0][0] = 1; 
		LZSs[0][1] = 1;
		
		int[][] lastIndex = new int[n + 1][2];
		lastIndex[0][0] = 0; 
		lastIndex[0][1] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if ((sequence[j] < sequence[i]) && ((LZSs[j][1] + 1) > LZSs[i][0])) {
					LZSs[i][0] = LZSs[j][1] + 1;
					lastIndex[i][0] = j;
				} else if ((sequence[j] > sequence[i]) && ((LZSs[j][0] + 1) > LZSs[i][1])) {
					LZSs[i][1] = LZSs[j][0] + 1;
					lastIndex[i][1] = j;
				}	
			}
			
			if (LZSs[i][0] == 0) {
				LZSs[i][0] = 1;
				lastIndex[i][0] = i;
			}
			
			if (LZSs[i][1] == 0) {
				LZSs[i][1] = 1;
				lastIndex[i][1] = i;
			}
		}
		
		int maxIndex1 = 0;
		int maxIndex2 = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				if (LZSs[i][j] > LZSs[maxIndex1][maxIndex2]) {
					maxIndex1 = i;
					maxIndex2 = j;
				}
			}
		}
		
		LinkedList<Integer> LZS = new LinkedList<Integer>();
		int i, j;
		for (i = maxIndex1, j = maxIndex2; lastIndex[i][j] != i; i = lastIndex[i][j], j = (j == 0) ? 1 : 0) {
			LZS.addFirst(sequence[i]);
		}
		LZS.addFirst(sequence[i]);
		
		return LZS;
	}
}
