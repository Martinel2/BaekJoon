package solved;

import java.io.*;
import java.util.*;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] input = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                input[i][j] = line.charAt(j);
            }
        }

        for(int i = M - 1; i >= 0; i--){
            for(int j = 0; j < N; j++){
                bw.write(reverse(input[j][i]));
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static char reverse(char c){
        if(c == '-') return '|';
        if(c == '|') return '-';
        if(c == '/') return '\\';
        if(c == '\\') return '/';
        if(c == '^') return '<';
        if(c == '<') return 'v';
        if(c == 'v') return '>';
        if(c == '>') return '^';
        return c;
    }
}