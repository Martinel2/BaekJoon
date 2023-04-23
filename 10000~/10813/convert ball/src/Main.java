import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10813
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		for(int i = 0; i<M; i++) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
		for(int val : arr)
			System.out.print(val+" ");
	}
}
