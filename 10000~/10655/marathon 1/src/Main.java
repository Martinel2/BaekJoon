import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10655 마라톤 1
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N];
		int greedy = 0;
		int idx = 0;
		st = new StringTokenizer(br.readLine()); //i-2
		int befx = Integer.parseInt(st.nextToken());
		int befy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); // i-1
		int prex = Integer.parseInt(st.nextToken());
		int prey = Integer.parseInt(st.nextToken());
		
		dis[1] = Math.abs(befx-prex) + Math.abs(befy-prey);
		
		for(int i = 2; i<N; i++) {
			st = new StringTokenizer(br.readLine()); // i
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			dis[i] = Math.abs(prex-x) + Math.abs(prey-y); // i-1 과 i사이 거리
			int skip = (dis[i] + dis[i-1]) - (Math.abs(befx-x) + Math.abs(befy-y));
			if(greedy < skip) {
				greedy = skip; 
				idx = i;
			}
			befx = prex;
			befy = prey;
			prex = x;
			prey = y;
		}
		int ans = 0;
		for(int i = 1; i<N; i++) {
			//System.out.println(dis[i]);
			if(i == idx) {
				ans += dis[i] - greedy;
			}
			else
				ans += dis[i];
		}
		System.out.println(ans);
	}
}
