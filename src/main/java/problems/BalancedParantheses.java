package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Counts the number of sequences of balanced parentheses of a given size. For example, with 3 pairs
 * of parentheses, 4 distinct sequences can be formed for which the parentheses are balanced. These
 * are,
 *
 * ((()))
 * ()(())
 * ()()()
 * (())()
 * 
 * @author Hardik
 */
public class BalancedParantheses {
	
	/** # of pairs of parentheses. */
	private int N;

	/** Index i stores the # of sequences of balanced parentheses that can be formed with i pairs of
	  * parentheses. */
	private long[] counts;
	
	/**
	 * Constructor.
	 *
	 * @param N - # of pairs of parentheses.
	 */
	public BalancedParantheses(int N) {
		this.N = N;

		this.counts = new long[N + 1];
	}
	
	/**
	 * Counts all sequences formed from balanced parentheses.
	 *
	 * @return # of sucb sequences.
	 */
	public long count() {
		if (this.N <= 1) return 1;
		
		this.counts[0] = 1;
		
		for (int i = 1; i <= this.N; i++) {
			this.counts[i] = 1;
			for (int j = 1; j < i; j++)
				this.counts[i] += this.counts[j];
		}
		
		return this.counts[this.N];
	}
	
	/**
	 * Returns a list of all sequences formed from balanced parentheses.
	 *
	 * @return List of such sequences.
	 */
	public List<String> get() {
		ArrayList<LinkedList<String>> seqsList = new ArrayList<LinkedList<String>>(this.N + 1);
		
		for (int i = 0; i <= this.N; i++) {
			LinkedList<String> seqs = new LinkedList<String>();

			String firstSeq = "";
			for (int j = 0; j < i; j++)
				firstSeq = "(" + firstSeq + ")";

			seqs.add(firstSeq);
			seqsList.add(seqs);
		}
		
		for (int i = 1; i <= this.N; i++) {
			LinkedList<String> seqs = seqsList.get(i);
			for (int j = 1; j < i; j++) {
				String prefix = seqsList.get(i - j).get(0);

				for (String seq : seqsList.get(j))
					seqs.add(prefix + seq);
			}
		}
		
		return seqsList.get(this.N);
	}
	
}
