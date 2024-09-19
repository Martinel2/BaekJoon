package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int x = 0;
		int y = 0;
		int bef = 0;
		int dir = 0; // 0: +x, 1: -y -1: +y  -2 or +2: -x
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String turn = st.nextToken();
			
			int move = sec - bef;
			//방향을 바꾸기 전까지 움직임 처리
			if(dir == 0) { // +x
				x += move;
			}else if(dir == -1) { // +y
				y += move;
			}else if(dir == 1) { // -y
				y -= move;
			}else { // -x
				x -= move;
			}
			
			//시간 저장
			bef = sec;
			
			// 방향 바꾸기
			if(turn.equals("left")) dir--;
			if(turn.equals("right")) dir++;
			if(dir < -2) dir = 1;
			if(dir > 2) dir = -1;
			
		}
		
		int move = end - bef;
		//방향을 바꾸기 전까지 움직임 처리
		if(dir == 0) { // +x
			x += move;
		}else if(dir == -1) { // +y
			y += move;
		}else if(dir == 1) { // -y
			y -= move;
		}else { // -x
			x -= move;
		}
		System.out.println(x + " " + y);
	}
}