package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = 2;
		
		for(int i =2; i<=n; i++) ans*=3;
		
		System.out.println(ans);
	}
}