package problems;


/**
 * The description and specifications of the <i>Longest Zig-Zag Subsequence</i> problem are
 * outlined <a href="http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493">here</a>.
 * 
 * @author Hardik Vala
 */
public class LongestZigZagSequence {
	
	/** Sequence. */
	private int[] seq;

	/** Index (i, 0) and (i, 1) store the length of the longest zig-zag subsequence up to the ith
	 * element in the sequence from below and above, respectively (not necessarily including the ith
	 * element). */
	int[][] lengths;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence.
	 */
	public LongestZigZagSequence(int[] seq) {
		this.seq = seq;

		this.lengths = new int[this.seq.length][2];
	}

	/**
	 * Calculates the length of the longest zig-zag subsequence.
	 *
	 * @return Length of longest zig-zag subsequence.
	 */
	public int calculate() {
		for (int i = 0; i < this.seq.length; i++) {
			this.lengths[i][0] = 1;
			this.lengths[i][1] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (this.seq[j] < this.seq[i] && this.lengths[j][1] + 1 > this.lengths[i][0])
					this.lengths[i][0] = this.lengths[j][1] + 1;
				else if (this.seq[j] > this.seq[i] && this.lengths[j][0] + 1 > this.lengths[i][1])
					this.lengths[i][1] = this.lengths[j][0] + 1;
			}
		}

		int maxLength = 0;
		for (int i = 0; i < this.seq.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (this.lengths[i][j] > maxLength)
					maxLength = this.lengths[i][j];
			}
		}

		return maxLength;
	}

}
