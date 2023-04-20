import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10810
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int begin,end,num;
			begin = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			num = Integer.parseInt(st.nextToken());
			
			for(int j = begin; j<=end; j++) {
				arr[j] = num;
			}
		}
		for(int val : arr)
			System.out.print(val+" ");
	}
}
