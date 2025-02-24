package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	
	static class M{
		int x;
		int y;
		
		M(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static boolean check(int x, int y) {
		return (0<= x && x < n) && (0<=y && y<m);
	}
	
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        ArrayList<M> shark = new ArrayList<>();
        int[][] min = new int[n][m];
        int max = 0;
        
        int[][] dir = { {0,1}, {0,-1}, {1,1}, {1,-1}, 
        				{1,0}, {-1,0}, {-1,1},{-1,-1} };
        
        for(int i =0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) shark.add(new M(i,j));
        		
        		min[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        for(M s :shark) {
        	Queue<M> q = new LinkedList<>();
        	boolean[][] visit = new boolean[n][m];
        	for(int i=0; i<8; i++) {
        		int nx = s.x+dir[i][0];
        		int ny = s.y+dir[i][1];
        		
        		if(check(nx,ny) && min[nx][ny] > 1 && arr[nx][ny] == 0) {
        			min[nx][ny] = 1;
        			visit[nx][ny] = true;
        			q.add(new M(nx,ny));
        		}
        	}
        	
        	while(!q.isEmpty()) {
        		M now = q.poll();
        		
        		for(int i=0; i<8; i++) {
            		int nx = now.x+dir[i][0];
            		int ny = now.y+dir[i][1];
            		
            		if(check(nx,ny) && arr[nx][ny] == 0
            				&& min[nx][ny] > min[now.x][now.y]+1 ) {
            			min[nx][ny] = min[now.x][now.y]+1;
            			visit[nx][ny] = true;
            			q.add(new M(nx,ny));
            		}
            	}
        	}
        }

        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(min[i][j] == Integer.MAX_VALUE) continue;
    			max = Math.max(max, min[i][j]);	
        	}
        }
        
    	System.out.println(max);
    }
}