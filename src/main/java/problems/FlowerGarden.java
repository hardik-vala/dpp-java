package problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * The description and specifications of the <i>Flower Garden</i> problem are outlined here:
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
 * 
 * @author Hardik Vala
 */
public class FlowerGarden {
	
	public static int[] getOrdering (int[] h, int[] b, int[] w) {
		int[] ordering = new int[h.length];
		
		LinkedList<TreeSet<Flower>> subOrderings = new LinkedList<TreeSet<Flower>>();
		
		for (int i = 0; i < h.length; i++) {
			boolean foundOrdering = false;
			
			for (TreeSet<Flower> so : subOrderings) {
				for (Flower f : so) {
					if ((f.bloom <= w[i]) && (b[i] <= f.wilt)) {
						foundOrdering = true;
						break;
					}
				}
				if (foundOrdering) {
					so.add(new Flower(h[i], b[i], w[i]));
					break;
				}
			}
			
			if (!foundOrdering) {
				TreeSet<Flower> newSubOrdering = new TreeSet<Flower>();
				newSubOrdering.add(new Flower(h[i], b[i], w[i]));
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
				ordering[i] = f.height;
				i++;
			}
		}
		
		return ordering;
	}
	
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
}
