package backjoon_15686;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<int[]> chicken, house;
    static int[] distance;
    static int sol;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        distance = new int[13];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                int check = Integer.parseInt(st.nextToken());
                if(check == 1) house.add(new int[]{i, j});
                if(check == 2) chicken.add(new int[]{i, j});
            }
        }

        for(int i = 0; i< house.size(); i++){
            int count = Integer.MAX_VALUE;
            for(int j = 0; j<chicken.size(); j++){
                count = Math.min(Math.abs(house.get(i)[0] - chicken.get(j)[0])+ Math.abs(house.get(i)[1] - chicken.get(j)[1]), count);
            }
            distance[i] = count;
        }
        Arrays.sort(distance);
        for(int i = 0; i<M; i++){
            sol += distance[i];
        }
        System.out.println(sol);
    }
}
