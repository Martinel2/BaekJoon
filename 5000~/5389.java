package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        //n^2+i^2 = rem^2
        //n^2 = rem^2 - i^2
        while(t-->0) {
        	int n=Integer.parseInt(br.readLine());
        	int mina = Integer.MAX_VALUE;
        	int minb = Integer.MAX_VALUE;
        	boolean exist = false;
        	for (int i = 1; i*i <= n; i++) {
                if (n%i != 0) continue;
                int diff = i;
                int sum = n/i;
                if ((sum+diff)%2 != 0) continue;
                exist = true;
                int r = (sum+diff)/2;
                int l = r-diff;
                if(mina > l) {
                	mina = l;
                	minb = r;
                }
            }
        	if(exist)
        		sb.append(mina).append(" ").append(minb).append('\n');
        	else
        		sb.append("IMPOSSIBLE\n");
        }
        
        System.out.println(sb);
    }
}