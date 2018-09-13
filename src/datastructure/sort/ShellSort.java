package datastructure.sort;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	public void sort(T[] eles) {
		int n = eles.length;
		int h = 1;
		while(h < n/3)
			h = 3 * h + 1;
		while(h >= 1) {
			for(int i = h; i < n; i++)
				for(int j = i; j >= h && less(eles[j], eles[j - h]); j-=h)
					swap(eles, j, j - h);
			h /= 3;
		}
	}
	
}
