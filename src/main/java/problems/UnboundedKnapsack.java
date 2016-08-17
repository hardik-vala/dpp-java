package problems;


/**
 * The description and specifications of the <i>Unbounded Knapsack</i> problem are outlined
 * <a href="https://xlinux.nist.gov/dads/HTML/unboundedKnapsack.html">here</a>.
 * 
 * @author Hardik Vala
 */
public class UnboundedKnapsack {
	
	/** Index i stores the value of item i. */
	private int[] values;
    /** Index i stores the weight of item i. */
    private int[] weights;
    /** Capacity. */
    private int capacity;

	/** Index i stores the max. value of items with total weight <= i. */
	private int[] maxTotValues;

	/**
	 * Constructor.
	 *
     * @param values - Item values.
     * @param weights - Item weights.
	 * @param capacity - Capacity.
     * @precondition values[i], weights[i], capacity >= 0, for all i.
     * @throws IllegalArgumentException if an item has zero weight but non-zero value.
	 */
	public UnboundedKnapsack(int[] values, int[] weights, int capacity) {
        this.values = values;
        this.weights = weights;
		this.capacity = capacity;

        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] > 0 && this.weights[i] == 0)
                throw new IllegalArgumentException("Encountered item with zero weight and non-zero "
                    + "value.");
        }

		this.maxTotValues = new int[capacity + 1];
	}

	/**
	 * Calculates the total max. value attainable with the given capacity and types of items.
	 *
	 * @return Max. value.
	 */
	public int calc() {
		for (int subCapacity = 0; subCapacity <= this.capacity; subCapacity++) {
			int maxTotValue = 0;
            for (int item = 0; item < this.values.length; item++) {
                int remainingWeight = subCapacity - this.weights[item];
                if (remainingWeight >= 0) {
                    int remainingWeightMaxValue = this.maxTotValues[remainingWeight]
                        + this.values[item];
                    if (maxTotValue < remainingWeightMaxValue)
                        maxTotValue = remainingWeightMaxValue;
                }
            }

            this.maxTotValues[subCapacity] = maxTotValue;
        }
        
        return this.maxTotValues[this.capacity];
	}

}
