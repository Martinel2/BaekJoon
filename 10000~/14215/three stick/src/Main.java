import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//14215
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a,b,c;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		if(a<b) {
			if(b<c) {
				if(c<a+b)
					System.out.println(a+b+c);
				else
					System.out.println(a+b+(a+b-1));
			}
			else {
				if(b<a+c)
					System.out.println(a+b+c);
				else
					System.out.println(a+c+(a+c-1));
			}
		}
		else {
			if(a<c) {
				if(c<a+b)
					System.out.println(a+b+c);
				else
					System.out.println(a+b+(a+b-1));
			}
			else {
				if(a<b+c)
					System.out.println(a+b+c);
				else
					System.out.println(b+c+(b+c-1));
			}
		}
	}
}
