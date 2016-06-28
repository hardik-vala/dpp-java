import static org.junit.Assert.*;
import org.junit.Test;

import problems.FlowerGarden;


public class FlowerGardenTest {
	
	// These flowers all bloom on January 1st and wilt on December 31st. Since they all may block
	// each other, they must be ordered from shortest to tallest.
	@Test
	public void testSameBloomAndWilts() {
		int[] height = new int[] {5, 4, 3, 2, 1};
		int[] bloom = new int[] {1, 1, 1, 1, 1};
		int[] wilt = new int[] {365, 365, 365, 365, 365};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, fg.det());
	}

	// The same set of flowers now bloom all at separate times. Since they will never block each
	// other, they can be ordered from tallest to shortest to get the tallest ones as far forward as
	// possible.
	@Test
	public void testNoBlocking() {
		int[] height = new int[] {5, 4, 3, 2, 1};
		int[] bloom = new int[] {1, 5, 10, 15, 20};
		int[] wilt = new int[] {4, 9, 14, 19, 24};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {5, 4, 3, 2, 1}, fg.det());
	}

	// Although each flower only blocks at most one other, they all must be ordered from shortest to
	// tallest to prevent any blocking from occurring.
	@Test
	public void testEachFlowerBlocksOneOtherExceptLast() {
		int[] height = new int[] {5, 4, 3, 2, 1};
		int[] bloom = new int[] {1, 5, 10, 15, 20};
		int[] wilt = new int[] {5, 10, 15, 20, 25};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, fg.det());
	}

	// The difference here is that the third type of flower wilts one day earlier than the blooming
	// of the fourth flower. Therefore, the flowers of height 3 can be put first, then the flowers
	// of height 4, then height 5, and finally the flowers of height 1 and 2. Note that they could
	// have also been ordered with height 1 first, but this does not result in the maximum possible
	// height being first in the garden.
	@Test
	public void testEachFlowerBlocksAtMostOneOther() {
		int[] height = new int[] {5, 4, 3, 2, 1};
		int[] bloom = new int[] {1, 5, 10, 15, 20};
		int[] wilt = new int[] {5, 10, 14, 20, 25};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {3, 4, 5, 1, 2}, fg.det());
	}

	@Test
	public void testAlternatingBloomAndWilts() {
		int[] height = new int[] {1, 2, 3, 4, 5, 6};
		int[] bloom = new int[] {1, 3, 1, 3, 1, 3};
		int[] wilt = new int[] {2, 4, 2, 4, 2, 4};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {2, 4, 6, 1, 3, 5}, fg.det());
	}

	@Test
	public void testSubsumingBloomAndWiltPeriods() {
		int[] height = new int[] {3, 2, 5, 4};
		int[] bloom = new int[] {1, 2, 11, 10};
		int[] wilt = new int[] {4, 3, 12, 13};

		FlowerGarden fg = new FlowerGarden(height, bloom, wilt);
		assertArrayEquals(new int[] {4, 5, 2, 3}, fg.det());
	}

}
