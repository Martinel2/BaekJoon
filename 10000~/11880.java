package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int max = 0;
            for (int i = 0; i < 3; i++) {
                int cur = Integer.parseInt(st.nextToken());
                sum += cur;
                max = Math.max(max, cur);
            }
            sb.append(1l*max*max+1l*(sum-max)*(sum-max)).append('\n');
        }
        System.out.println(sb);
    }
}
