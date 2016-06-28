package problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * The description and specifications of the <i>Flower Garden</i> problem are outlined
 * <a href="http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006">here</a>.
 * 
 * @author Hardik Vala
 */
public class FlowerGarden {
	
	/** Heights of the flowers. */
	private int[] height;
	/** The morning each type of flower springs. */
	private int[] bloom;
	/** The evening that each type of flower dies. */
	private int[] wilt;

	/** Tracks elements of height in the order flowers should be planted. */
	private int[] ordering;

	/**
	 * Constructor.
	 *
	 * @param height - Heights of flowers.
	 * @param bloom - Mornings each flower blooms.
	 * @param wilt - Evens each flower dies.
	 */
	public FlowerGarden(int[] height, int[] bloom, int[] wilt) {
		this.height = height;
		this.bloom = bloom;
		this.wilt = wilt;

		this.ordering = new int[height.length];
	}

	// Convenience class for representing a flower.
	private static class Flower implements Comparable<Flower>{
		
		private int height;
		private int bloom;
		private int wilt;
		
		private Flower (int h, int b, int w) {
			this.height = h;
			this.bloom = b;
			this.wilt = w;
		}

		@Override
		public int compareTo (Flower f) {
			return (this.height - f.height);
		}
		
	}

	/**
	 * Determines the optimal ordering in which flowers should be planted.
	 *
	 * @return Elements of height in the order flowers should be planted.
	 */
	public int[] det() {
		List<TreeSet<Flower>> subOrderings = new LinkedList<TreeSet<Flower>>();
		
		for (int i = 0; i < this.height.length; i++) {
			boolean foundOrdering = false;
			
			for (TreeSet<Flower> so : subOrderings) {
				for (Flower f : so) {
					if ((f.bloom <= this.wilt[i]) && (this.bloom[i] <= f.wilt)) {
						foundOrdering = true;
						break;
					}
				}

				if (foundOrdering) {
					so.add(new Flower(this.height[i], this.bloom[i], this.wilt[i]));
					break;
				}
			}
			
			if (!foundOrdering) {
				TreeSet<Flower> newSubOrdering = new TreeSet<Flower>();
				newSubOrdering.add(new Flower(this.height[i], this.bloom[i], this.wilt[i]));
				subOrderings.add(newSubOrdering);
			}
		}
		
		Collections.sort(subOrderings, new Comparator<TreeSet<Flower>>() {
			@Override
			public int compare (TreeSet<Flower> so1, TreeSet<Flower> so2) {
				return so2.first().height - so1.first().height;
			}
		});
		
		int i = 0;
		for (TreeSet<Flower> so : subOrderings) {
			for (Flower f : so) {
				this.ordering[i] = f.height;
				i++;
			}
		}
		
		return this.ordering;
	}
	
}
