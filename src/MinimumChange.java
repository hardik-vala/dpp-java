import java.util.HashSet;

/**
 * The description and specifications of the <i>Minimum Change</i> problem are outlined here:
 * 
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg
 * 
 * in the <i>Introduction</i> section.
 * 
 * @author Hardik Vala
 */
public class MinimumChange {

	// Must be non-negative.
	private static final int SUM = 20;
	// Must be positive and distinct.
	private static final int[] COINS = {1, 3, 5};
	
	// Testing
	public static void main(String[] args) {
		System.out.println("Sum\t|\tMin. Coins");
		System.out.println("________|_________________");
		
		for (int i = 0; i <= SUM; i++) {
			System.out.println(i + "\t|\t" + getMinChange_AltDP(i, COINS));
		}
	}
	
	/* Implements the alternative dynamic programming solution described in the final
	 * paragraph of the Introducton section of Topcoder page listed above. */
	private static int getMinChange_AltDP (int s, int[] coins) {
		int[] minChange = new int[s + 1];
		minChange[0] = 0;
		for (int i = 1; i <= s; i++) minChange[i] = Integer.MAX_VALUE;
		
		HashSet<Integer> indicesWithSol = new HashSet<Integer>();
		indicesWithSol.add(0);
		
		while (indicesWithSol.size() < (s + 1)) {
			HashSet<Integer> indicesToAdd = new HashSet<Integer>();
			
			for (Integer i : indicesWithSol) {
				for (int j = 0; j < coins.length; j++) {
					if ((i + coins[j] <= s) &&
						(minChange[i] + 1 < minChange[i + coins[j]])) {
						minChange[i + coins[j]] = minChange[i] + 1;
						indicesToAdd.add(i + coins[j]);
					}
				}
			}
			
			indicesWithSol.addAll(indicesToAdd);
		}
		
		return minChange[s];
	}

}
