package bestseller;
import java.io.*;
import java.util.*;

//1302 º£½ºÆ®¼¿·¯
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		String book = "";
		int c = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			String s = (br.readLine());
			if(!hm.containsKey(s)) {
				hm.put(s, 1);
			}
			else {
				hm.put(s, hm.get(s)+1);
			}
			if(hm.get(s) > c || (hm.get(s) == c && s.charAt(0) < book.charAt(0)) ) {
				book = s;
				c = hm.get(s);
			}
		}
		System.out.println(book);
	}
}
