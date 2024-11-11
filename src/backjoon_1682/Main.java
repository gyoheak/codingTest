package backjoon_1682;
import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static int numx, numo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("end")) break;
            map = new char[3][3];
            numx = 0;
            numo = 0;
            for(int i = 0; i< 3; i++){
                for(int j = 0; j<3; j++){
                    map[i][j] = input.charAt(3*i+j);
                    if(map[i][j] == 'X'){
                        numx ++;
                    }else if(map[i][j] == 'O'){
                        numo ++;
                    }
                }
            }

            if(numo > numx) {
                st.append("invalid").append("\n");
                continue;
            }

            // 조건들 확인
            if(numx == numo +1){
                // x 가 이김
                if(!checkBox('O') && (numx + numo) == 9){
                    st.append("valid").append("\n");
                } else if (checkBox('X') && !checkBox('O')) {
                    st.append("valid").append("\n");
                }else{
                    st.append("invalid").append("\n");
                }
            } else if (numx == numo) {
                // o 가 이김
                if(!checkBox('X') && checkBox('O')){
                    st.append("valid").append("\n");
                } else  {
                    st.append("invalid").append("\n");
                }
            }else {
                st.append("invalid").append("\n");
            }
        }
        System.out.println(st);
    }

    private static boolean checkBox(char c){
        // 세로 체크
        for(int i = 0; i < 3; i ++){
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c){
                return true;
            }
        }
        // 가로 체크
        for(int j = 0; j < 3; j++){
            if(map[0][j] == c && map[1][j] == c && map[2][j] == c){
                return true;
            }
        }
        // 대각선 체크
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        return false;
    }
}
