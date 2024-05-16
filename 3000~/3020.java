package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        long[] top = new long[h+1];
        long[] bottom = new long[h+1];
        
        long min = Long.MAX_VALUE;
        int cnt = 1;
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(i % 2 !=0) { //석순인 경우
        		bottom[num]++;
        	}
        	else {
        		top[num]++;
        	}
        }
        
        for(int i = h-1; i>=1; --i) {
        	top[i] += top[i+1];
        	bottom[i] += bottom[i+1];
        }
        
        long[] ans = new long[h+1];
        for(int i =1; i<=h; i++) {
        	// 높이 - 종유석의 길이 = 종유석에서 바닥까지의 거리
        	ans[i] = top[h-i+1] + bottom[i];
        	if(min > ans[i]) {
        		min = ans[i];
        		cnt = 1;
        	}
        	else if(min == ans[i]) cnt++;
        }
        
        System.out.println(min + " " + cnt);
        
    }
}