package yangjojang;
import java.io.*;
import java.util.*;


//11557 yangjojang of the year
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++)
		{
			String m = "";
			int max = 0;
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				String s= st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(max<num)
				{
					m = s;
					max = num;
				}
			}
			sb.append(m + "\n");
		}
		System.out.print(sb);
	}
}