package baekdaey;
import java.io.*;
import java.util.*;


//14490 ��뿭
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int A = a;
		int B = b;
		//gcd�� ����ϸ� �ִ�. gcd(a,b) = gcd(b,r)
		if(a<b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(b >= 1)
		{
			int r = a%b;
			a = b;
			b = r;
		}
		System.out.println(A/a+":"+B/a);			
	}
}