package datastructure.sort;

public class SelectSort<T extends Comparable<T>> extends Sort<T> {
// Select minimum or maximum element in array and set it to the right location one time.
	@Override
	public void sort(T[] eles) {
		int n = eles.length;
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if(!less(eles[i], eles[j]))
					min = j;
			}
			swap(eles, i, min);
		}
	}

}
