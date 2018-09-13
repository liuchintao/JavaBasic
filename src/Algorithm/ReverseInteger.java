package Algorithm;

public class ReverseInteger {

	public static void main(String[] args) {
		int a=0,b= 0;
		solve(10);
		solve(120);
		solve(Integer.MIN_VALUE);
		solve(Integer.MAX_VALUE);
		solve(1056389759);
	}
	
	private static void solve(int x) {
		int rev = 0, pop = 0;
        while(x != 0){
            pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) {
                System.out.println(0);
                return;
            }
            rev = rev * 10 + pop;
        }
        System.out.println(rev);
//		StringBuffer num = new StringBuffer();
//		byte f = -1;
//		if(x < 0) {
//			num.append(String.valueOf(x*-1));
//		}
//		else {
//			num.append(String.valueOf(x));
//			f = 1;
//		}
//		try {
//			x = Integer.parseInt(num.reverse().toString())*f;
//		}catch(NumberFormatException e) {
//			System.out.println(0);
//		}
//		System.out.println(Integer.parseInt(num.reverse().toString())*f);
	}
}
