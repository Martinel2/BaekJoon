package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static String s;
    static int len;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        len = s.length();
        visited = new boolean[len];
        dfs(0, len);
    }

    static void dfs(int start, int end){
        if(start==end){return;}
        char minChar = s.charAt(start);
        int minIdx = start;
        for(int i=start+1;i<end;i++){
            if(s.charAt(i)<minChar){
                minChar = s.charAt(i);
                minIdx = i;
            }
        }
        visited[minIdx] = true;
        for(int i=0;i<len;i++){
            if(visited[i]){System.out.print(s.charAt(i));}
        }
        System.out.println();
        dfs(minIdx+1,end);
        dfs(start,minIdx);
    }
}
