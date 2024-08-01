package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st= new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        
        long[] monster = new long[n];
        long[] weapon = new long[n];
        
        int maxm = 0;
        int maxw = 0;
        Arrays.fill(monster, 1234567890L);
        Arrays.fill(weapon, 1234567890L);
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int type = Integer.parseInt(st.nextToken());
        	long power = Long.parseLong(st.nextToken());
        	
        	if(type == 1) monster[maxm++] = power;
        	else weapon[maxw++] = power;
        }
        
        Arrays.sort(monster);
        Arrays.sort(weapon);
        
        int ans = 0;
        int midx = 0;
        int widx = 0;
        while(midx < maxm) {
        	if(monster[midx] < p) {
        		ans++;
        		p += monster[midx++];
        	}
        	else {
        		if(widx < maxw) {
        			ans++;
        			p *= weapon[widx++];
        		}
        		else break;
        	}
        }
        if(widx < maxw) {
        	ans += maxw - widx;
        }
        System.out.println(ans);
    }
}