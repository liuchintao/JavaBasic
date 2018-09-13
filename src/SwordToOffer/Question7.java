package SwordToOffer;

public class Question7 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			int n = super_fun(i);
			System.out.println("i : " + i + " => " + n);	
		}
	}

	private static int fun(int i) {
		if(i == 0)
			return 0;
//		System.out.println(0);
		int n = 1, pre = 1, temp;
//		System.out.println(n);
		for(int j = 1; j < i; j++) {
			temp = pre;
			pre = n;
			n += temp;
//			System.out.println(n);
		}
		return n;
	}
	
	private static int super_fun(int n) {
		if(n == 0 || n == 1)
			return n;
		return 1 << (n-1);
	}
}
