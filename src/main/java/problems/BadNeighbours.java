package problems;

import java.util.LinkedList;


/**
 * The description and specifications of the <i>Bad Neighbours</i> problem are outlined
 * <a href="http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009">here</a>.
 * 
 * @author Hardik Vala
 */
public class BadNeighbours {
	
	/** Array of donations in order, where the donation at index i corresponds to the donation of
	 * the (i + 1)th neighbour. */
	int[] donations;

	/** Sequence of donations yielding the maximum collectible amount. */
	LinkedList<Integer> maxDonations;

	/**
	 * Constructor.
	 *
	 * @param donations - Array of donations in order.
	 */
	public BadNeighbours(int[] donations) {
		this.donations = donations;

		this.maxDonations = new LinkedList<Integer>();
	}

	/**
	 * Calculates the maximum amount of donations that can be collected.
	 *
	 * @return Max. amount of donations.
	 */
	public int calculate() {
		int numDonations = this.donations.length;

		if (numDonations == 1) this.maxDonations.add(this.donations[0]);
		else {
			if (numDonations == 2)
				this.maxDonations.add((this.donations[0] < this.donations[1]) ? this.donations[1] :
					this.donations[0]);
			else {
				long[] maxDonationsWithFirstNeighbour = new long[numDonations - 1];
				maxDonationsWithFirstNeighbour[0] = this.donations[0];
				maxDonationsWithFirstNeighbour[1] = this.donations[1];
				
				int[] lastDonationWithFirstNeighbour = new int[numDonations - 1];
				lastDonationWithFirstNeighbour[1] = 1;
				
				long maxDonationWithFirstNeighbour = this.donations[0];
				int maxDonationWithFirstNeighbourIndex = 0;
				if (this.donations[1] > this.donations[0]) {
					maxDonationWithFirstNeighbour = this.donations[1];
					maxDonationWithFirstNeighbourIndex = 1;
				}
				
				long[] maxDonationsWithLastNeighbour = new long[numDonations - 1];
				maxDonationsWithLastNeighbour[numDonations - 2] = this.donations[numDonations - 1];
				maxDonationsWithLastNeighbour[numDonations - 3] = this.donations[numDonations - 2];
				
				int[] lastDonationWithLastNeighbour = new int[numDonations - 1];
				lastDonationWithLastNeighbour[numDonations - 2] = numDonations - 2;
				lastDonationWithLastNeighbour[numDonations - 3] = numDonations - 3;
				
				long maxDonationWithLastNeighbour = this.donations[numDonations - 1];
				int maxDonationWithLastNeighbourIndex = numDonations - 2;
				if (this.donations[numDonations - 2] < this.donations[numDonations - 1]) {
					maxDonationWithLastNeighbour = this.donations[numDonations - 2];
					maxDonationWithLastNeighbourIndex = numDonations - 3;
				}
				
				int i,j;
				for (i = 2; i < (numDonations - 1); i++) {
					for (j = i - 2; j >= 0; j--) {
						if ((maxDonationsWithFirstNeighbour[j] + this.donations[i]) >
							maxDonationsWithFirstNeighbour[i]) {
							maxDonationsWithFirstNeighbour[i] = maxDonationsWithFirstNeighbour[j] +
								this.donations[i];
							lastDonationWithFirstNeighbour[i] = j;
						}
						
						if ((maxDonationsWithLastNeighbour[numDonations - (j + 2)] +
							this.donations[numDonations - (i + 2) + 1]) >
							maxDonationsWithLastNeighbour[numDonations - (i + 2)]) {
							maxDonationsWithLastNeighbour[numDonations - (i + 2)] =
								maxDonationsWithLastNeighbour[numDonations - (j + 2)] +
								this.donations[numDonations - (i + 2) + 1];
							lastDonationWithLastNeighbour[numDonations - (i + 2)] = numDonations -
								(j + 2);
						}
					}
					
					if (maxDonationsWithFirstNeighbour[i] > maxDonationWithFirstNeighbour) {
						maxDonationWithFirstNeighbour = maxDonationsWithFirstNeighbour[i];
						maxDonationWithFirstNeighbourIndex = i;
					}
					
					if (maxDonationsWithLastNeighbour[numDonations - (i + 2)] >
						maxDonationWithLastNeighbour) {
						maxDonationWithLastNeighbour = maxDonationsWithLastNeighbour[numDonations -
							(i + 2)];
						maxDonationWithLastNeighbourIndex = numDonations - (i + 2);
					}
				}
				
				if (maxDonationWithFirstNeighbour < maxDonationWithLastNeighbour) {
					for (i = maxDonationWithLastNeighbourIndex; lastDonationWithLastNeighbour[i] !=
						i; i = lastDonationWithLastNeighbour[i]) {
						this.maxDonations.add(this.donations[i + 1]);
					}
					this.maxDonations.add(this.donations[i + 1]);
				} else {
					for (i = maxDonationWithFirstNeighbourIndex;
						lastDonationWithFirstNeighbour[i] != i;
						i = lastDonationWithFirstNeighbour[i]) {
						this.maxDonations.addFirst(this.donations[i]);
					}
					this.maxDonations.addFirst(this.donations[i]);
				}
			}
		}
		
		int sum = 0;
		for (int d: this.maxDonations) sum += d;

		return sum;
	}
}
