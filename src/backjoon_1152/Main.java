package backjoon_1152;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        if(st.isBlank()) System.out.println(0);
        else {
            if(st.startsWith(" ")){
                String[] stlist = st.split(" ");
                System.out.println(stlist.length -1);
            }else{
                String[] stlist = st.split(" ");
                System.out.println(stlist.length);
            }
        }
    }
}
