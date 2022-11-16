import java.io.*;
import java.util.*;


//14425 문자열집합
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<String> hs = new HashSet<>();
		int cnt = 0;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			hs.add(br.readLine());
		}
		for(int i = 0; i<M; i++) {
			String s = br.readLine();
			if(hs.contains(s))
				cnt++;
		}
		
		System.out.print(cnt);
	}
}