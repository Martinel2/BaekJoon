package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static String getSpace(int count) {
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < count; i++) sbs.append(" ");
        return sbs.toString();
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		
		if(n%2 == 0) {
			sb.append("I LOVE CBNU");
		}else {
			for (int i = 0; i < n; i++) sb.append("*");
            sb.append("\n");
            int c = Math.round(n / 2) + 1;
            for (int i = 0; i < c; i++) {
                if (i == 0) sb.append(getSpace(n / 2) + "*\n");
                else {
                    int center = (i == 1) ? i : i * 2 - 1;
                    sb.append(getSpace(n / 2 - i) + "*" + getSpace(center) + "*\n" );
                }
            }
		}
		System.out.println(sb);
	}
}