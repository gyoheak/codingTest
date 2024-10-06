package backjoon_1309;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp[0] = 2;
        dp[1] = 4;
        for(int i = 2; i < N; i++){
            dp[i] = dp[i-1] * 2 + dp[i-2];
        }

    }
}
