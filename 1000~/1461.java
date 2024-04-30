package solved;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        
        int n,m;
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(max < Math.abs(num)) {
        		max = Math.abs(num);
        	}
        	
        	if(num > 0)
        		pos.add(num);
        	else
        		neg.add(num);
        }
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);
        
        int i=0;
        while(i < neg.size()) {
        	int num = Math.abs(neg.get(i));
        	ans += num*2;
        	i+=m;
        }
        
        i=0;
        while(i < pos.size()) {
        	int num = pos.get(i);
        	ans += num*2;
        	i+=m;
        }
        ans -= max;
       
        System.out.println(ans);
    }
}