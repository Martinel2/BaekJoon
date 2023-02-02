import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//15666 N°úM(12)
public class Main {
	
	static int[] arr;
	static int[] ans;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	static void back(int k, int cnt) {
		if(cnt == M) {
			for(int val : ans)
				sb.append(val).append(" ");
			sb.append("\n");
		}
		else {
			for(int i = 0; i<N; i++) {
				if(k <= arr[i]) {
					ans[cnt] = arr[i];
					back(arr[i],cnt+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<Integer> hs = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		N = hs.size();
		arr = new int[N];
		ans = new int[M];
		int idx = 0;
		for(int val : hs) {
			arr[idx] = val;
			idx++;
		}
		Arrays.sort(arr);
		
		back(0,0);
		
		System.out.print(sb);
	}
}
