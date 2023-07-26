package friend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] net;
	static boolean[] visit;
	
	static int c2(int idx) {
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			if(!visit[i] && net[idx][i] == 'Y') {
				cnt += 1;
				visit[i] = true;
				//System.out.println("\n"+idx + ","+i);//
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		net = new char[N][N];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				net[i][j] = s.charAt(j);
			}
		}
		
		int max = 0;
		for(int i = 0; i<N; i++) {
			visit = new boolean[N+1];
			visit[i] = true;
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				if(net[i][j] =='Y') {
					visit[j] = true;
					//System.out.print(j+" ");//
				}
			}
			//System.out.println();//
			for(int j = 0; j<N; j++) {
				if(visit[j] && net[i][j] =='Y') { 
					//System.out.print("visit true : "+j+" ");//
					cnt += c2(j);
				}
			}
			max = Math.max(max, cnt);
			//System.out.println();//
		}
		
		System.out.println(max);
	}
}

/*
10
NNNNYNNNNN
NNNNYNYYNN
NNNYYYNNNN
NNYNNNNNNN
YYYNNNNNNY
NNYNNNNNYN
NYNNNNNYNN
NYNNNNYNNN
NNNNNYNNNN
NNNNYNNNNN

6
NYYNYN
YNYNNN
YYNYNN
NNYNNN
YNNNNY
NNNNYN
*/
