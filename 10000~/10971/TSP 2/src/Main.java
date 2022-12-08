import java.io.*;
import java.util.*;

//10971 외판원 순회 2
public class Main {
	//문제에 출발지 설정x = 전부다 해봐야함
	//-다이나믹(브루스포스)/백트래킹
	
	static int[][] map;
	static boolean[] visit;
	static int N;
	static long min = Integer.MAX_VALUE;
	static int first;
	static void BT(int cnt,int idx, long sum) {
		if(cnt == N) {
			if(map[idx][first] != 0) {
				sum += map[idx][first];
				if(min > sum)
					min = sum;
			}
			return;
		}
		else {
			for(int i = 0; i<N; i++) {
				if(!visit[i] && map[idx][i] != 0) {
					visit[i] = true;
					BT(cnt+1,i,sum+map[idx][i]);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<N; i++) {
			visit[i] = true;
			first = i;
			for(int j = 0; j<N; j++) {
				if(map[i][j] != 0 && !visit[j]) {
					visit[j] = true;
					BT(2,j,map[i][j]);
					visit[j] = false;
				}
			}
			visit[i] = false;
		}
		System.out.println(min);	
	}
}
