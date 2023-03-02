import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//27316 시간은 다시 움직인다
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M=0;
		int[] gobi = new int[300000];
		boolean clear = false;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int g = Integer.parseInt(st.nextToken());
			gobi[g] = 1;
			if(i == N-1)
				M = g;
		}
		if(N <= 150000) {
			for(int i = 1; i<300000; i++) {
				gobi[i] += gobi[i-1];
			}
            int ab = (int)Math.sqrt(M);
			int[][] dp = new int[ab+1][M+1];
			dp[0][0] = 1;
			for(int i = 0; i<=ab; i++) {
				for(int j = i*2; j<=M; j++) {
					if(dp[i][j] == 1) {
						if(j==0)//고비가 없음
						{
							if(gobi[0]==0){
								if(1 >= M) {
								clear = true;
								break;
								}
							dp[0][1] = 1;
							}
						}
						else {
							if(gobi[j]-gobi[j-1]==0) {
								dp[i][j+1] = 1;
								if(j+1 >= M) {
									clear = true;
									break;
								}
							}
						}
						int Cs = i+j+1;
						int Ce = j+(i*2)+2;
						//System.out.println("i: "+i+" j: "+j+" start: "+Cs+" End: "+(Ce+1));
						if( gobi[Ce-1] - gobi[Cs] == 0 && gobi[Cs]-gobi[Cs-1] == 0) {
							if(Ce >= M) {
								clear = true;
								break;
							}
                            dp[i+1][Ce] = 1;
						}
					}
				}
				if(clear)
					break;
			}
		}
		if(clear)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
/*
5
0 2 7 12 20
*/