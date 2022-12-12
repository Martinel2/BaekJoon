import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long L = Long.parseLong(st.nextToken());
		boolean flag = true;
		while(L<=100) {
			long start = N/L - (L-1)/2;
			if(start < 0)
				break;
			if(N == (start*2 + L -1)*L/2) {
				for(long i = 0; i < L; i++) 
					System.out.print((start+i)+" ");
				flag = false;
				break;
			}
			L += 1;
		}
		if(flag)
			System.out.println("-1");
		
	}
}
