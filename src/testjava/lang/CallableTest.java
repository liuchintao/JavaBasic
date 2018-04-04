package testjava.lang;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
	public static void main(String[] args) {
		CallableTest ct = new CallableTest();
		FutureTask<Integer> ft = new FutureTask<>(ct);
		FutureTask<Integer> ft1 = new FutureTask<>(ct);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
			if (i == 5) {
				new Thread(ft, "5th Thread with return value").start();
			}
			if (i == 9) {
				new Thread(ft1, "9th Thread with return value").start();
			}
		}
		try {
			System.out.println("Subthread value is: " + ft.get());
			System.out.println("Subthread value is: " + ft1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 9; i++) {
			System.out.println(Thread.currentThread().getName() + "_" + i);
		}
		return i;
	}
}
