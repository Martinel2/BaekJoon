import java.io.*;
import java.util.*;


//1049 ±‚≈∏¡Ÿ
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min;
		int pack = Integer.MAX_VALUE;
		int per = Integer.MAX_VALUE;
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(pack > a)
				pack = a;
			if(per > b)
				per = b;
		}
		if(pack > per*6)
			min = per * N;
		else {
			int div = 1;
			while(div*6 < N)
				div++;
			int num1 = (pack*div);
			div -= 1;
			int num2 = (pack*div) + (per * (N-(6*div)) );
			min = Math.min(num1,num2);
		}
		System.out.println(min);
	}
}