package backjoon_2579;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        DP();
    }

    static void DP() {
        if (N == 1) {
            System.out.println(stairs[0]);
        } else if (N == 2) {
            System.out.println(stairs[0] + stairs[1]);
        } else if (N == 3) {
            System.out.println(Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]));
        } else {
            dp[0] = stairs[0];
            dp[1] = stairs[0] + stairs[1];
            dp[2] = Math.max(stairs[0]+ stairs[2], stairs[1]+stairs[2]);
            for(int i = 3; i < N; i ++){
                dp[i] = Math.max(stairs[i] + dp[i-2], stairs[i] + stairs[i-1] + dp[i-3]);
            }
            System.out.println(dp[N-1]);
        }
    }
}