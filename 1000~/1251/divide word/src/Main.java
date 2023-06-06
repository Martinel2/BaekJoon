import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int len = s.length();
		
		StringBuffer a,b,c;
		int div = 0;
		
		for(int i = 1; i<len-2; i++) {
			if(s.charAt(div) > s.charAt(i)) {
				div = i;
			}
		}
		a = new StringBuffer(s.substring(0, div+1));
		a.reverse();
		int div2 = div+1;
		
		for(int i = div2; i<len-1; i++) {
			if(s.charAt(div2) > s.charAt(i)) {
				div2 = i;
			}
		}
		b = new StringBuffer(s.substring(div+1, div2+1));
		b.reverse();
		c = new StringBuffer(s.substring(div2+1));
		c.reverse();
		
		System.out.println(a +""+ b +""+ c);
	}
}
