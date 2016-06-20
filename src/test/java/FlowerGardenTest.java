import static org.junit.Assert.*;

import problems.FlowerGarden;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;


public class FlowerGardenTest {

	private static final ArrayList<int[]> heights = new ArrayList<int[]>();
	private static final ArrayList<int[]> blooms = new ArrayList<int[]>();
	private static final ArrayList<int[]> wilts = new ArrayList<int[]>();
	private static final ArrayList<int[]> orderings = new ArrayList<int[]>();
	
	@BeforeClass
	public static void setUp () {
		int[] h1 = {5,4,3,2,1};
		int[] b1 = {1,1,1,1,1};
		int[] w1 = {365,365,365,365,365};
		int[] o1 = {1,2,3,4,5};
		
		heights.add(h1);
		blooms.add(b1);
		wilts.add(w1);
		orderings.add(o1);
		
		int[] h2 = {5,4,3,2,1};
		int[] b2 = {1,5,10,15,20};
		int[] w2 = {4,9,14,19,24};
		int[] o2 = {5,4,3,2,1};
		
		heights.add(h2);
		blooms.add(b2);
		wilts.add(w2);
		orderings.add(o2);
		
		int[] h3 = {5,4,3,2,1};
		int[] b3 = {1,5,10,15,20};
		int[] w3 = {5,10,15,20,25};
		int[] o3 = {1,2,3,4,5};
		
		heights.add(h3);
		blooms.add(b3);
		wilts.add(w3);
		orderings.add(o3);
		
		int[] h4 = {5,4,3,2,1};
		int[] b4 = {1,5,10,15,20};
		int[] w4 = {5,10,14,20,25};
		int[] o4 = {3,4,5,1,2};
		
		heights.add(h4);
		blooms.add(b4);
		wilts.add(w4);
		orderings.add(o4);
		
		int[] h5 = {1,2,3,4,5,6};
		int[] b5 = {1,3,1,3,1,3};
		int[] w5 = {2,4,2,4,2,4};
		int[] o5 = {2,4,6,1,3,5};
		
		heights.add(h5);
		blooms.add(b5);
		wilts.add(w5);
		orderings.add(o5);
		
		int[] h6 = {3,2,5,4};
		int[] b6 = {1,2,11,10};
		int[] w6 = {4,3,12,13};
		int[] o6 = {4,5,2,3};
		
		heights.add(h6);
		blooms.add(b6);
		wilts.add(w6);
		orderings.add(o6);
	}

	@Test
	public void testGetOrderings () {
		System.out.println("<<< TEST FLOWER GARDENS >>>\n");
		
		int numFlowers = heights.size();
		
		for (int i = 0; i < numFlowers; i++) {
			System.out.println("Garden #" + (i + 1));
			int[] h = heights.get(i);
			System.out.println("\tHeights: " + Arrays.toString(h));
			int[] b = blooms.get(i);
			System.out.println("\tBlooms: " + Arrays.toString(b));
			int[] w = wilts.get(i);
			System.out.println("\tWilts: " + Arrays.toString(w));
			int[] o = FlowerGarden.getOrdering(h, b, w);
			System.out.print("\tOrdering: " + Arrays.toString(o));
			
			assertTrue(Arrays.equals(o, orderings.get(i)));
			
			if (i < (numFlowers - 1)) System.out.println('\n');
		}
	}

}
