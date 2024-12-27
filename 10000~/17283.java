package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int ans = 0;
        int l = 2;
        while(n*r/100 > 5) {
        	//System.out.println(n*r/100);
        	n = n*r/100;
        	ans += l*n;
        	l*=2;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}