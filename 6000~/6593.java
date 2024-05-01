package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	static class P{
		int x,y,z;
		int cnt = 0;
		P(int x, int y, int z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	static char arr[][][];
	static boolean visit[][][];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int l,r,c;
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        while(l != 0 && r != 0 && c != 0) {
	        arr = new char[l][r][c];
	        visit = new boolean[l][r][c];
	        boolean clear = false;
	        int strx=0,stry=0,strz=0;
	        int endx=0,endy=0,endz=0;
	       
	        for(int i = 0; i<l; i++) {
	        	for(int j=0; j<r; j++) {
	        		String s = br.readLine();
	        		for(int k=0; k<c; k++) {
	        			arr[i][j][k] = s.charAt(k);
	        			if(arr[i][j][k] == 'S') {
	        				strx = k;
	        				stry = j;
	        				strz = i;
	        			}
	        			else if(arr[i][j][k] == 'E') {
	        				endx = k;
	        				endy = j;
	        				endz = i;
	        			}
	        		}
	        	}
	        	br.readLine();
	        }
	        
	        int[] dx = {1,-1,0,0,0,0};
	    	int[] dy = {0,0,1,-1,0,0};
	    	int[] dz = {0,0,0,0,1,-1};
	    	
	    	Queue<P> q = new LinkedList<>();
	    	q.add(new P(strx,stry,strz));
	    	
	    	while(!q.isEmpty()) {
	    		if(clear) break;
	    		
	    		P p = q.poll();
	    		int x = p.x;
	    		int y = p.y;
	    		int z = p.z;
	    		
	    		if(x==endx && y==endy && z==endz) {
	    			clear = true;
	    			sb.append("Escaped in ").append(p.cnt).append(" minute(s).\n");
	    			break;
	    		}
	    		
	    		for(int i = 0; i<6; i++) {
	    			int nx = x + dx[i];
	    			int ny = y + dy[i];
	    			int nz = z + dz[i];
	    			
	    			if((0 <= nx && nx < c) && (0 <= ny && ny < r) && (0 <= nz && nz < l)
	    				&& arr[nz][ny][nx] != '#' && !visit[nz][ny][nx]) {
	    				visit[nz][ny][nx] = true;
	    				P nextP = new P(nx,ny,nz);
	    				nextP.cnt = p.cnt+1;
	    				q.add(nextP);
	    			}
	    		}
	    	}
	    	if(!clear)
	    		sb.append("Trapped!\n");
	    	
	    	
	        st = new StringTokenizer(br.readLine());
	        l = Integer.parseInt(st.nextToken());
	        r = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}