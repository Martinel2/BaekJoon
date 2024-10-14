package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int g;
	static char[] d;
	static char[] str;
	static String answer;
	static int cnt;
	static int len;
	static boolean[] visit;
	static void backtracking(int now) {
		if(cnt == g) return;
		//System.out.println(ans +" "+ dst);
		if(now == len) {
			cnt++;
			if(cnt == g) {
				for(char a : str) answer += a;
			}
			return;
		}
		for(int i = 0; i<len; i++) {
			if(!visit[i]) {
				visit[i] = true;
				str[now] = d[i];
				backtracking(now+1);
				visit[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	String s;
    	while((s=br.readLine()) != null) {
    		st = new StringTokenizer(s);
    		String string = st.nextToken();
    		d = string.toCharArray();
    		g = Integer.parseInt(st.nextToken());
    		len = d.length;
    		answer = "";
    		visit = new boolean[len];
    		str = new char[len];
    		cnt = 0;
    		backtracking(0);
    		Arrays.sort(d);
    		String a = cnt>=g? answer: "No permutation";
    		sb.append(string).append(" ").append(g).append(" = ").append(a).append('\n');
    	}
    	System.out.println(sb);
    }
}
