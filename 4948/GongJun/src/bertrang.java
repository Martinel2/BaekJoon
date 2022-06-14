import java.io.*;
import java.util.*;


public class bertrang {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		boolean[] che = new boolean[300001];
		Arrays.fill(che, true);
		che[0] = false;
		che[1] = false;
		
		for(int i = 2; i<300000; i++)
		{
			int n = 2;
			while(i*n <=300000)
			{
				che[i*n] = false;
				n++;
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T != 0)
		{
			int cnt = 0;
			for(int i = T+1; i<=2*T; i++)
			{
				if(che[i])
					cnt++;
			}
			st.append(cnt + "\n");
			T = Integer.parseInt(br.readLine());
		}

		System.out.println(st);
	}
}
