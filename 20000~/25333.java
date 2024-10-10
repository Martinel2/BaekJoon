package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int a,int b) {
		//a>b이여야 함
		//System.out.println(a + " " + b);
		if(b == 0) return a;
		else return gcd(b,a%b);
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb  = new StringBuilder();
    	int t = Integer.parseInt(br.readLine());
    	
    	while(t-->0) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		
    		int ans = 1;
    		//a와 b의 최대 공약수의 배수만큼 떨어진 곳에만 도달 가능
    		//gcd이후 x가 넘지 않을 때 까지 곱하기
    		if(a < b) {
    			int tmp = a;
    			a=b;
    			b=tmp;
    		}
    		int g = gcd(a,b);
    		if(g == 1) ans = x;
    		else {
	    		ans = x/g;
    		}
    		sb.append(ans).append('\n');
    	}
    	System.out.println(sb);
    }
}
