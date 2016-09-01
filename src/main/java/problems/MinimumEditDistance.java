package problems;

import java.lang.Math;


/**
 * The description and specifications of the <i>Minimum Edit Distance/i> problem are outlined
 * <a href="http://codercareer.blogspot.ca/2011/12/no-25-edit-distance.html">here</a>.
 * 
 * @author Hardik Vala
 */
public class MinimumEditDistance {
	
	/** Input strings, where S1.length() >= S2.length(). */
    private String S1;
	private String S2;

	/**
	 * Constructor.
	 *
     * @param S1 - First input string.
	 * @param S2 - Second input string.
	 */
	public MinimumEditDistance(String S1, String S2) {
        if (S1.length() >= S2.length()) {
            this.S1 = S1;
            this.S2 = S2;
        } else {
            this.S1 = S2;
            this.S2 = S1;
        }
	}

	/**
	 * Finds the minimum edit distance between the two input strings, S1 and S2, using DP, building
     * an (M + 1) x (N + 1) matrix where index (i, j) stores the minimum edit distance between
     * S1[:i + 1] and S2[:j + 1] (M and N are the lengths of S1 and S2, respectively). This results
     * in a O(MN) running-time and O(MN) space solution.
	 *
	 * @return Minimum edit distance.
	 */
	public int calculateWithQuadraticSpace() {
        // Index (i, j) of the matrix stores the minimum edit distance between 1[:i + 1] and
        // S2[:j + 1].
        int[][] minEditDists = new int[this.S1.length() + 1][this.S2.length() + 1];

        for (int i = 0; i <= this.S1.length(); i++) minEditDists[i][0] = i;
        for (int j = 0; j <= this.S2.length(); j++) minEditDists[0][j] = j;

        for (int i = 1; i <= this.S1.length(); i++) {
            for (int j = 1; j <= this.S2.length(); j++) {
                if (this.S1.charAt(i - 1) == this.S2.charAt(j - 1))
                    minEditDists[i][j] = minEditDists[i - 1][j - 1];
                else {
                    int insertionCost = minEditDists[i - 1][j] + 1;
                    int deletionCost = minEditDists[i][j - 1] + 1;
                    int substitutionCost = minEditDists[i - 1][j - 1] + 1;
                    minEditDists[i][j] = Math.min(insertionCost,
                        Math.min(deletionCost, substitutionCost));
                }
            }
        }

        return minEditDists[this.S1.length()][this.S2.length()];
	}

    /**
     * Finds the minimum edit distance between the two input strings, S1 and S2, using DP, but
     * instead of building the full (M + 1) x (N + 1) matrix like the {@link #calculate() calculate}
     * method, only two rows of the matrix are tracked at-a-time (M and N are the lengths of S1 and
     * S2, respectively). This results in a O(MN) running-time and O(min(M, N)) space solution.
     *
     * @return Minimum edit distance.
     */
    public int calculateWithLinearSpace() {
        // Index j stores the minimum edit distance between S1[:i] and S2[:j + 1], where i will
        // range from 0 to S1.length().
        int[] prevMinEditDists = new int[this.S2.length() + 1];
        for (int j = 0; j <= this.S2.length(); j++) prevMinEditDists[j] = j;

        // Index j stores the minimum edit distance between S1[:i + 1] and S2[:j + 1], , where i
        // will range from 0 to S1.length().
        int[] currMinEditDists = new int[this.S2.length() + 1];
        for (int i = 1; i <= this.S1.length(); i++) {
            currMinEditDists[0] = i;
            for (int j = 1; j <= this.S2.length(); j++) {
                if (this.S1.charAt(i - 1) == this.S2.charAt(j - 1))
                    currMinEditDists[j] = prevMinEditDists[j - 1];
                else {
                    int insertionCost = prevMinEditDists[j] + 1;
                    int deletionCost = currMinEditDists[j - 1] + 1;
                    int substitutionCost = prevMinEditDists[j - 1] + 1;
                    currMinEditDists[j] = Math.min(insertionCost,
                        Math.min(deletionCost, substitutionCost));
                }
            }

            prevMinEditDists = currMinEditDists;
            currMinEditDists = new int[this.S1.length() + 1];
        }

        return prevMinEditDists[this.S2.length()];
    }

}
