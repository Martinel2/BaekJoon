import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sbuf;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int idx = 0;
		long[] arr = new long[n];
		
		int cnt = st.countTokens();
		for(int i = 0; i<cnt; i++) {
			sbuf = new StringBuffer();
			sbuf.append(st.nextToken());
			sbuf.reverse();
			long num = Long.parseLong(sbuf.toString());
			
			arr[idx++] = num;
		}
		
		while(idx < n) {
			st = new StringTokenizer(br.readLine());
			cnt = st.countTokens();
			for(int i = 0; i<cnt; i++) {
				sbuf = new StringBuffer();
				sbuf.append(st.nextToken());
				sbuf.reverse();
				long num = Long.parseLong(sbuf.toString());
				
				arr[idx++] = num;
			}
		}
		Arrays.sort(arr);
		
		for(long val : arr) {
			System.out.println(val);
		}
	}
}
