package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String S = br.readLine();
        
        K--;
        if ((N - K) % 2 == 0) {
            sb.append(S.substring(K)).append(S, 0, K);
        } else {
            sb.append(S.substring(K)).append(new StringBuilder(S.substring(0, K)).reverse());
        }

		System.out.println(sb);
    }
}
