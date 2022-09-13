package oddeven;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class oddeven {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		for(int i =0; i<N; i++)
		{
			String S = reader.readLine();
			int len = S.length() - 1;
			
			if(S.charAt(len) == '0' || S.charAt(len) == '2'
					|| S.charAt(len) == '4' || S.charAt(len) == '6' || S.charAt(len) == '8')
				st.append("even\n");
			else
				st.append("odd\n");
		}
		System.out.println(st);
	}
}
