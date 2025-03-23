package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] arr;
	static boolean[][] visit;
	static int n,m;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static boolean check(int x, int y) {
		return (0<=x && x<n) && (0<=y && y<m);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(!check(nx,ny)) continue;
			
			if(arr[nx][ny] == '#' && !visit[nx][ny] ) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            arr = new char[n][m];
            visit= new boolean[n][m];
            
            int ans = 0;
            for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();
            
            for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
            		if(arr[i][j] == '#' && !visit[i][j]) {
            			ans++;
            			dfs(i,j);
            		}
            	}
            }
            sb.append(ans).append('\n');
        }
        
        System.out.println(sb);
    }
}