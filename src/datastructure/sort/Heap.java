package datastructure.sort;

public class Heap<T extends Comparable<T>> {
	private T[] heap;
	private int n = 0;

	public Heap(int maxN) {
		this.heap = (T[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private boolean less(int i, int j) {
		return heap[i].compareTo(heap[j]) < 0;
	}

	private void swap(int i, int j) {
		T t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(j, j + 1))
				swap(j, j + 1);
			if (!less(k, j))
				break;
			swap(k, j);
			k = j;
		}
	}

	public void insert(T t) {
		heap[++n] = t;
		swim(n);
	}

	public T del() {
		T max = heap[1];
		heap[1] = heap[n--];
		sink(1);
		return max;
	}

	public T[] getHeap() {
		return heap;
	}

	public void setHeap(T[] heap) {
		this.heap = heap;
	}

	public int getN() {
		return n;
	}

	public void setN() {
		if (heap != null)
			this.n = heap.length - 1;
		else
			this.n = 0;
	}

	public void sort() {
		for(int k = n / 2; k >= 1; k--) 
			sink(k);
		int N = this.n;
		while(N > 1) {
			swap(1, N--);
			sink(1);
		}
	}
}
