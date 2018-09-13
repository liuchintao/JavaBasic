package datastructure.sort;

public abstract class Sort<T extends Comparable<T>> {
	public abstract void sort(T[] eles);
	
	public boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	public void swap(T[] eles, int idxa, int idxb) {
		T t = eles[idxa];
		eles[idxa] = eles[idxb];
		eles[idxb] = t;
	}

}
