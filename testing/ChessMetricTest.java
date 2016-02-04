import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;


public class ChessMetricTest {

	private static final int[] sizes = {3, 3, 3, 3, 100};
	private static final ArrayList<int[]> starts = new ArrayList<int[]>();
	private static final ArrayList<int[]> ends = new ArrayList<int[]>();
	private static final int[] numMovess = {1, 1, 1, 2, 50};
	
	private static final long[] howManys = {1, 1, 0, 5, Long.parseLong("243097320072600")};
	
	@BeforeClass
	public static void setUpBeforeClass() {
		int[] s1 = {0, 0};
		starts.add(s1);
		int[] e1 = {1, 0};
		ends.add(e1);
		
		int[] s2 = {0, 0};
		starts.add(s2);
		int[] e2 = {1, 2};
		ends.add(e2);
		
		int[] s3 = {0, 0};
		starts.add(s3);
		int[] e3 = {2, 2};
		ends.add(e3);
		
		int[] s4 = {0, 0};
		starts.add(s4);
		int[] e4 = {0, 0};
		ends.add(e4);
		
		int[] s5 = {0, 0};
		starts.add(s5);
		int[] e5 = {0, 99};
		ends.add(e5);
	}

	@Test
	public void testHowMany() {
		for (int i = 0; i < sizes.length; i++) {
			assertTrue(ChessMetric.howMany(sizes[i], starts.get(i), ends.get(i), numMovess[i]) == howManys[i]);
		}
	}

}
