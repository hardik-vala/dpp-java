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

	/** Index i stores the # of ways of allocating Bob or Frank's jewelry, respectively, to sum to
	 * i. */
	// long[] numBobsWays;
	// long[] numFranksWays;


	/**
	 * Constructor.
	 *
	 * @param jewelry - Value of each piece of jewelry.
	 */
	public Jewelry(int[] jewelry) {
		if (jewelry.length <= 1)
			throw new IllegalArgumentException("Must have at least 2 pieces of jewelry.");

		this.jewelry = jewelry;

		// int sum = 0;
		// for (int i = 0; i < jewelry.length; i++) sum += jewelry[i];

		// this.numBobsWays = new long[sum + 1];
		// this.numFranksWays = new long[sum + 1];
	}

	public long count() {
		int[] sortedJewelry = Arrays.copyOf(this.jewelry, this.jewelry.length);
		Arrays.sort(sortedJewelry);
		int numJewelry = sortedJewelry.length;
		int sum = Arrays.stream(sortedJewelry).sum();

		long[] accNumBobsWays = new long[sum + 1];
		accNumBobsWays[0] = 1;

		long numWays = 0L;
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

			// System.out.println(i);
			// System.out.println(Arrays.toString(accNumBobsWays));
			// System.out.println(Arrays.toString(newNumBobsWays));
			// System.out.println(Arrays.toString(numFranksWays));

			for (int k = 1; k <= sum; k++) {
				numWays += newNumBobsWays[k] * numFranksWays[k];
				accNumBobsWays[k] += newNumBobsWays[k];
			}

			// System.out.println(numWays);
		}

		return numWays;
	}

}
