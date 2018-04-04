package SwordToOffer;

import java.util.Scanner;
import java.lang.Math;
public class Chorus{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for(int i = 0; i < n; i++){
            arr[i+1] = in.nextInt();
        }
        if(n < 3)
            System.out.print('0');
        int[][] dp = new int[n+1][n+1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int next = i > j ? i + 1 : j + 1;
                int xy = dp[next][j] + cost(next, i, arr);
                int xn = dp[i][next] + cost(next, j, arr);
                dp[i][j] = xy < xn ? xy: xn;
            }
        }
        System.out.print(dp[0][0]);
    }
    public static int cost(int a,int b,int[] v){
        if(a != 0 && b != 0){
            return Math.abs(v[a]-v[b]);
        }
        return 0;
    }
}