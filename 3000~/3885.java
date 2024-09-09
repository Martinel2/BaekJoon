package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        while(n != 0 || w != 0) {
        	int len = (int)Math.floor(100/w) + 1;
        	int[] count = new int[len];
        	int max = 0;
        	int height = 0;
        	//0~w-1, w~2w-1, 2w~3w-1 ...
        	//구간별 횟수 세기
        	for(int i = 0; i<n; i++) {
        		int num = Integer.parseInt(br.readLine());
        		num = num/w;
        		count[num]++;
        		max= Math.max(max, num);
        		height = Math.max(height, count[num]);
        	}
        	// 1*(1/2) + (1/2)*0 + 0*1 +0.01 = 0.51
        	// 1*(0) + (1/2)*(1/2) + 0*1 + 0.01 = 0.26
        	//잉크 양 계산
        	double ans = 0;
        	double per = max;
        	for(int i = 0; i<=max; i++) {
    			double r = per/max;
    			double c = (double)count[i]/height;
    			//System.out.println(r+" "+c+" "+ r*c);
    			ans += r*c;
        		per--;
        	}
        	ans += 0.01;
        	sb.append(ans).append('\n');
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}