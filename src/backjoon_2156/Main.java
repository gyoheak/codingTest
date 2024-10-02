package backjoon_2156;
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
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[N];
        if( N == 1){
            System.out.println(arr[0]);
        }else if( N ==2 ){
            System.out.println(arr[1]+ arr[0]);
        } else if (N ==3 ) {
            System.out.println(Math.max(Math.max(arr[0]+ arr[2], arr[1] + arr[2]),  arr[0]+arr[1]));
        }else{
            dp[0] = arr[0];
            dp[1] = arr[1] + arr[0];
            dp[2] = Math.max(Math.max(arr[0] + arr[1], arr[1] + arr[2]),arr[0]+arr[2]);
            for(int i = 3; i < N; i++){
                dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]), dp[i-1]);
            }
            System.out.println(dp[N-1]);
        }
    }
}
