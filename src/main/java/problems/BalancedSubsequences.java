package problems;


/**
 * The description and specifications of the <i>Balanced Subsequences</i> problem are
 * outlined <a href="https://www.quora.com/profile/Michal-Fori%C5%A1ek/Posts/Solution-for-Brackets-Subsequences">here</a>.
 * 
 * @author Hardik Vala
 */
public class BalancedSubsequences {

	/** Sequence of '(' and ')' characters, not necessarily balanced. */
	String seq;

	/** (i, j) stores the # of valid suffixes for the current subsequence assumming that S[i] was
	 * the last character used, where S is the sequence, and there are currently j open parentheses. */
	int[][] counts;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence as a string.
	 * @precondition Sequence must consist solely of '(' and ')' characters, but not necessarily
	 *     balanced.
	 */
	public BalancedSubsequences(String seq) {
		this.seq = seq;

		this.counts = new int[seq.length()][seq.length()];
	}

	private int countHelper(int i, int j) {
		if (i >= 0 && this.counts[i][j] >= 0) return this.counts[i][j];

		int count = (j == 0) ? 1 : 0;

		for (int k = i + 1; k < this.seq.length(); k++) {
			if (this.seq.charAt(k) == '(') {
				count += this.countHelper(k, j + 1);
				break;
			}
		}

		if (j > 0) {
			for (int k = i + 1; k < this.seq.length(); k++) {
				if (this.seq.charAt(k) == ')') {
					count += this.countHelper(k, j - 1);
					break;
				}
			}
		}

		if (i >= 0) this.counts[i][j] = count;

		return count;
	}

	/**
	 * Counts the # of unqiue balanced subsequences with O(N**2) time and space, where N is the
	 * length of the sequence. (Doesn't really employ a DP approach except for the fact that it
	 * makes use of memoization.)
	 *
	 * @return # of unique balanced subsequences.
	 */
	public int count() {
		for (int i = 0; i < this.seq.length(); i++) {
			for (int j = 0; j < this.seq.length(); j++) {
				this.counts[i][j] = -1;
			}
		}

		return countHelper(-1, 0);
	}
	
}
