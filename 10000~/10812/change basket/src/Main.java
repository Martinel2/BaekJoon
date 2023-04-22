import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10812
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N+1];
		for(int i = 1; i<=N; i++) {
			basket[i] = i;
 		}
		for(int T = 0; T<M; T++) {
			st = new StringTokenizer(br.readLine());
			int start,end,mid;
			start = Integer.parseInt(st.nextToken());//start
			end = Integer.parseInt(st.nextToken());//end
			mid = Integer.parseInt(st.nextToken());//mid
			int[] me = new int[end-mid+1];
			int[] sm = new int[mid-start];
			for(int i = mid; i<=end; i++) {
				me[i-mid] = basket[i];
			}
			for(int i = start; i<mid; i++) {
				sm[i-start] = basket[i];
			}
			int idx = start;
			for(int i : me) {
				basket[idx++] = i;
			}
			for(int i : sm)
				basket[idx++] = i;
		}
		for(int k : basket) {
			if(k != 0)
				System.out.print(k+" ");
		}
	}
}
