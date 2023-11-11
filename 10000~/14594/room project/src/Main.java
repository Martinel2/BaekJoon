import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean[] wall = new boolean[n-1]; //뚫을 수 있는 벽의 갯수
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j = start; j<end; j++) {
				wall[j] = true; //뚫린 벽
			}
		}
		
		int cnt = 1;
		for(int i = 0; i<n-1; i++) {
			if(!wall[i]) //뚫리지 않은 벽을 만남. -> 다른 방이 존재함
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
