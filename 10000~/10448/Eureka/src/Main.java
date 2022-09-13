import java.io.*;
import java.util.*;


//10448 유레카 이론
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] c = new boolean[1001];
		
		for(int i = 1 ; i<45; i++)
		{
			int T1 = (i*(i+1))/2;
			for(int j = 1; j<45; j++)
			{
				int T2 = (j*(j+1))/2;
				if(T1+T2 >= 1000)
					break;
				for(int k = 1; k<45; k++)
				{
					int T3 = (k*(k+1))/2;
					if(T1+T2+T3 > 1000)
						break;
					else
						c[T1+T2+T3] = true;
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++)
		{
			int N = Integer.parseInt(br.readLine());
			if(c[N])
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.print(sb);
	}
}