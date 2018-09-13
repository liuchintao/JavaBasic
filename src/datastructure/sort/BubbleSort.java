package datastructure.sort;

public class BubbleSort<T extends Comparable<T>> extends Sort<T>{

	@Override
	public void sort(T[] eles) {
		int n = eles.length;
		boolean hasSwaped = false;
		for(int i = n - 1; i > 0 && !hasSwaped; i--) {
			hasSwaped = true;
			for(int j = 0; j < n; j++) {
				if(less(eles[j + 1], eles[j])) {
					hasSwaped = false;
					swap(eles, j, j + 1);
				}
			}
		}
	}

}
