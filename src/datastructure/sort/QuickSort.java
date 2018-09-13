package datastructure.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	public void sort(T[] eles) {
		shuffle(eles);
		quickSort(eles, 0, eles.length - 1);
	}

	private void quickSort(T[] eles, int i, int j) {
		if(i >= j)
			return;
		int p = partition(eles, i, j);
		quickSort(eles, i, p);
		quickSort(eles, p+1, j);
	}

	private int partition(T[] eles, int i, int j) {
		int l = i, h = j;
		T v = eles[i];
		while(true) {
			while(less(eles[l], v))	l++;
			while(less(v, eles[h])) h--;
			if(l >= h)
				break;
			swap(eles, l, h);
		}
		swap(eles, i, h);
		return h;
	}

	private void shuffle(T[] eles) {
		List<T> list = Arrays.asList(eles);
		Collections.shuffle(list);
		list.toArray(eles);
	}

}
