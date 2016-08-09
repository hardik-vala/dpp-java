package problems;

import java.util.Arrays;


/**
 * The description and specifications of the <i>Flower Garden</i> problem are outlined
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=1166&rd=4705">here</a>.
 * 
 * @author Hardik Vala
 */
public class Jewelry {

	/** Value of each piece of jewelry. */
	int[] jewelry;

	/**
	 * Constructor.
	 *
	 * @param jewelry - Value of each piece of jewelry.
	 */
	public Jewelry(int[] jewelry) {
		if (jewelry.length <= 1)
			throw new IllegalArgumentException("Must have at least 2 pieces of jewelry.");

		this.jewelry = jewelry;
	}

	/**
	 * Counts the # of different ways you can allocate the jewelry to Bob and Frank following the
	 * policy.
	 *
	 * @return # of different allocations.
	 */
	public long count() {
		int[] sortedJewelry = Arrays.copyOf(this.jewelry, this.jewelry.length);
		Arrays.sort(sortedJewelry);
		int numJewelry = sortedJewelry.length;
		int sum = Arrays.stream(sortedJewelry).sum();

		// Index i stores the number of duplicate prices ahead of the jewelry piece at index i in
		// the sorted order of prices.
		int[] numDupsAhead = new int[numJewelry];
		for (int i = numJewelry - 2; i >= 0; i--) {
			if (sortedJewelry[i] == sortedJewelry[i + 1])
				numDupsAhead[i] = numDupsAhead[i + 1] + 1;
		}

		long[] accNumBobsWays = new long[sum + 1];
		accNumBobsWays[0] = 1;

		long numWays = 0L;
		int sameJewelryCount = 1;
		for (int i = 0; i < numJewelry - 1; i++) {
			long[] newNumBobsWays = new long[sum + 1];
			for (int k = sum; k >= sortedJewelry[i]; k--)
				newNumBobsWays[k] += accNumBobsWays[k - sortedJewelry[i]];

			long[] numFranksWays = new long[sum + 1];
			numFranksWays[0] = 1;
			for (int j = i + 1; j < numJewelry; j++) {
				for (int k = sum; k >= sortedJewelry[j]; k--)
					numFranksWays[k] += numFranksWays[k - sortedJewelry[j]];
			}

			for (int k = 1; k <= sum; k++) {
				numWays += newNumBobsWays[k] * numFranksWays[k];
				accNumBobsWays[k] += newNumBobsWays[k];
			}

			if (sortedJewelry[i] == sortedJewelry[i + 1])
				numWays += numDupsAhead[i];
		}

		return numWays;
	}

}
