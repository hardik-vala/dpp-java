package problems;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;


/**
 * The description and specifications of the <i>Largest Independent Set</i> problem are outlined
 * <a href="http://www.geeksforgeeks.org/largest-independent-set-problem">here</a>.
 * 
 * @param <E> Type of tree elements.
 * @author Hardik Vala
 */
public class LargestIndependentSet<E> {
	
	/**
	 * Binary tree node.
	 *
	 * @param <T> Type of node element.
	 */
	public static class BinaryTreeNode<T> {
		private T data;
		private BinaryTreeNode<T> left;
		private BinaryTreeNode<T> right;

		/**
		 * Constructor.
		 *
		 * @param data - Node data.
		 * @param left - Left sub-tree.
		 * @param right - Right sub-tree.
		 */
		public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	/** Root of the input binary tree. */
	private BinaryTreeNode<? extends E> root;

	/**
	 * Constructor.
	 *
	 * @param root - Input binary tree root.
	 */
	public LargestIndependentSet(BinaryTreeNode<? extends E> root) {
		this.root = root;
	}

	// Returns the size of the LIS in the sub-tree rooted at the given node.
	private int calculateHelper(BinaryTreeNode<? extends E> node) {
		if (node == null) return 0;

		// LIS size excluding the given node.
		int sizeOfLISWithoutNode = this.calculateHelper(node.left) +
			this.calculateHelper(node.right);

		// LIS size including the given node.
		int sizeOfLISWithNode = 1;
		if (node.left != null)
			sizeOfLISWithNode += this.calculateHelper(node.left.left) +
				this.calculateHelper(node.left.right);
		if (node.right != null)
			sizeOfLISWithNode += this.calculateHelper(node.right.left) +
				this.calculateHelper(node.right.right);

		// Return the maximum of the two sizes.
		return Math.max(sizeOfLISWithoutNode, sizeOfLISWithNode);
	}

	/**
	 * Calculates the size of the LIS in the given tree.
	 *
	 * @return Size of LIS.
	 */
	public int calculate() {
		return this.calculateHelper(this.root);
	}

}
