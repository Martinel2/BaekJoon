import java.io.*;
import java.util.*;

//1051 숫자 정사각형
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sq = new int[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				sq[i][j] = Integer.valueOf(s.charAt(j));
			}
		}
		int max = 1;
		int k = 1;
		int len = Math.min(N, M);
		while(k<len) {
			for(int i = 0; i<N-k; i++) {
				for(int j = 0; j<M-k; j++) {
					if( (sq[i][j] == sq[i][j+k]) && (sq[i][j] == sq[i+k][j]) && (sq[i][j] == sq[i+k][j+k]) ) {
						max = (k+1)*(k+1);
					}
				}
			}
			k++;
		}
		System.out.print(max);
	}
}
/*
11 10
9785409507
2055103694
0861396761
3073207669
1233049493
2300248968
9769239548
7984130001
1670020095
8894239889
4053971072
*/