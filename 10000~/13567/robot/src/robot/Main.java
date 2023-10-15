package robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		
		st = new StringTokenizer(br.readLine());
		int size, N;
		size = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int y=0,x=0;
		int d = 0;
		boolean not = false;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String com = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(not)
				continue;
			if(com.equals("MOVE")) {
				x += dx[d]*num;
				y += dy[d]*num;
				
				if((x < 0 || x > size) || (y < 0 || y > size)) {
					not = true;
				}
			}
			else {
				if(num == 0) {
					d -= 1;
					if(d < 0)
						d += 4;
				}
				else {
					d = (d+1)%4;
				}
			}
		}
		
		if(x == -1)
			System.out.println(-1);
		else
			System.out.println(x+" "+y);
	}
}

/*
11 14
MOVE 10
TURN 0
MOVE 2
TURN 0
MOVE 5
TURN 1
MOVE 5
TURN 1
MOVE 2
TURN 1
MOVE 3
TURN 0
TURN 0
MOVE 6
*/
