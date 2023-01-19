import java.io.*;
import java.util.*;

//1120 ¹®ÀÚ¿­
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int Alen = A.length();
		int Blen = B.length();
		int min = 100;
		for(int i = 0; i<=Blen-Alen; i++) {
			int cnt = 0;
			for(int j = 0; j<Alen; j++) {
				if( !(A.charAt(j) == B.charAt(i+j)) ) {
					cnt++;
				}
			}
			if(cnt < min)
				min = cnt;
		}
		System.out.println(min);
	}
}
