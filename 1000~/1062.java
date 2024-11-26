package solved;

import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

         word = new String[n];

         for(int i = 0; i < n; i++){
             String str = br.readLine();
             word[i] = str.substring(4,str.length() - 4);
         }

         if(k<5){
             System.out.println(0);
             return;
         } else if (k == 26) {
             System.out.println(n);
             return;
         }

        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0,0);

        System.out.println(max);


    }

    public static void dfs(int index, int len){
        if(len == k-5){
            int count = 0;
            for(int i = 0; i < n; i++){
                boolean check = true;
                for(int j = 0; j < word[i].length(); j++){
                    if(!visited[word[i].charAt(j) - 'a']){
                        check = false;
                        break;
                    }
                }
                if(check) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = index; i < 26; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(i+1, len + 1);
                visited[i] = false;
            }
        }
    }


}