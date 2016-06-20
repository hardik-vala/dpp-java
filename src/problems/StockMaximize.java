package problems;


/**
 * Determines all subsequences of a list that are palindrome. For example, the
 * string "abca" (a list of letters), has 7 palindrome subsequences, which are,
 * 
 * @author Hardik
 */
public class StockMaximize {
	
	/** WOT stock prices on each day. */
	private int[] prices;
	/** Represents the max. profit attainable up to each day. */
	private long[] maxProfits;

	/**
	 * Constructor.
	 *
	 * @param prices - WOT stock prices on each day.
	 */
	public StockMaximize(int[] prices) {
		this.prices = prices;
		this.maxProfits = new long[prices.length];
	}

	/**
	 * Calculates the max. profit attainable by the last day.
	 *
	 * @return Max. profit.
	 */
	public long calculate() {
		for (int i = 1; i < this.prices.length; i++) {
			// Max. profit for day i.
            long maxProfit = 0;
            
            // Cost of buying stocks, initialized to the cost of buying stocks
            // until day i.
            int cost = 0;
            for (int j = 0; j < i; j++)
                cost += this.prices[j];
            
            // Caculate the max. profit.
            for (int j = 0; j < i; j++) {
            	// Profit is calculated by buying stocks from day j until day i and taking the max.
            	// profit at day j - 1.
                long profit = this.prices[i] * (i - j) + ((j > 0) ? this.maxProfits[j - 1] : 0);
                profit -= cost;
                if (maxProfit < profit)
                    maxProfit = profit;
                
                // Decrease the cost by the stock price on day j when the range of days for buying
                // is shrunk to day j + 1 until i.
                cost -= this.prices[j];
            }
            
            this.maxProfits[i] = maxProfit;
        }
        
        return this.maxProfits[this.prices.length - 1];
	}
}
