package ladder;
import java.io.*;
import java.util.*;

//2528 »ç´Ù¸®
public class Main {
	
	static int N,L,time=-2,M=1;
	static stick[] S;
	
	static class stick{
		int left = 0;
		int right = 0;
		int dir = 0;
		
		stick(int len, int dir){
			this.dir = dir;
			if(dir == 0) {
				this.left = 0;
				this.right = len;
			}
			else {
				this.left = L-len;
				this.right = L;
			}
		}
	}
	
	static void up() {
		while(true) {
			if(M==N)
				break;
			if( (S[M].left <= S[M+1].right && S[M].left >= S[M+1].left) ||
				(S[M].right >= S[M+1].left && S[M].right <= S[M+1].right) )
				M++;
			else if(S[M].left <= S[M+1].left && S[M].right >= S[M+1].right)
				M++;
			else if(S[M].left >= S[M+1].left && S[M].right <= S[M+1].right)
				M++;
			else
				break;
			
		}
	}
	static void move() {
		for(int i = M; i<=N; i++) {
			if(S[i].dir == 0)
			{
				S[i].left+=2;
				S[i].right+=2;
				if(S[i].right == L)
					S[i].dir = 1;
			}
			else {
				S[i].left-=2;
				S[i].right-=2;
				if(S[i].left == 0)
					S[i].dir = 0;
			}
		}
	}
	// left  0+time <= me <= length+time
	// right length-time <= me <= L-time
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		S = new stick[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int len = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			S[i] = new stick(len,dir);
		}
		while(M < N) {
			time+=2;
			up();
			move();
		}
		System.out.println(time);
	}
}
