package backjoon_1920;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static HashMap<Integer, Integer> check= new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            check.put(Integer.parseInt(st.nextToken()), 1);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j< M; j++){
            if(check.get(Integer.parseInt(st.nextToken())) != null){
                System.out.println(1);
            }else System.out.println(0);
        }
    }
}
