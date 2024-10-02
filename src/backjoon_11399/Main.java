package backjoon_11399;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dp[0] = arr[0];
        int count = arr[0];
        for(int i = 1; i<N; i++){
            dp[i] = arr[i] + dp[i-1];
            count += dp[i];
        }
        System.out.println(count);
    }
}
