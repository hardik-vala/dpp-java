import static org.junit.Assert.*;

import problems.BadNeighbours;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;


public class BadNeighboursTest {
	
	private static final LinkedHashMap<int[], Long> neighbourDonationSequences = new LinkedHashMap<int[], Long>();
	
	@BeforeClass
	public static void setUpMap() {
		int[] nds1 = {10,3,2,5,7,8};
		neighbourDonationSequences.put(nds1, (long)19);
		int[] nds2 = {11,15};
		neighbourDonationSequences.put(nds2, (long)15);
		int[] nds3 = {7,7,7,7,7,7,7};
		neighbourDonationSequences.put(nds3, (long)21);
		int[] nds4 = {1,2,3,4,5,1,2,3,4,5};
		neighbourDonationSequences.put(nds4, (long)16);
		int[] nds5 = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
		neighbourDonationSequences.put(nds5, (long)2926);
	}
	
	private static long sumList(LinkedList<Integer> l) {
		long sum = 0;
		for (Integer i : l) sum += i;
		return sum;
	}
	
	@Test
	public void testgetMaximumDonations_DP() {
		System.out.println("<<< BAD NEIGHBOURS TEST >>>\n");
		
		int numSequences = neighbourDonationSequences.size();
		
		int i = 1;
		for (Map.Entry<int[], Long> nds: neighbourDonationSequences.entrySet()) {
			int[] s = nds.getKey();
			System.out.println("Neighbour Dontation Sequence #" + i + ": " + Arrays.toString(s));
			
			LinkedList<Integer> mds = BadNeighbours.getMaximumDonations_DP(s);
			System.out.println("Maximum Donation Sequence: " + mds);
			long md = sumList(mds);
			System.out.print("Maximum Donation: " + md);
			
			assertTrue(md == nds.getValue());
			
			if (i < (numSequences - 1)) System.out.println('\n');
		}
	}

}
