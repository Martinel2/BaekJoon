package lcd;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++)
		{
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(tk.nextToken());
			int B = Integer.parseInt(tk.nextToken());
			
			if(A<B)
        	{
        		int temp = A;
        		A = B;
        		B = temp;
        	}
        	int AB = A*B;
        	while(B != 0)
        	{
        		int r = A%B;
        		A = B;
        		B = r;
        	}
        	
        	st.append(AB/A);
        	st.append("\n");
		}
		System.out.print(st);
	}
	
}
