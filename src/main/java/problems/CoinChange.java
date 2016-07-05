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
	private int[][] ways;

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

		this.ways = new int[this.N + 1][this.C.length];
	}

}
