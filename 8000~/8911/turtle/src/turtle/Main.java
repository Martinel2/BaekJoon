package turtle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int d = 0;
			String s = br.readLine();
			int len = s.length();
			
			int x=0,y=0;
			int bx=0,by=0,sx=0,sy=0;
			
			int ans = 0;
			
			for(int i = 0; i<len; i++) {
				if(s.charAt(i) == 'F') {
					x += dx[d];
					y += dy[d];
					if(bx < x)
						bx = x;
					else if(sx > x)
						sx = x;
					if(by < y)
						by = y;
					else if(sy > y)
						sy = y;
				}
				
				if(s.charAt(i) == 'B') {
					x -= dx[d];
					y -= dy[d];
					if(bx < x)
						bx = x;
					else if(sx > x)
						sx = x;
					if(by < y)
						by = y;
					else if(sy > y)
						sy = y;
				}
				
				if(s.charAt(i) == 'L') {
					d--;
					if(d < 0)
						d = 3;
				}
				
				if(s.charAt(i) == 'R') {
					d++;
					if(d > 4)
						d = 0;
				}
			}
			if(bx != sx && by != sy) {
				ans = (bx-sx)*(by-sy);
			}
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
