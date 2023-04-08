package gomgom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hs = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			if(s.equals("ENTER")) {
				cnt += hs.size();
				hs.clear();
			}
			else if(!hs.contains(s)) 
				hs.add(s);
		}
		cnt+= hs.size();
		System.out.println(cnt);
	}
}
