package backjoon_1283;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<String> inputs;

    static HashSet<Character> shortcuts = new HashSet<>();

    static List<String> result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            inputs = new ArrayList<>();
            inputs.addAll(List.of(br.readLine().split(" ")));
            result = new ArrayList<>();
            Boolean assigned = false;
            // 잘라서 첫 글자로 구분해보기
            for(int j = 0; j< inputs.size(); j++){
                if(shortcuts.contains(Character.toLowerCase(inputs.get(j).charAt(0)))){
                    continue;
                }else{
                    shortcuts.add(Character.toLowerCase(inputs.get(j).charAt(0)));
                    for(int k = 0; k< inputs.size(); k++){
                        if(j == k){
                            if(k == 0){
                                sb.append("[").append(inputs.get(k).charAt(0)).append("]").append(inputs.get(k).substring(1));
                            }else {
                                sb.append(" ").append("[").append(inputs.get(k).charAt(0)).append("]").append(inputs.get(k).substring(1));
                            }
                        }else {
                            if (k == 0) {
                                sb.append(inputs.get(k));
                            }else {
                                sb.append(" ").append(inputs.get(k));
                            }
                        }

                        if(k == inputs.size() -1) sb.append('\n');
                    }
                    assigned = true;
                    break;
                }
            }

            if(!assigned) {
                for (int j = 0; j < inputs.size(); j++) {
                    String word = inputs.get(j);

                    // 각 문자를 result 리스트에 추가
                    for (char c : word.toCharArray()) {
                        result.add(String.valueOf(c));
                    }

                    // 마지막 단어가 아니라면 띄어쓰기를 추가
                    if (j < inputs.size() - 1) {
                        result.add(" ");
                    }
                }

                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j).equals(" ")) {
                        sb.append(result.get(j));
                        continue;
                    }

                    if (shortcuts.contains(Character.toLowerCase(result.get(j).charAt(0)))) {
                        sb.append(result.get(j));
                        if(j == result.size()-1){
                            sb.append("\n");
                        }
                    } else {
                        shortcuts.add(Character.toLowerCase(result.get(j).charAt(0)));
                        sb.append("[").append(result.get(j)).append("]");
                        for (int k = j + 1; k < result.size(); k++) {
                            sb.append(result.get(k));
                        }
                        sb.append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
