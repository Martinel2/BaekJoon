package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());

    	int[] sub = new int[n];
    	int ans = 0;
    	st= new StringTokenizer(br.readLine());
    	int f = Integer.parseInt(st.nextToken());
		
    	for(int i = 1; i<n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		sub[i] =(num - f);
    		f = num;
    	}
    	
    	//조가 사람 수만큼 존재하면 비용은 0
    	//조가 사람 수보다 적게 존재하는 경우 
    	//인접한 사람의 키의 차의 합이 최소인 부분을 만들어야 함
    	if(n != k) {
    		Arrays.sort(sub);
    		for(int i = 1; i<=n-k; i++) {
    			ans += sub[i];
    			//System.out.println(sub[i]);
    		}
    	}
    	
    	System.out.println(ans);
    }
}