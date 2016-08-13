package problems;

import java.util.HashMap;
import java.util.Map;


/**
 * Determines the # subarrays (not necessarily contiguous) of an array of integers that sum to S.
 *
 * @author Hardik
 */
public class SubarraySum {
	
	/** Input integer array. */
	private int[] array;
	/** Sum S. */
	private int S;

	/** Stores key-value pairs where the value represents the # of subarrays that sum to the key. */
	private HashMap<Integer, Integer> numSubarrays;

	/**
	 * Constructor.
	 *
	 * @param seq - Input sequence.
	 */
	public SubarraySum(int[] array, int S) {
		this.array = array;
		this.S = S;

		this.numSubarrays = new HashMap<Integer, Integer>();
	}

	// Determine the max. sum of any subarray (not necessarily contiguous) of the given array.
	private static int detMaxSubarraySum(int[] array) {
		assert array.length > 0;

		int maxSum = 0;
		boolean foundNonNeg = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0) {
				foundNonNeg = true;
				maxSum += array[i];
			}
		}

		if (foundNonNeg) return maxSum;

		int min = array[0];
		for (int i = 1; i < array.length; i++) 
			if (array[i] < min) min = array[i];

		return min;
	}

	// Determine the min. sum of any subarray (not necessarily contiguous) of the given array.
	private static int detMinSubarraySum(int[] array) {
		assert array.length > 0;

		int minSum = 0;
		boolean foundNonPos = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 0) {
				foundNonPos = true;
				minSum += array[i];
			}
		}

		if (foundNonPos) return minSum;

		int max = array[0];
		for (int i = 1; i < array.length; i++) 
			if (array[i] > max) max = array[i];

		return max;
	}

	/**
	 * Counts the # of subarrays with sum S.
	 *
	 * @return # of such subarrays.
	 */
	public int count() {
		int maxSum = detMaxSubarraySum(this.array);
		int minSum = detMinSubarraySum(this.array);

		for (int sum = minSum; sum <= maxSum; sum++)
			this.numSubarrays.put(sum, 0);

		for (int i = 0; i < this.array.length; i++) {
			int n = this.array[i];

			int lastSum = minSum + ((n >= 0) ? n : 0);
			if (n >= 0) {
				for (int sum = maxSum; sum >= minSum + n; sum--) {
					int numSubarraysforSum = this.numSubarrays.get(sum);
					this.numSubarrays.put(sum, numSubarraysforSum + this.numSubarrays.get(sum - n));
				}
			} else {
				for (int sum = minSum; sum <= maxSum + n; sum++) {
					int numSubarraysforSum = this.numSubarrays.get(sum);
					this.numSubarrays.put(sum, numSubarraysforSum + this.numSubarrays.get(sum - n));
				}
			}

			this.numSubarrays.put(n, this.numSubarrays.get(n) + 1);
		}

		return this.numSubarrays.get(this.S);
	}

}
