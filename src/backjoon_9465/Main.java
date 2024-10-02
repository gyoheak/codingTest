package backjoon_9465;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i< N; i++){
            M = Integer.parseInt(br.readLine());
            sticker = new int[2][M];
            for(int j = 0; j<2; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k<M; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

    }
}
