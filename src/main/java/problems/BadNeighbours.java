package problems;

import java.util.LinkedList;


/**
 * The description and specifications of the <i>Bad Neighbours</i> problem are outlined
 * <a href="http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009">here</a>.
 * 
 * @author Hardik Vala
 */
public class BadNeighbours {
	
	/* Returns a linked list in order of those donations in a longest se*/
	public static LinkedList<Integer> getMaximumDonations_DP (int[] d) {
		LinkedList<Integer> maxDonationList = new LinkedList<Integer>();
		if (d.length == 1) maxDonationList.add(d[0]);
		else {
			if (d.length == 2) maxDonationList.add((d[0] < d[1]) ? d[1] : d[0]);
			else {
				// 'WFN' stands for 'With First Neighbour'.
				long[] maxDonationsWFN = new long[d.length - 1];
				maxDonationsWFN[0] = d[0];
				maxDonationsWFN[1] = d[1];
				
				int[] lastDonationWFN = new int[d.length - 1];
				lastDonationWFN[1] = 1;
				
				long maxDonationWFN = d[0];
				int maxDonationWFNIndex = 0;
				if (d[1] > d[0]) {
					maxDonationWFN = d[1];
					maxDonationWFNIndex = 1;
				}
				
				// 'WLN' stands for 'With Last Neighbour'.
				long[] maxDonationsWLN = new long[d.length - 1];
				maxDonationsWLN[d.length - 2] = d[d.length - 1];
				maxDonationsWLN[d.length - 3] = d[d.length - 2];
				
				int[] lastDonationWLN = new int[d.length - 1];
				lastDonationWLN[d.length - 2] = d.length - 2;
				lastDonationWLN[d.length - 3] = d.length - 3;
				
				long maxDonationWLN = d[d.length - 1];
				int maxDonationWLNIndex = d.length - 2;
				if (d[d.length - 2] < d[d.length - 1]) {
					maxDonationWLN = d[d.length - 2];
					maxDonationWLNIndex = d.length - 3;
				}
				
				int i,j;
				for (i = 2; i < (d.length - 1); i++) {
					for (j = i - 2; j >= 0; j--) {
						if ((maxDonationsWFN[j] + d[i]) > maxDonationsWFN[i]) {
							maxDonationsWFN[i] = maxDonationsWFN[j] + d[i];
							lastDonationWFN[i] = j;
						}
						
						if ((maxDonationsWLN[d.length - (j + 2)] + d[d.length - (i + 2) + 1]) > maxDonationsWLN[d.length - (i + 2)]) {
							maxDonationsWLN[d.length - (i + 2)] = maxDonationsWLN[d.length - (j + 2)] + d[d.length - (i + 2) + 1];
							lastDonationWLN[d.length - (i + 2)] = d.length - (j + 2);
						}
					}
					
					if (maxDonationsWFN[i] > maxDonationWFN) {
						maxDonationWFN = maxDonationsWFN[i];
						maxDonationWFNIndex = i;
					}
					
					if (maxDonationsWLN[d.length - (i + 2)] > maxDonationWLN) {
						maxDonationWLN = maxDonationsWLN[d.length - (i + 2)];
						maxDonationWLNIndex = d.length - (i + 2);
					}
				}
				
				if (maxDonationWFN < maxDonationWLN) {
					for (i = maxDonationWLNIndex; lastDonationWLN[i] != i; i = lastDonationWLN[i]) {
						maxDonationList.add(d[i + 1]);
					}
					maxDonationList.add(d[i + 1]);
				} else {
					for (i = maxDonationWFNIndex; lastDonationWFN[i] != i; i = lastDonationWFN[i]) {
						maxDonationList.addFirst(d[i]);
					}
					maxDonationList.addFirst(d[i]);
				}
			}
		}
		
		return maxDonationList;
	}
}
