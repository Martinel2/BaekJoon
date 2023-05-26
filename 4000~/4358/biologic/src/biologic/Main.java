package biologic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> D = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		double total = 0;
		String s = br.readLine();
		while(s != null) {
			total++;
			D.put(s, D.getOrDefault(s, 0)+1);
			s = br.readLine();
		}
		Object[] keys = D.keySet().toArray();
		Arrays.sort(keys);
		for(int i = 0; i<keys.length; i++) {
			String name = (String)keys[i];
			double percent = (D.get(name)/total)*100;
			sb.append(name).append(" ").append(String.format("%.4f", percent)).append("\n");
		}
		System.out.println(sb);
	}
}
