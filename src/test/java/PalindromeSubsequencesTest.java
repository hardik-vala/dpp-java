import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import problems.PalindromeSubsequences;


public class PalindromeSubsequencesTest {
	
	@Test
	public void testSmallSeq() {
		List<String> seq = Arrays.asList(new String[] {"a", "b", "c", "a"});
		PalindromeSubsequences<String> ps = new PalindromeSubsequences<>(seq);
		assertEquals(7, ps.count());
	}

	@Test
	public void testSmallPalindromeSeq() {
		List<String> seq = Arrays.asList(new String[] {"a", "b", "a", "b", "a"});
		PalindromeSubsequences<String> ps = new PalindromeSubsequences<>(seq);
		assertEquals(17, ps.count());
	}

}
