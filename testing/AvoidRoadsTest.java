import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;


public class AvoidRoadsTest {

	private static final int[] widths = {6, 1, 35, 2};
	private static final int[] lengths = {6, 1, 31, 2};
	private static final ArrayList<String[]> bads = new ArrayList<String[]>();
	
	private static final long[] numWays = {252, 2, Long.parseLong("6406484391866534976"), 0};
	
	@BeforeClass
	public static void setUpBeforeClass() {
		String[] b1 = {"0 0 0 1", "6 6 5 6"};
		bads.add(b1);
		
		String[] b2 = {};
		bads.add(b2);
		
		String[] b3 = {};
		bads.add(b3);
		
		String[] b4 = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
		bads.add(b4);
	}

	@Test
	public void testNumWays () {
		for (int i = 0; i < widths.length; i++) {
			assertTrue(AvoidRoads.numWays(widths[i], lengths[i], bads.get(i)) == numWays[i]);
		}
	}

}
