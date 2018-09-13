package datastructure.sort;

public class InsertSort<T extends Comparable<T>> extends Sort<T>{
// The number of insert operation is the number of backward sequence.
	@Override
	public void sort(T[] eles) {
		int n = eles.length;
		for(int i = 1; i < n; i++)
			for(int j = i; j > 0 && less(eles[j], eles[j - 1]); j--)
				swap(eles, j, j - 1);
	}
}
