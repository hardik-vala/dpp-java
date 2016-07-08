package problems;


/**
 * The description and specifications of the <i>Coin Change</i> problem are outlined
 * <a href="https://www.hackerrank.com/challenges/coin-change">here</a>.
 * 
 * @author Hardik Vala
 */
public class CoinChange {

	/** The amount to make change for. */
	private int N;
	/** Coin denominations. */
	private int[] C;

	/** The ith Fibonacci number is stored at index i - 1. */
	private int[][] numWays;

	/**
	 * Constructor.
	 *
	 * @param N - The amount to make change for.
	 * @param C - Coin demoniations.
	 */
	public CoinChange(int N, int[] C) {
		if (N < 1) throw new IllegalArgumentException("N must be greater than 0");

		this.N = N;
		this.C = C;

		this.numWays = new int[this.N + 1][this.C.length];
	}

	/**
	 * Calculates the number of ways you can make change for N out of the coins
	 * C.
	 *
	 * @return # of ways.
	 */
	public int calculate() {
		for (int i = 0; i < this.C.length; i++)
			this.numWays[0][i] = 1;

		for (int i = 1; i <= this.N; i++) {
			for (int j = 0; j < this.C.length; j++) {
				if (i - this.C[j] >= 0)
					this.numWays[i][j] = this.numWays[i - C[j]][j];

				if (j >= 1)
					this.numWays[i][j] += this.numWays[i][j - 1];
			}
		}

		return this.numWays[this.N][this.C.length - 1];
	}

}
