import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int max = 0;
			int sum=0;
			int cnt = 0;
			int idx = 0;
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if(max < arr[i]) {
					cnt = 1;
					max = arr[i];
					idx = i+1;
				}
				else if(max == arr[i])
					cnt++;
				
				sum += arr[i];
			}
			sum -= max;
			
			if(sum < max) {
				sb.append("majority winner ").append(idx).append('\n');
			}
			else if(sum >= max && cnt == 1) {
				sb.append("minority winner ").append(idx).append('\n');
			}
			else {
				sb.append("no winner").append('\n');
			}
		}
		
		System.out.println(sb);
	}
}


/*
4
3
10
21
10
3
20
10
10
3
10
10
10
4
15
15
15
45
*/