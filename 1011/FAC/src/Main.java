import java.io.*;
import java.util.*;

//1011 Fly me to the Alpha Centauri
//수열이 1 2 2 3 3 4 4 5 5 6 6 ... 의 합 
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder st = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			
			int dis = y-x;
			int cnt = (int)Math.sqrt(dis);
			
            if(cnt == Math.sqrt(dis))
                st.append(cnt*2 - 1).append('\n');
            
			else if(dis<=cnt*(cnt+1)) {
				st.append(cnt*2).append('\n');
			}
			else
				st.append(cnt*2+1).append('\n');
			
		}
		System.out.println(st);
	}
}
