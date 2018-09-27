package Interview.xiecheng;

import java.util.Scanner;

public class FindNumInMatrix {

	public static void main(String[] args) {
		/**
		 * 1,3,5,16,18|10,11,14,17,20|23,30,34,40,50|25,33,36,42,55
		 * 24
		 */
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if(s == null || s.length() == 0) {
        	System.out.println(false);
        	return;
        }
        String ss[]=s.split("\\|");
        long[][] nums=new long[ss.length][];
        for (int i=0;i<ss.length;i++){
            String[] ns=ss[i].split(",");
            nums[i]=new long[ns.length];
            for (int j=0;j<ns.length;j++){
                nums[i][j]=Long.valueOf(ns[j]);
            }
        }
        long target=sc.nextLong();
        System.out.println(find(nums, target));
	}

	public static boolean find(long[][] array, long target) {
        boolean found = false;
        long lie = array[0].length;
        long hang = array.length;
        long column = lie -1;
        long row =0;
        while(row<hang &&column>=0){
            long value = array[(int) row][(int) column];
            if(target>value){
                row++;
            }else if(value>target){
                column--;
            }else{
                found = true;
                break;
            }
        }
        return found;
    }
}
