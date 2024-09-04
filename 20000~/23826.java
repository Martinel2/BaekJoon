package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());

		int[][] wifi = new int [n+1][3];
		int[][] dis = new int[n+1][n+1];
		int[] e = new int[n+1];
		for(int i = 0; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			wifi[i][0] = Integer.parseInt(st.nextToken());//x
			wifi[i][1] = Integer.parseInt(st.nextToken());//y
			wifi[i][2] = Integer.parseInt(st.nextToken());//e
		}
		
		//i방과 j방 사이 거리
		for(int i = 0; i<=n; i++) {
			dis[i][i] = 0;
			for(int j = i+1; j<=n; j++) {
				int distance = Math.abs(wifi[i][0]-wifi[j][0]) + Math.abs(wifi[i][1]-wifi[j][1]);
				dis[i][j] = distance;
				dis[j][i] = distance;
			}
		}
		
		// 소학습실에서 i방에 전달되는 와이파이세기
		for(int i = 1; i<=n; i++) {
			e[i] = Math.max(0, wifi[0][2] - dis[0][i]);
		}
		
		// 세기 - 핫스팟 세기 합을 빼기
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				e[j] -= Math.max(0, wifi[i][2] - dis[i][j]);
			}
		}
		
		int ans=0;
		for(int i = 1; i<=n; i++) {
			ans = Math.max(ans, e[i]);
		}
		
		String res = ans!=0? Integer.toString(ans):"IMPOSSIBLE";
		
		System.out.println(res);
	}
}
