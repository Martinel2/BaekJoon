package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<BigInteger> arr = new ArrayList<>();
		
		String[] s;
		for(int i = 0; i<N; i++) {
			s = br.readLine().split("\\D");
			for(int j = 0; j<s.length; j++) {
				if(!s[j].equals(""))
					arr.add(new BigInteger(s[j]));
			}
		}
		arr.sort(null);
		for(BigInteger val : arr)
			sb.append(val).append('\n');
		System.out.println(sb);
	}
}
