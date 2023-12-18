package sudden3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine())-1;
		long jun;
		int[] att = new int[N];
		String ans = "";
		
		st = new StringTokenizer(br.readLine());
		jun = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			att[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(att);
		
		boolean clear = true;
		for(int val : att) {
			if(jun > val) {
				jun += val;
			}
			else {
				clear = false;
				break;
			}
		}
		
		ans = clear ? "Yes":"No";
		System.out.println(ans);
	}
}
