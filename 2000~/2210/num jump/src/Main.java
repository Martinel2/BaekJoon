import java.io.*;
import java.util.*;

//2210 숫자판 점프
public class Main {
	
	static int[][] arr;
	static ArrayList<String> list = new ArrayList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void move(int x, int y, String s) {
		if(s.length() == 6) {
			if(!list.contains(s))
				list.add(s);
		}
		else {
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if((0<=nx && nx<5) && (0<=ny && ny<5)) {
					s+=String.valueOf(arr[nx][ny]);
					move(nx,ny,s);
					s = s.substring(0,s.length()-1); 
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[5][5];
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				String s = String.valueOf(arr[i][j]);
				move(i,j,s);
			}
		}
		System.out.println(list.size());
	}
}
