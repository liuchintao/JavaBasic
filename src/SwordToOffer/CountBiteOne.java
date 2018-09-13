package SwordToOffer;

public class CountBiteOne {

	public static void main(String[] args) {
		for(int i = 10; i > -10; i--) {
			int num = fun(i);
			System.out.println(i + " " + Integer.toBinaryString(i) + " " +num);
		}
	}

	private static int fun(int i) {
		int num = 0;
		while(i != 0) {
			i &= (i-1);
			num ++;
		}
		return num;
	}
}
