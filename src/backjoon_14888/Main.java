package backjoon_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] op;
    static int[] numbers;
    static int max;
    static int min = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        op = new int[4];
        numbers = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        DFS(1,numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int depth, int sum){
        if(depth == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i =0; i< 4; i++){
            if(op[i] > 0){
                op[i] --;
                switch(i){
                    case 0:
                        DFS(depth+1, sum+numbers[depth]);
                        break;
                    case 1:
                        DFS(depth+1, sum-numbers[depth]);
                        break;
                    case 2:
                        DFS(depth+1, sum * numbers[depth]);
                        break;
                    case 3:
                        DFS(depth+1, sum / numbers[depth]);
                        break;
                }
                op[i] ++;
            }
        }
    }
}