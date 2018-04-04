package testjava.util;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("Yes, I'm alive. :)");
	}
	
	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method execute.");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("No, I'm dead. :(");
		}
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("No, I'm dead. :(");
		}
	}
}
