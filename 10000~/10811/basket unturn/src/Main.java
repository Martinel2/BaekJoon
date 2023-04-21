import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10811
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N,M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		for(int i = 0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			while(begin < end) {
				int k = arr[begin];
				arr[begin] = arr[end];
				arr[end] = k;
				begin++;
				end--;
			}
		}
		for(int val : arr)
			System.out.print(val+" ");
	}
}
