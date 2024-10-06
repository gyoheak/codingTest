package backjoon_2178;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] side = {-1, 1, 0, 0};
    static int[] up = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            String maparr = br.readLine();
            for (int j = 0; j<M; j++){
                map[i][j] = maparr.charAt(j) - '0';
            }
        }
        System.out.println(BFS(0,0));
    }

    static int BFS(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            for(int i = 0; i<4; i++){
                int dx = curX + side[i];
                int dy = curY + up[i];
                if(dx >=0 && dy >= 0 && dx < N && dy < M ){
                    if(map[dx][dy] == 1 && !visited[dx][dy]){
                        queue.offer(new int[]{dx, dy});
                        visited[dx][dy] = true;
                        map[dx][dy] = map[curX][curY] +1;
                    }
                }
            }
        }

        return map[N-1][M-1];
    }
}
