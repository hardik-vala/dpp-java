package problems;


/**
 * The description and specifications of the <i>Longest Increasing Subsequence</i> problem are
 * outlined <a href="http://people.csail.mit.edu/bdean/6.046/dp/">here</a>.
 * 
 * @author Hardik Vala
 */
public class LongestIncreasingSubsequence {

	/** Sequence. */
	int[] seq;

	/** Index i stores the length of the longest increasing subsequence up to the ith element in the
	  * sequence (not necessarily including the ith element). */
	int[] lengths;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence.
	 */
	public LongestIncreasingSubsequence(int[] seq) {
		this.seq = seq;

		this.lengths = new int[seq.length + 1];
	}

	/**
	 * Calculates the length of the longest increasing subsequence.
	 *
	 * @return Length of longest increasing subsequence.
	 */
	public int calculate() {
		this.lengths[0] = 1; 
		
		for (int i = 1; i <= this.seq.length; i++) {
			for (int j = i - 1; j > 0; j--) {
				if (this.seq[j - 1] < this.seq[i - 1] && (this.lengths[j] + 1) > this.lengths[i])
					this.lengths[i] = this.lengths[j] + 1;
			}
			
			if (this.lengths[i] == 0)
				this.lengths[i] = 1;
		}
		
		return this.lengths[this.seq.length];
	}
	
}
