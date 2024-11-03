package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		long ans=0;
		StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("[a-zA-Z]", " "));
		while(st.hasMoreTokens())
			ans+=Integer.parseInt(st.nextToken());
		System.out.println(ans);
	}
}