package cow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class cow implements Comparable<cow>{
		int arrive;
		int exam;
		
		cow(int arrive, int exam){
			this.arrive = arrive;
			this.exam = exam;
		}
		
		@Override
		public int compareTo(cow o) {
			if(this.arrive == o.arrive)
				return this.exam - o.exam;
			return this.arrive - o.arrive;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		cow[] arr = new cow[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int arrive = Integer.parseInt(st.nextToken());
			int exam = Integer.parseInt(st.nextToken());
			arr[i] = new cow(arrive, exam);
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		for(int i = 0; i<N; i++) {
			if(ans < arr[i].arrive)
				ans = arr[i].arrive;
			ans += arr[i].exam;
		}
		
		System.out.println(ans);
	}
}
