import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        
        String s = br.readLine();
        
        Stack<Character> sstack = new Stack<>();
        Stack<Character> lstack = new Stack<>();
        
        for(int i = 0; i<n; i++) {
        	char c = s.charAt(i);
        	if('0' <= c && c <= '9')
        		ans++;
        	else {
        		if(c == 'S') sstack.add(c);
        		if(c == 'L') lstack.add(c);
        		
        		if(c == 'R') {
        			if(!lstack.isEmpty() && lstack.peek() == 'L') {
        				lstack.pop();
        				ans++;
        			}
        			else break;
        		}
        		if(c == 'K') {
        			if(!sstack.isEmpty() && sstack.peek() == 'S') {
        				sstack.pop();
        				ans++;
        			}
        			else break;
        		}
        	}
        }
        
        System.out.println(ans);
    }
}