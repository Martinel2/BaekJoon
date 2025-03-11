package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,t;
	static class K{
		int x;
		int y;
		boolean gram;
		
		K(int x, int y){
			this.x=x;
			this.y=y;
			this.gram = false;
		}
		
		void haveGram() {
			gram = true;
		}
	}
	
	static boolean check(int x, int y) {
		return (0<=x && x<n) && (0<=y && y<m);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        boolean save = false;
        int ans = 0;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][] visit = new boolean[n][m];
        boolean[][] visit_gram = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Queue<K> q = new LinkedList<>();
        Queue<K> q2 = new LinkedList<>();
        
        visit[0][0] = true;
        q.add(new K(0,0));
        
        while(ans <= t) {
        	if(ans % 2 == 0) {
        		while(!q.isEmpty()) {
        			K now = q.poll();
        			for(int i=0; i<4; i++) {
        				int nx = now.x+dx[i];
        				int ny = now.y+dy[i];

        				if(!check(nx,ny)) continue;
        				
        				if(nx == n-1 && ny == m-1) {
        					save = true;
        					break;
        				}
        				
        				if(!visit[nx][ny]
        					&& (!now.gram && board[nx][ny] != 1)) {
        					//System.out.println(now.gram + " " + nx + " " + ny);
            				
        					K next = new K(nx,ny);
        					next.gram = now.gram;
        					if(board[nx][ny] == 2) {
        						next.gram = true;
        					}
        					visit[nx][ny] = true;
        					q2.add(next);
        				}
        				else if(now.gram && !visit_gram[nx][ny]) {
        					K next = new K(nx,ny);
        					next.gram = now.gram;
        					visit_gram[nx][ny] = true;
        					q2.add(next);
        				}
        			}

                	if(save) break;
        			
        		}
        	}
        	else {
        		while(!q2.isEmpty()) {
        			K now = q2.poll();
        			for(int i=0; i<4; i++) {
        				int nx = now.x+dx[i];
        				int ny = now.y+dy[i];
        				
        				if(!check(nx,ny)) continue;
        				
        				if(nx == n-1 && ny == m-1) {
        					save = true;
        					break;
        				}
        				
        				if(!visit[nx][ny]
        						&& (!now.gram && board[nx][ny] != 1)) {
        					//System.out.println(now.gram + " " + nx + " " + ny);
            				
        					K next = new K(nx,ny);
        					next.gram = now.gram;
        					if(board[nx][ny] == 2) {
        						next.gram = true;
        					}
        					visit[nx][ny] = true;
        					q.add(next);
        				}
        				else if(now.gram && !visit_gram[nx][ny]) {
        					K next = new K(nx,ny);
        					next.gram = now.gram;
        					visit_gram[nx][ny] = true;
        					q.add(next);
        				}
        			}
                	if(save) break;
        		}
        	}
        	ans++;
        	if(save) break;
        }
        
        if(!save) System.out.println("Fail");
        else System.out.println(ans);
    }
}