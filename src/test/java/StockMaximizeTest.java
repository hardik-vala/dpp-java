import static org.junit.Assert.*;
import org.junit.Test;

import problems.StockMaximize;


public class StockMaximizeTest {

	private int[] monotonicallyDecreasingPrices = {5, 3, 2};
	private int[] monotonicallyIncreasingPrices = {1, 2, 100};
	private int[] oscillatingPrices = {1, 3, 1, 2};

	@Test
	public void testMonotonicallyDecreasingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyDecreasingPrices);
		assertEquals(0, sm.calculateDP());
	}

	@Test
	public void testMonotonicallyDecreasingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyDecreasingPrices);
		assertEquals(0, sm.calculateNonDP());
	}

	@Test
	public void testMonotonicallyIncreasingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyIncreasingPrices);
		assertEquals(197, sm.calculateDP());
	}

	@Test
	public void testMonotonicallyIncreasingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyIncreasingPrices);
		assertEquals(197, sm.calculateNonDP());
	}

	@Test
	public void testOscillatingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.oscillatingPrices);
		assertEquals(3, sm.calculateDP());
	}

	@Test
	public void testOscillatingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.oscillatingPrices);
		assertEquals(3, sm.calculateNonDP());
	}

}
