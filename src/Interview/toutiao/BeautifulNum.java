package Interview.toutiao;

import java.util.Scanner;

public class BeautifulNum {
	
	/**
	 * 一个数，只包含特定数字，以及各个位之和也只包含特定数字，那么这个数就是beautiful number
	 * Input:
	 * 1 2 2
	 * Output:
	 * 1
	 */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int k=sc.nextInt();

        int maxValue=(int)Math.pow(10,k)-1;
        int minValue=(int)Math.pow(10,k-1);
        int count=0;
        for(int i=minValue;i<maxValue+1;i++){
            if(itselfBeautiful(a,b,i)&&sumBeautiful(a,b,i)){
                count+=1;
            }
        }
        System.out.println(count);



    }

    public static boolean itselfBeautiful(int a ,int b,int rawNumber){
        String numStr=String.valueOf(rawNumber);
//        System.out.println(numStr);
        char[] numChar=numStr.toCharArray();

        for(Character element:numChar){
            String str=""+element;
//            System.out.println(str);
            if (!(str.equals(String.valueOf(a))|str.equals(String.valueOf(b)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean sumBeautiful(int a ,int b,int rawNumber){
        int sum=0;
        String numStr=String.valueOf(rawNumber);
//        System.out.println(numStr);
        char[] numChar=numStr.toCharArray();
//        System.out.println(numChar);
        for(Character element:numChar){
            String str=""+element;
            int digit=Integer.parseInt(str);
//            System.out.println(digit);
            sum+=digit;
        }
//        System.out.println(sum);
        return itselfBeautiful(a,b,sum);
    }


}