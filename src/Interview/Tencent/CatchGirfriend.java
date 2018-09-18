package Interview.Tencent;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CatchGirfriend {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while(n > 0) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
//			if(checkIsMatched(a, b, c))
//				System.out.println("YES");
//			else
//				System.out.println("NO");
//			n--;
            boolean f = false;
            Set<Integer> s = new LinkedHashSet<>();
            int j = 1;
            while(j < b) {
                int m = a * j % b;
                if (m == 0) {
                    if (c != 0) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                    f = true;
                    break;
                } else if (m == 1) {
                    System.out.println("YES");
                    f = true;
                    break;
                } else {
                    s.add(a * j % b);
                }
            	j++;
            }   
            if(f==false){
                Iterator<Integer> it = s.iterator();
                while(it.hasNext()){
                    if(c%it.next()==0){
                        System.out.println("YES");
                        f = true;
                        break;
                    }
                }
            }
            if(!f){
                System.out.println("NO");
            }
		}
	}
}
