package problems;

import java.lang.Math;


/**
 * The description and specifications of the <i>Maximum Subarray Sum/i> problem are outlined
 * <a href="http://codercareer.blogspot.ca/2011/09/no-03-maximum-sum-of-all-sub-arrays.html">here</a>.
 * 
 * @author Hardik Vala
 */
public class MaximumSubarraySum {
	
	/** Input array. */
	private int[] array;

	/** Index i stores the maximum sum of any subarray ending at the array number at index i
      * (inclusive). */
	private int[] maxSubarraySums;

	/**
	 * Constructor.
	 *
	 * @param array - Input array of numbers.
     * @precondition array.length > 0
	 */
	public MaximumSubarraySum(int[] array) {
        assert array.length > 0;

		this.array = array;

		this.maxSubarraySums = new int[array.length];
	}

	/**
	 * Finds the max. sum of any subarray, tracking the max. sum of subarrays ending at each number
     * in the input array, and hence using O(N) space (where N is the length of the input array).
	 *
	 * @return Max. subarray sum.
	 */
	public int find() {
        // The only subarray ending at the first number consists only of the number itself.
        this.maxSubarraySums[0] = this.array[0];
        // Tracks the max. subarray sum found so far.
        int maxSubarraySum = this.maxSubarraySums[0];

		for (int i = 1; i < this.array.length; i++) {
            // At the current number, there are two possibilities: Either extend the max. subarray
            // of the previous number to the current number or start a new subarray at the current
            // number. Of course, whichever yields the larger subarray sum is tracked.
			if (this.maxSubarraySums[i - 1] + this.array[i] > this.array[i])
                this.maxSubarraySums[i] = this.maxSubarraySums[i - 1] + this.array[i];
            else
                this.maxSubarraySums[i] = this.array[i];

            // Update the max. subarray sum found so far.
            maxSubarraySum = Math.max(maxSubarraySum, this.maxSubarraySums[i]);
        }
        
        return maxSubarraySum;
	}

    /**
     * Finds the max. sum of any subarray, only tracking the max. sum of subarrays ending at the
     * current number in the input array, and hence using only O(1) space.
     *
     * @return Max. subarray sum.
     */
    public int findWithConstantSpace() {
        // Tracks the max. subarray sum ending at the current number.
        int currSubarraySum = this.array[0];
        // Tracks the max. subarray sum found so far.
        int maxSubarraySum = this.array[0];

        for (int i = 1; i < this.array.length; i++) {
            // At the current number, there are two possibilities: Either extend the max. subarray
            // of the previous number to the current number or start a new subarray at the current
            // number. Of course, whichever yields the larger subarray sum is tracked.
            if (currSubarraySum + this.array[i] > this.array[i])
                currSubarraySum += this.array[i];
            else
                currSubarraySum = this.array[i];

            // Update the max. subarray sum found so far.
            maxSubarraySum = Math.max(maxSubarraySum, currSubarraySum);
        }
        
        return maxSubarraySum;
    }

}
