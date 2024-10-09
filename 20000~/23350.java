package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class C{
		int p;
		int w;
		
		C(int p, int w){
			this.p=p;
			this.w=w;
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	Queue<C> q = new LinkedList<>();
    	int[] cnt = new int[m+1];
    	
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		q.add(new C(p,w));
    		cnt[p]++;
    	}
    	
    	int ans = 0;
    	int boxCnt = 0;
    	Stack<C> rem = new Stack<>();
    	Stack<C> s = new Stack<>();
    	while(!q.isEmpty()) {
    		C c = q.poll();
    		if(c.p != m) {
    			q.add(c);
    			ans += c.w;
    			//System.out.println(c.p + " " + m);
    		}
    		else {
    			if(s.isEmpty()) { //적재한게 없는 경우
    				s.add(c);
    				ans += c.w;
    				//System.out.println(c.w);
    			}
    			else if(s.peek().w >= c.w) { //무게가 작은 경우
    				s.add(c);
    				ans += c.w;
    				//System.out.println(c.w);
    			}
    			else { //무게가 더 큰경우
    				while(!s.isEmpty() && s.peek().w < c.w) {
    					rem.add(s.pop());
        				ans += rem.peek().w;
        				//System.out.println(rem.peek().w);
    				}
    				s.add(c);
    				ans += c.w;
    				//System.out.println(c.w);
    				while(!rem.isEmpty()) {
    					s.add(rem.pop());
    					ans += s.peek().w;
        				//System.out.println(s.peek().w);
    				}
    			}
    			boxCnt++;
				if(boxCnt == cnt[m]) {
					s.clear();
					m--;
					boxCnt = 0;
				}
    		}
    	}
    	System.out.println(ans);
    }
}
