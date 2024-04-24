package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int str = 0;
        int end = 0;
        int[] cnt = new int[100001];
        while(end < arr.length) {
        	while(end < arr.length && cnt[arr[end]] + 1 <= k) {
        		cnt[arr[end]]++;
        		end++;
        	}
        	int len = end-str;
        	ans = Math.max(ans, len);
        	cnt[arr[str]]--;
        	str++;
        }
        System.out.println(ans);
	}
}