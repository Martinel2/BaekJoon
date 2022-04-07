import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;


public class gcd {
	 public static void main(String args[]) throws IOException{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder st = new StringBuilder();
	        
	        int T = Integer.parseInt(reader.readLine());
	        while(T-- != 0) {
	        	String[] num = reader.readLine().split(" ");
	        	int a = Integer.parseInt(num[0]);
	        	int b = Integer.parseInt(num[1]);
	        	//gcd(a,b) = gcd(b,r)
	        	if(a<b)
	        	{
	        		int temp = a;
	        		a = b;
	        		b = temp;
	        	}
	        	int ab = a*b;
	        	while(b != 0)
	        	{
	        		int r = a%b;
	        		a = b;
	        		b = r;
	        	}
	        	st.append(ab/a + " " + a + "\n");
	        }
	        System.out.println(st);
	 }
}
