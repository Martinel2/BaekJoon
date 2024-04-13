package solved;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer>[] line = new Stack[6];
		
		for(int i = 0; i<6; i++) {
			line[i] = new Stack<>();
		}
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int plet = Integer.parseInt(st.nextToken());
			
			if(line[num].isEmpty()) 
				line[num].push(plet);
			else if(line[num].peek() < plet)
				line[num].push(plet);
			else {
				while(!line[num].isEmpty() && line[num].peek() >= plet) {
					if(line[num].peek() == plet) { 
						line[num].pop();
						break;
					}
					ans+=2;
					//System.out.println(plet+" "+ line[num].peek());
					line[num].pop();
				}
				line[num].push(plet);
			}
		}
		for(Stack s : line) {
			//System.out.println(s.size());
			ans += s.size();
		}
		System.out.println(ans);
   }
}