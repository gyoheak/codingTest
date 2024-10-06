package backjoon_14503;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] robot;

    static int[][] map;

    static int[] up = {1, -1, 0, 0};
    static int[] side = {0, 0, 1, -1};

    static int[] direction = {1, 3, 2, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        robot = new int[3];
        for(int i = 0; i < 3; i++){
            robot[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< N; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j< N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(robot);
    }
}
