import java.io.*;
import java.util.*;

//11404 플로이드
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 정점개수
		int m = Integer.parseInt(br.readLine()); // 간선개수
		int[][] bus = new int[n][n]; // 인접리스트
		int INF = 987654321;
		//초기화
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i==j)
					bus[i][j] = 0;
				else
					bus[i][j] = INF;
			}
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			if(bus[a][b] > weight)
				bus[a][b] = weight;
		}
		
		//플로이드 알고리즘
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					bus[i][j] = Math.min(bus[i][j],bus[i][k]+bus[k][j]);
				}
			}
		}
		
		//출력
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(bus[i][j] == INF)
					bus[i][j] = 0;
				System.out.print(bus[i][j]+" ");
			}
			System.out.println();
		}
	}
}
