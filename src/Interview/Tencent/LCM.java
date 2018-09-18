package Tencent;
//题目描述：输入：integer N（1<N<10^6）;
//输出：integer M
//M是满足如下条件的最小整数：LCM（n+1，n+2,......,m）=LCM(1,2,3,4......m)
//ps:LCM,最小公倍数
//这个方法是一个输入敏感的方法，最差的情况，算法复杂度为O(n^2*Log(n))


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LCM {
    /**
     * 辗转相除法求最大公约数
     * @param a
     * @param b
     * @return最大公约数
     */
    public static int GCD(int a ,int b){
        return b!=0? GCD(b,a%b):a;
    }

    /**
     *多个数的最大公倍数，例如：1，2，3，4，5的求法：
     * 先求出1，2的最大公倍数GCM（1，2），然后再求1，2的最大公倍数和3的最大公倍数，以此类推
      * @param alist
     * @return 最大公倍数
     */
    public static int GCM(List<Integer> alist){
        int answer=alist.get(0);

        for(int i=1;i<alist.size();i++){
            answer=answer*alist.get(i)/GCD(answer,alist.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int inputN=sc.nextInt();
        int guess=inputN+1;
        List<Integer> left=new ArrayList<Integer>();
        List<Integer> right=new ArrayList<Integer>();

        //从n+1开始逐个guess
        while(true){
            for(int i=inputN+1;i<guess+1;i++)
                left.add(i);

            for(int j=1;j<guess+1;j++)
                right.add(j);

            if(GCM(left)==GCM(right)){
                break;
            }else{
                guess+=1;
            }
        }
        System.out.print("my guess is: "+guess);
    }
}
