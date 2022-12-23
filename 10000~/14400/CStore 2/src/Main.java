import java.io.*;
import java.util.*;

//14400 ∆Ì¿«¡° 2
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		int anx = x[x.length/2];
		int any = y[y.length/2];
		long sum = 0;
		
		for(int i = 0; i<N; i++) {
			sum += Math.abs(anx-x[i]) + Math.abs(any-y[i]);
		}
		System.out.println(sum);
	}
}
