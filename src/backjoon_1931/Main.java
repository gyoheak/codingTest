package backjoon_1931;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        time = new int[N][2];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });

        int count = 0;
        int endTime = 0;
        for(int i = 0; i < N; i++){
            if(endTime <= time[i][0]){
                count ++;
                endTime = time[i][1];
            }
        }

        System.out.println(count);
    }
}
