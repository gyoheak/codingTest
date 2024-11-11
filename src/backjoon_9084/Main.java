package backjoon_9084;

import java.util.*;
import java.io.*;

public class Main {

    static int T, N, M;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[M+1];
            dp[M] = 1;
            for(int j = M; j >0; j--){
                if(dp[j] == 0) continue;
                for(int k = 0; k < N; k ++){
                    if(j-coin[k] < 0) continue;
                    dp[j-coin[k]] = dp[j] +1;
                }
            }
            System.out.println(dp[0]);

        }
    }
}
