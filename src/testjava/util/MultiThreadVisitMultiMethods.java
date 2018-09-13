package testjava.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadVisitMultiMethods {

	static class Test {
		public synchronized void methodA() {
			System.out.println("This is method A.");
			for (int x = 0; x < 100; x++) {
				for(int y = 0; y<10000;y++) {
					
				}
				if(x == 99) {
					System.out.println("Hello 99A.");
				}
			}
			System.out.println("END_A");
		}

		public void methodB() {
			synchronized (this) {
				System.out.println("This is method B.");
			}
//			System.out.println("This is method B.");+
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(() -> t.methodA());
		es.execute(() -> t.methodB());
	}
}
