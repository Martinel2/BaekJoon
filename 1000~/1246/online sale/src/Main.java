import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, M;
		int max = 0;
		int p = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		
		for(int i = 0; i<M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		for(int i = 0; i<M; i++) {
			int price = arr[i];
			int sum = price * Math.min(N, M-i);
			
			if(max < sum) {
				max = sum;
				p = price;
			}
		}
		
		System.out.println(p + " " + max);
	}
}
