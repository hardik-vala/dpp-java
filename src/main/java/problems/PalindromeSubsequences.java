package problems;

import java.util.List;


/**
 * Determines all subsequences of a list that are palindrome. For example, the
 * string "abca" (a list of letters), has 7 palindrome subsequences, which are,
 *
 * "a"
 * "b"
 * "c"
 * "a"
 * "aa"
 * "aba"
 * "aca"
 * 
 * @param <T> Type of sequence elements (equals method must be defined)
 * @author Hardik
 */
public class PalindromeSubsequences<T> {
	
	/** Input sequence. */
	private List<T> seq;
	/** Matrix of counts, where each element (i, j), 0-indexed with i <= j, corresponds to the
	  * number of palindrome subsequences between elements at positions i and j (inclusive) in the
	  * input sequence. (Matrix is upper-triangluar.) */
	private int[][] countMatrix;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence
	 */
	public PalindromeSubsequences(List<T> seq) {
		this.seq = seq;
	}

	/**
	 * Counts all subsequences of the input sequence that are palindrome.
	 *
	 * @return Number of subsequences that are palindrome
	 */
	public int count() {
		// Number of elements in input sequence.
		int size = this.seq.size();

		this.countMatrix = new int[size][size];

		// Initialize dialognal entries to 1 (a single element constitutes a single palindrome).
		for (int i = 0; i < size; i++)
			this.countMatrix[i][i] = 1;

		// Iterate over possible sizes (-1) of subsequences.
		for (int k = 1; k < size; k++) {
			// Iterate over all subsequences of the given size.
			for (int i = 0; i + k < size; i++) {
				// Marks the end point (inclusive) of the given subsequence.
				int j = i + k;

				// If the start and end points of the subsequence are equal, then the number of
				// palindrome subsequences starting and ending with elements at positions i and j,
				// respectively and inclusively, is equal to the number starting and ending at i + 1
				// and j, plus the number starting and ending at i and j - 1, plus 1, for the
				// subsequence constituted solely by start and end points i and j.
				if (seq.get(i).equals(seq.get(j)))
					this.countMatrix[i][j] = countMatrix[i + 1][j] + countMatrix[i][j - 1] + 1;
				// Otherwise, the number of palindrome subsequences starting and ending with
				// elements at positions i and j, respectively and inclusively, is equal to the
				// number starting and ending at i + 1 and j, plus the number starting and ending at
				// i and j - 1, minus the number starting and ending at i - 1 and j - 1 (since
				// they've been double counted).
				else
					this.countMatrix[i][j] = countMatrix[i + 1][j] + countMatrix[i][j - 1] -
						countMatrix[i + 1][j - 1];
			}

		}

		// The desired count is at element (0, size - 1) of the matrix.
		return this.countMatrix[0][size - 1];
	}

	// Method for printing out the count matrix (for debugging).
	private void printCountMatrix() {
		for (int i = 0; i < this.countMatrix.length; i++) {
			System.out.print("[ ");

			for (int j = 0; j < this.countMatrix[i].length; j++)
				System.out.print(this.countMatrix[i][j] + " ");

			System.out.println("]");
		}
	}

}
