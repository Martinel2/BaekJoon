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
		
		String s = "";
		String a = "";
		int ans = 0;
		while((s=br.readLine()) != null) a += s;
		
		st = new StringTokenizer(a,",");
		int len = st.countTokens(); //현재남은 nextToken의 갯수
		for(int i = 0; i<len; i++) {
			ans += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(ans);
	}
}
