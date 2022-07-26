import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("-");
		int ans = 0;
		
		
		for(int i = 0; i<s.length; i++) {
			String[] t = s[i].split("\\+");
			for(int j = 0; j<t.length; j++) {
				int sum = 0;
				sum += Integer.parseInt(t[j]);
				
				if(i == 0)
					ans+=sum;
				else
					ans-=sum;
			}
		}
		
		System.out.print(ans);
	}
}
