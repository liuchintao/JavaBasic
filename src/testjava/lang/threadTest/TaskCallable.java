package testjava.lang.threadTest;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("Custom callable thread task is working..." + i);
		}
		return null;
	}

}
