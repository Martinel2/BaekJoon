package solved;

import java.util.*;
import java.io.*;

public class Main {
		
	static int n,m;
	static char[] s;
	static int[] dx = {-1,0,1,-1,0,1,-1,1};
	static int[] dy = {1,1,1,-1,-1,-1,0,0};
	static char[][] arr;
	
	static boolean check(int x, int y) {
		return (0<=x && x<n) && (0<=y && y< m);
	}
	
	static boolean dfs(int x, int y, int dir, int cnt) {
		if(cnt >= s.length) return true;
		
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		
		if(check(nx,ny) && arr[nx][ny] == s[cnt]) {
			return dfs(nx,ny,dir,cnt+1);
		}
		
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        s = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[n][m];
        boolean exist = false;
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();
        
        Loop: for(int i=0; i<n; i++) {
	        	for(int j=0; j<m; j++) {
	        		if(s[0] == arr[i][j]) {
	        			if(s.length < 2) {
	        				exist = true;
	        				break Loop;
	        			}
	        			for(int k=0; k<8; k++) {
	        				int nx = i+dx[k];
	        				int ny = j+dy[k];
	        				if(check(nx,ny) && s[1] == arr[nx][ny]) {
	        					if(dfs(nx,ny,k, 2)) {
	        						exist = true;
	        						break Loop;
	        					}
	        				}
	        			}
	        		}
	        	}
        }
        
        String a = exist? "1":"0";
        System.out.println(a);
    }
}