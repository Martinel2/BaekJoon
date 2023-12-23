import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int clocknum(String s) {
		char a,b,c,d;
		a = s.charAt(0);
		b = s.charAt(1);
		c = s.charAt(2);
		d = s.charAt(3);
		
		int s1 = (a-'0')*1000 + (b-'0')*100 + (c-'0')*10 + (d-'0');
		int s2 = (b-'0')*1000 + (c-'0')*100 + (d-'0')*10 + (a-'0');
		int s3 = (c-'0')*1000 + (d-'0')*100 + (a-'0')*10 + (b-'0');
		int s4 = (d-'0')*1000 + (a-'0')*100 + (b-'0')*10 + (c-'0');
		
		int res = Math.min(s1, Math.min(s2, Math.min(s3, s4)));
		
		return res;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> cnt = new HashSet<>();
		String ar = "";
		
		for(int i = 0; i<4; i++) {
			ar += st.nextToken();
		}
		
		int num = clocknum(ar);
		
		
		for(int i = num-1; i>=1111; i--) {
			String a = String.valueOf(i);
			
			if(a.contains("0"))
				continue;
			
			int cnum = clocknum(a);
			if(cnum < num) {
				cnt.add(cnum);
			}
		}
		
		System.out.println(cnt.size()+1);
	}
}
