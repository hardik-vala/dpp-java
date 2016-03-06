import java.util.Arrays;
import java.util.LinkedList;

/**
 * The description of the <i>Longest Increasing Subsequence</i> problem is outlined here:
 * 
 * http://people.csail.mit.edu/bdean/6.046/dp/
 * 
 * @author Hardik Vala
 */
public class LongestIncreasingSubsequence {

	private static int[] SEQUENCE = {5,3,-1,2,4,8,-6,6,7,90,23,1};
	
	// Testing
	public static void main(String[] args) {
		System.out.println("Sequence: " + Arrays.toString(SEQUENCE) + "\n");
		
		System.out.println("Index\t| Longest Len.\t| Longest Subsequence");
		System.out.println("_____________________________________________");
		
		LinkedList<Integer> LIS = null;
		for (int i = 0; i < SEQUENCE.length; i++) {
			LIS = getLIS_DP(SEQUENCE, i);
			System.out.println(i + "\t| " + LIS.size() + "\t\t| " + LIS);
		}
	}

	/* Returns the length and the index of the last term used in a longest increasing
	 * subsequence using a dynamic programming approach. */
	private static int[] getLIS_LengthandLastIndex_DP (int[] sequence, int n) {
		int[][] LISs = new int[n + 1][2];
		LISs[0][0] = 1; 
		LISs[0][1] = 0; 
		
		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if ((sequence[j] < sequence[i]) && ((LISs[j][0] + 1) > LISs[i][0])) {
					LISs[i][0] = LISs[j][0] + 1;
					LISs[i][1] = j;
				}
			}
			
			if (LISs[i][0] == 0) {
				LISs[i][0] = 1;
				LISs[i][1] = i;
			}
		}
		
		return LISs[n];
	}
	
	/* Returns a longest increasing subsequence, as a linked list, using a dynamic
	 * programming approach. */
	private static LinkedList<Integer> getLIS_DP (int[] sequence, int n) {
		int[][] LISs = new int[n + 1][2];
		LISs[0][0] = 1; 
		LISs[0][1] = 0; 
		
		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if ((sequence[j] < sequence[i]) && ((LISs[j][0] + 1) > LISs[i][0])) {
					LISs[i][0] = LISs[j][0] + 1;
					LISs[i][1] = j;
				}
			}
			
			if (LISs[i][0] == 0) {
				LISs[i][0] = 1;
				LISs[i][1] = i;
			}
		}
		
		int maxLengthIndex = 0;
		for (int i = 0; i <= n; i++) {
			if (LISs[i][0] > LISs[maxLengthIndex][0]) maxLengthIndex = i;
		}
		
		LinkedList<Integer> LIS = new LinkedList<Integer>();
		int i;
		for (i = maxLengthIndex; LISs[i][1] != i; i = LISs[i][1]) {
			LIS.addFirst(sequence[i]);
		}
		LIS.addFirst(sequence[i]);
		
		return LIS;
	}
}
