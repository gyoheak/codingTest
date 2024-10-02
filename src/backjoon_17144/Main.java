package backjoon_17144;

import java.util.*;
import java.io.*;

public class Main {

    static int R, C, T;
    static int[][] arr;
    static int[] up = {1, -1, 0, 0}, side = {0, 0, 1, -1};
    static int airTop, airBottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findAirCondition();
        for(int i = 0; i< T; i++){
            arr = dust();
            airCondition();
        }

        int sol = count();
        System.out.println(sol);
    }

    static void findAirCondition(){
        for(int i = 0; i < R; i++){
            if(arr[i][0] == -1){
                airTop = i;
                airBottom = i+1;
                break;
            }
        }
    }

    static int[][] dust(){
        int[][] dustMap = new int[R][C];

        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == -1){
                    dustMap[i][j] = -1;
                    continue;
                }
                dustMap[i][j] += arr[i][j];
                for(int k = 0; k < 4; k++){
                    int dx = j + side[k];
                    int dy = i + up[k];
                    if(dx < 0 || dy < 0 || dx >= C || dy >= R) continue;
                    if(arr[dy][dx] == -1) continue;

                    dustMap[dy][dx] += arr[i][j]/5;
                    dustMap[i][j] -= arr[i][j]/5;
                }
            }
        }
        return dustMap;
    }

    static void airCondition(){
        // 왼쪽위
        for(int y = airTop -1; y >0; y--){
            arr[y][0] = arr[y-1][0];
        }

        // 위
        for(int x = 0; x < C-1; x++){
            arr[0][x] = arr[0][x+1];
        }

        // 오른쪽 위
        for(int y = 0; y < airTop; y++){
            arr[y][C-1] = arr[y+1][C-1];
        }

        // 위쪽 중간
        for(int x = C-1; x > 1; x--){
            arr[airTop][x] = arr[airTop][x-1];
        }
        arr[airTop][1] = 0;

        // 아래쪽 시작 왼쪽 아래
        for(int y = airBottom+1; y < R - 1; y++){
            arr[y][0] = arr[y+1][0];
        }

        //아래
        for(int x = 0; x < C-1; x++){
            arr[R-1][x] = arr[R-1][x+1];
        }

        //우측
        for(int y = R-1; y > airBottom; y--){
            arr[y][C-1] = arr[y-1][C-1];
        }

        // 아래
        for(int x = C-1; x>1; x--){
            arr[airBottom][x] = arr[airBottom][x-1];
        }

        arr[airBottom][1] = 0;
    }

    public static int count(){
        int temp = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp += arr[i][j];
            }
        }
        return temp +2;
    }
}
