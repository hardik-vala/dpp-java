package problems;


/**
 * Computes the nth number in the Fibonacci sequence using DP.
 * 
 * @author Hardik Vala
 */
public class Fibonacci {

	/** n for nth Fibonacci number. */
	private int n;

	/** The ith Fibonacci number is stored at index i - 1. */
	private int[] fibs;

	/**
	 * Constructor.
	 *
	 * @param n - n for nth Fibonacci number.
	 */
	public Fibonacci(int n) {
		if (n < 1) throw new IllegalArgumentException("n must be greater than 0");

		this.n = n;

		this.fibs = new int[this.n];
	}

	/**
	 * Computes the nth number in the Fibonacci sequence using DP.
	 *
	 * @return nth Fibonacci number.
	 */
	public int compute() {
		if (this.n == 1) return 0;
		if (this.n == 2) return 1;

		this.fibs[0] = 0;
		this.fibs[1] = 1;

		for (int i = 2; i < this.n; i++)
			this.fibs[i] = this.fibs[i - 1] + this.fibs[i - 2];

		return this.fibs[this.n - 1];
	}
	
}
