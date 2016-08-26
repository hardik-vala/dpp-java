import static org.junit.Assert.*;
import org.junit.Test;

import problems.LargestIndependentSet;
import problems.LargestIndependentSet.BinaryTreeNode;


public class LargestIndependentSetTest {
	
	@Test
	public void testLeaf() {
		BinaryTreeNode<Integer> leaf = new BinaryTreeNode<>(1, null, null);
		LargestIndependentSet<Integer> lis = new LargestIndependentSet<>(leaf);
		assertEquals(1, lis.calculate());
	}

	@Test
	public void testNonTrivialTree() {
		BinaryTreeNode<Integer> tree =
			new BinaryTreeNode<>(1,
				new BinaryTreeNode<>(2,
					new BinaryTreeNode<>(4, null, null),
					new BinaryTreeNode<>(5,
						new BinaryTreeNode<>(7, null, null),
						new BinaryTreeNode<>(8, null, null))),
				new BinaryTreeNode<>(3,
					null,
					new BinaryTreeNode<>(6, null, null)));
		LargestIndependentSet<Integer> lis = new LargestIndependentSet<>(tree);
		assertEquals(5, lis.calculate());
	}

}
