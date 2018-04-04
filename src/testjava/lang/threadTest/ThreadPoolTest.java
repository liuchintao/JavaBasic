package testjava.lang.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		TaskRunnable task = new TaskRunnable();
		TaskCallable ctask= new TaskCallable();
		service.submit(task);
		System.out.println("--------------------");
		service.submit(ctask);
		service.shutdown();
	}
}
