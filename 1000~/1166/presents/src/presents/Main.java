package presents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,L,W,H;
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		
		double min = 0;
		double max = Math.min(Math.min(L, W),H);
		
		while(min<max) {
			double mid = (min+max)/2;
			
			long w = (long)(L/mid) * (long)(W/mid) * (long)(H/mid);
			
			if(w < N) {
				if(max == mid) break;
				max = mid;
			}
			else {
				if(min == mid) break;
				min= mid;
			}
			System.out.println(mid + "  "+min+ " "+max);
		}
		
		System.out.println(min);
		
	}
}
