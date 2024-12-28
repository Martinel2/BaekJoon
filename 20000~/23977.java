package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // p = nq + r
        // n-r = k
        // n-k = r
        // p = nq + (n-k)
        // p = n(q+1) - k
        // 배열 a의 최소 공배수에서 k를 뺀 것이 비밀번호
        st = new StringTokenizer(br.readLine());
        long ans = Long.parseLong(st.nextToken());
        for(int i=1; i<n; i++) {
        	long b = Long.parseLong(st.nextToken());
        	ans = (ans * b) / gcd(ans,b); 
        }
        ans -= k;
        System.out.println(ans);
    }

    public static long gcd(long a, long b) {
		if(b != 0) return gcd(b, a%b);
		else return a;
	}
	
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}