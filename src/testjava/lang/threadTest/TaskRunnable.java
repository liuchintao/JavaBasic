package testjava.lang.threadTest;

public class TaskRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Custom thread task is working..." + i);
		}
	}

}
