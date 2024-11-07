package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int num;
			if((num=Integer.parseInt(st.nextToken())) == -1) break;
			int ans = 0;
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(num);
			while((num=Integer.parseInt(st.nextToken())) != 0) {
				arr.add(num);
			}
			
			Collections.sort(arr);
			for(int i = 0; i<arr.size()-1; i++) {
				for(int j = i+1; j<arr.size(); j++) {
					if(arr.get(i)*2 == arr.get(j)) {
						ans++;
						//System.out.println(arr.get(i) + " " + arr.get(j));
						break;
					}
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
