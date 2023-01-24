import java.io.*;
import java.util.*;

//11652 Ä«µå
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Long, Integer> hm = new HashMap<>();
		long num = 0;
		int c = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			long n = Long.parseLong(br.readLine());
			if(!hm.containsKey(n)) {
				hm.put(n, 1);
			}
			else {
				hm.put(n, hm.get(n)+1);
			}
			if(hm.get(n) > c || (hm.get(n) == c && num > n) ) {
				num = n;
				c = hm.get(n);
			}
		}
		System.out.println(num);
	}
}
