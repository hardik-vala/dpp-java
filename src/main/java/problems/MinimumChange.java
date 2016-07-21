package problems;

import java.util.HashSet;

/**
 * The description and specifications of the <i>Minimum Change</i> problem are
 * outlined <a href="http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg">here</a>,
 * in the <i>Introduction</i>.
 * 
 * @author Hardik Vala
 */
public class MinimumChange {

	/** Desired sum. */
	private int sum;
	/** List of coin values. */
	private int[] coins;

	/** Index i stores the minimum # coins that sum to i. */
	private int[] minCounts;


	/**
	 * Constructor.
	 *
	 * @param sum - Desired sum.
	 * @param coins - List of coin values.
	 * @precondition sum >= 0.
	 * @precondition coins[i] >= 0 for all i.
	 */
	public MinimumChange(int sum, int[] coins) {
		this.sum = sum;
		this.coins = coins;

		this.minCounts = new int[sum + 1];
	}

	/**
	 * Calculates the minimum # coins summing to the desired sum. (Loops over each possible sum less
	 * than the desired one, and for each possible sum, loops over the coins one-by-one.)
	 *
	 * @return Minimum # coins summing to the desired sum.
	 */
	public int calculate1() {
		for (int i = 1; i <= this.sum; i++)
			this.minCounts[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= this.sum; i++) {
			for (int j = 0; j < this.coins.length; j++) {
				int coin = this.coins[j];
				if (coin <= i &&
					this.minCounts[i - coin] + 1 >= 0 &&
					this.minCounts[i - coin] + 1 < this.minCounts[i])
					this.minCounts[i] = this.minCounts[i - coin] + 1;
			}
		}

		return this.minCounts[this.sum];
	}

	/**
	 * Same as {@link #calculate1() calculate1}, but loops over the coins, and for each coin, loops
	 * over each possible sum less than the desired one.
	 *
	 * @return Minimum # coins summing to the desired sum.
	 */
	public int calculate2() {
		for (int i = 1; i <= this.sum; i++)
			this.minCounts[i] = Integer.MAX_VALUE;

		for (int i = 0; i < this.coins.length; i++) {
			int coin = this.coins[i];
			for (int j = coin; j <= this.sum; j++) {
				if (this.minCounts[j - coin] + 1 >= 0 &&
					this.minCounts[j - coin] + 1 < this.minCounts[j])
					this.minCounts[j] = this.minCounts[j - coin] + 1;
			}
		}

		return this.minCounts[this.sum];
	}

}
