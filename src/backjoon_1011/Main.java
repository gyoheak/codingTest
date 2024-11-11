package backjoon_1011;
import java.util.*;
import java.io.*;

public class Main {
    static int N, x, y;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            System.out.println(minMoves(x,y));
        }
    }

    private static int minMoves(int x, int y){
        int d = y - x;
        int maxMove = (int) Math.sqrt(d);
        int maxMoveSqrd = maxMove * maxMove;

        if(d == maxMoveSqrd){
            return 2 * maxMove -1;
        } else if ( d<= maxMoveSqrd + maxMove) {
            return 2 * maxMove;
        }else {
            return 2* maxMove + 1;
        }
    }
}
