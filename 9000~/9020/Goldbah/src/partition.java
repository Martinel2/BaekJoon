import java.io.*;
import java.util.*;


public class partition {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		boolean[] che = new boolean[10001];
		Arrays.fill(che, true);
		che[0] = false;
		che[1] = false;
		
		for(int i = 2; i<=10000; i++)
		{
			int  n = 2;
			while(i*n <= 10000)
			{
				che[i*n] = false;
				n++;
			}
			
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++)
		{
			int j;
			int n = Integer.parseInt(br.readLine());
			for(j = n/2; j>=2; j--)
			{
				if(che[j] && che[n-j])
				{
					st.append(j);
					st.append(" ");
					st.append(n-j);
					st.append("\n");
					break;
				}
			}
		}
		System.out.println(st);
	}
}
