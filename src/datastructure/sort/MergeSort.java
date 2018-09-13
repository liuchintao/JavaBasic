package datastructure.sort;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

	protected T[] aux;

	@Override
	public void sort(T[] eles) {
		aux = (T[]) new Comparable[eles.length];
		int lo = 0, hi = eles.length - 1;
		mergeSort(eles, lo, hi);
	}

	protected void mergeSort(T[] eles, int lo, int hi) {
		if(lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		mergeSort(eles, lo, mid);
		mergeSort(eles, mid + 1, hi);
		merge(eles, lo, mid, hi);

	}

	protected void merge(T[] nums, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k < hi; k++)
			aux[k] = nums[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				nums[k] = aux[j++];
			else if (j > hi)
				nums[k] = aux[i++];
			else if (less(aux[i], nums[j]))
				nums[k] = aux[i++];
			else
				nums[k] = aux[j++];
	}

}
