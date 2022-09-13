import java.io.*;
import java.util.*;


//10610 30
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		//30의 배수 = 각 자리수의 합이 3의 배수 = 10의 배수
		StringBuilder st = new StringBuilder();
		String N = br.readLine();
		int len = N.length();
		int[] numcnt = new int[10];
		long sum = 0;
		if(!N.contains("0"))
			System.out.print(-1);
		else
		{
			for(int i = 0; i<len; i++)
			{
				int num = Integer.parseInt(N.substring(i, i+1));
				numcnt[num]++;
				sum += num;
				
			}
			if(sum % 3 != 0)
				System.out.print(-1);
			else
			{
				for(int i = 9; i >= 0; i-- ) {
					while(numcnt[i] > 0)
					{
						st.append(i);
						numcnt[i]--;
					}
				}
			}
		}
		
		System.out.print(st);
		
		
	}
}
