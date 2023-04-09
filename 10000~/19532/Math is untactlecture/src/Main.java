import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a,b,c,d,e,f;
		//ax+by=c
		a= Integer.parseInt(st.nextToken());
		b= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		//dx+ey=f
		d= Integer.parseInt(st.nextToken());
		e= Integer.parseInt(st.nextToken());
		f= Integer.parseInt(st.nextToken());
		
		int x = (c*e - b*f)/(a*e - b*d);
		int y = ((-a)*x + c)/b;
		
		System.out.println(x+" "+y);
	}
}
