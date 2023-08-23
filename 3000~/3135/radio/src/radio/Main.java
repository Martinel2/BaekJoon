package radio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A,B;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int min = Math.abs(A-B);
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			min = Math.min(min, Math.abs((num)-B)+1);
		}
		
		System.out.println(min);
	}
}
