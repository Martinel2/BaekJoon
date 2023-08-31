import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class dot implements Comparable<dot>{
		int dis;
		int col;
		
		dot(int dis, int col){
			this.dis = dis;
			this.col = col;
		}
		
		@Override
		public int compareTo(dot o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dot[] arr = new dot[N];
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int dis = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			arr[i] = new dot(dis, col);
		}
		Arrays.sort(arr);
		
		for(int i = 0; i<N; i++) {
			int left = i-1;
			int lnum = Integer.MAX_VALUE;
			int right = i+1;
			int rnum = Integer.MAX_VALUE;
			
			while(left >= 0) {
				if(arr[left].col == arr[i].col) {
					lnum = arr[i].dis -  arr[left].dis;
					break;
				}
				left--;
			}
			while(right < N) {
				if(arr[right].col == arr[i].col) {
					rnum = arr[right].dis - arr[i].dis;
					break;
				}
				right++;
			}
			ans += Math.min(lnum, rnum);
		}
		System.out.println(ans);
	}
}
