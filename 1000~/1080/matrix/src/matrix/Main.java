package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N,M;
		int ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//A초기화
		char[][] A = new char[N][M];
		for(int i = 0; i<N; i++) {
			A[i] = br.readLine().toCharArray();
		}
		//B초기화
		char[][] B = new char[N][M];
		for(int i = 0; i<N; i++) {
			B[i] = br.readLine().toCharArray();
		}
		if(N < 3 || M < 3) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(A[i][j] != B[i][j]) {
						ans = -1;
						break;
					}
				}
				if(ans == -1)
					break;
			}
		}
		else {
			for(int i = 0; i<(N-2); i++) {
				for(int j = 0; j<(M-2); j++) {
					if(A[i][j] != B[i][j]) {
						ans += 1;
						for(int x = i; x<i+3; x++) {
							for(int y = j; y<j+3; y++) {
								if(A[x][y] == '1') {
									A[x][y] = '0';
								}
								else {
									A[x][y] = '1';
								}
							}
						}
					}
				}
			}
			if(ans != -1) {
				for(int i = 0; i<N; i++) {
					for(int j = 0; j<M; j++) {
						if(A[i][j] != B[i][j]) {
							ans = -1;
							break;
						}
					}
					if(ans == -1)
						break;
				}
			}
		}
		System.out.println(ans);
	}
	
}
/*
3 4
0000
0010
0000
1001
1011
1001
*/