package problems;


/**
 * The description and specifications of the <i>Longest Balanced Subsequence</i> problem are
 * outlined <a href="http://stackoverflow.com/questions/13074163/longest-subsequence-of-s-that-is-balanced">here</a>.
 * 
 * @author Hardik Vala
 */
public class LongestBalancedSubsequence {

	/** Sequence of '(' and ')' characters. */
	String seq;

	/** (i, j) stores the length of the longest balanced subsequence in S[i...j], where S is the
	 * sequence. */
	int[][] lengths;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence as a string.
	 * @precondition Sequence must consist solely of '(' and ')' characters.
	 */
	public LongestBalancedSubsequence(String seq) {
		this.seq = seq;

		this.lengths = new int[seq.length()][seq.length()];
	}

	/**
	 * Calculates the length of the longest balanced subsequence using DP, resulting in an O(N**2)
	 * solution, where N is the length of the sequence, w.r.t. both time and space
	 *
	 * @return Length of longest balanced subsequence.
	 */
	public int calculateDP() {
		int seqLen = this.seq.length();
		for (int l = 1; l < seqLen; l++) {
			for (int i = 0; i < seqLen - l; i++) {
				// Ends are balanced.
				if (this.seq.charAt(i) == '(' && this.seq.charAt(i + l) == ')') {
					// lengths[i, j] = max(lengths[i + 1, j - 1] + 2, lengths[i + 1, j] + 
					// lengths[i, j - 1] - lengths[i + 1, j - 1]), where j = i + l.
					if (this.lengths[i + 1][i + l - 1] + 2 > this.lengths[i + 1][i + l] +
						this.lengths[i][i + l - 1] - this.lengths[i + 1][i + l - 1])
						this.lengths[i][i + l] = this.lengths[i + 1][i + l - 1] + 2;
					else
						this.lengths[i][i + l] = this.lengths[i + 1][i + l] +
							this.lengths[i][i + l - 1] - this.lengths[i + 1][i + l - 1];
				// Ends are not balanced.
				} else {
					// lengths[i, j] = max(lengths[i + 1, j], lengths[i, j - 1]), where j = i + l.
					if (this.lengths[i + 1][i + l] > this.lengths[i][i + l - 1])
						this.lengths[i][i + l] = this.lengths[i + 1][i + l];
					else
						this.lengths[i][i + l] = this.lengths[i][i + l - 1];
				}
			}
		}

		return this.lengths[0][seqLen - 1];
	}
	
	/**
	 * Calculates the length of the longest balanced subsequence without using DP, resulting in an
	 * O(N) time solution using O(1) space, where N is the length of the sequence.
	 *
	 * @return Length of longest balanced subsequence.
	 */
	public int calculateNonDP() {
		int longestLength = 0;
		int openParenCnt = 0;
		for (int i = 0; i < this.seq.length(); i++) {
			if (this.seq.charAt(i) == '(')
				openParenCnt++;
			else if (openParenCnt > 0){
				openParenCnt--;
				longestLength += 2;
			}
		}

		return longestLength;
	}
}
