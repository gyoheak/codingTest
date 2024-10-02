package backjoon_14889;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] array;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for (int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        System.out.println(min);
    }

    static void DFS(int index, int depth){
        if(depth == N/2){
            count();
            return;
        }
        for(int i = index; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void count(){
        int startcount = 0;
        int linkcount = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j< N; j++){
                if(visited[i] && visited[j]){
                    startcount += array[i][j];
                    startcount += array[j][i];
                }else if (!visited[i] && !visited[j]){
                    linkcount += array[i][j];
                    linkcount += array[j][i];
                }
            }
        }

        int diff = Math.abs(startcount - linkcount);
        if(diff == 0){
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(diff, min);
    }
}
