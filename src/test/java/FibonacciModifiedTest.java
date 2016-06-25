import java.math.BigInteger;

import static org.junit.Assert.*;
import org.junit.Test;

import problems.FibonacciModified;


public class FibonacciModifiedTest {

	@Test
	public void testSmallFib() {
		FibonacciModified fm = new FibonacciModified(0, 1, 5);
		assertEquals(BigInteger.valueOf(5), fm.compute());
	}

	@Test
	public void testBigFib() {
		FibonacciModified fm = new FibonacciModified(0, 1, 10);
		assertEquals(new BigInteger("84266613096281243382112"), fm.compute());
	}

}
