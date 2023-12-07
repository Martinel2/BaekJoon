package fraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	//분수 구조체 생성
	static class P {
		long son;
		long par;
		
		P(long son2 , long par2){
			this.son = son2;
			this.par = par2;
		}
		
		P(long son){
			this.son = son;
			par = 1;
		}
	}
	
	static long gcd(long a, long b) {
		long c = a%b;
		if(c == 0)
			return b;
		return gcd(b, c);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<P> cal = new Stack<>();
		Stack<Character> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		char[] f = new char[n];
		
		f = br.readLine().replace(" ", "").toCharArray();
		
		boolean right = true;
		Loop: for(int i = 0; i<n; i++) {
			//System.out.print(f[i]);
			if(f[i] == ')') {
				if(stack.size() < 3) {
					//System.out.println("error");
					right = false;
					break;
				}
				P[] p = new P[3];
				for(int j = 2; j>=0; j--) {
					char num = stack.pop();
					if(num == '(') {
						right = false;
						break Loop;
					}
					else if(num == 'P') {
						p[j] = cal.pop();
					}
					else
						p[j] = new P(num-'0');
				}
				if(stack.peek() != '(') {
					right = false;
					break Loop;
				}
				else {
					stack.pop();
					long par = p[2].son*p[1].par*p[0].par;
					long son = (p[0].son*p[2].son*p[1].par) + (p[1].son*p[2].par*p[0].par);
					long div = gcd(Math.max(par, son), Math.min(par, son));
					cal.add(new P(son/div,par/div));
					stack.add('P');
				}
			}
			else
				stack.add(f[i]);
		}
		/*for(int i = 0; i<n; i++) {
			System.out.print(f[i]);
			if(f[i] == '(') {
				open++;
				
			}
			else if(f[i] == ')') {
				if(open == 0) {
					right = false;
					break;
				}
				else {
					open--;
					if(stack.size() < 3) {
						System.out.println("error");
						right = false;
						break;
					}
					P c = stack.pop();//분모
					P b = stack.pop();//분자
					P a = stack.pop();//수
					if(!stack.isEmpty() && stack.peek().par == 1) {
						System.out.println("error");
						right = false;
						break;
					}
						
					long par = c.son*b.par*a.par;
					long son = (a.son*c.son*b.par) + (b.son*c.par*a.par);
					long div = gcd(Math.max(par, son), Math.min(par, son));
					stack.add(new P(son/div,par/div));
				}
			}
			else {
				int digit = f[i] - '0';
				stack.add(new P(digit));
			}
		}
		*/
		if(!right || stack.size() != 1) {
			System.out.println(-1);
		}
		else {
			P ans = cal.pop();
			long son = ans.son;
			long par = ans.par;
			//long div = gcd(Math.max(par, son), Math.min(par, son));
			System.out.println(son+" "+par);
		}
		

	}
}
