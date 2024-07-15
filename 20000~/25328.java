package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	static String[] xyz = new String[3];
	static int com;
	static HashMap<String, Integer> hs = new HashMap<>();
	static void back(String now, int idx, int cnt) {
		if(com == now.length()) {
			hs.put(now, hs.getOrDefault(now, 0)+1);
		}
		else {
			for(int i =cnt; i<xyz[idx].length(); i++) {
				back(now+xyz[idx].charAt(i),idx,i+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		xyz[0] = br.readLine();
		xyz[1] = br.readLine();
		xyz[2] = br.readLine();
		
		com = Integer.parseInt(br.readLine());
		for(int i = 0; i<3; i++) {
			back("", i,0);
		}
		
		ArrayList<String> al = new ArrayList<>();
		for(String val : hs.keySet()) {
			if(hs.get(val) >= 2) {
				al.add(val);
			}
		}
		if(al.size() > 0) {
			Collections.sort(al);
			for(String val : al)
				sb.append(val).append('\n');
			System.out.println(sb);
		}
		else System.out.println(-1);
	}
} 