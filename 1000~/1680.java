package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
        	int w = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	
        	int[][] arr = new int[n][2];
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		arr[i][0] = Integer.parseInt(st.nextToken());
        		arr[i][1] = Integer.parseInt(st.nextToken());	
        	}
        	
        	int cnt = 0;
        	long ans = 0;
        	int weight = 0;

        	// 1 1(이동) 2(집감) 2(돌아와서실음) 1(이동) 3(집감) 3(다시옴) 3(집감) = 16
        	// 1(가득참) 1(집감)  1 1(이동)  2(집감)  2 1(이동)  3(집감) = 12 
        	while(cnt != n) {
    			//트럭이 가까운 쓰레기장으로 움직임
        		ans += arr[cnt][0];
    			if(cnt != 0) ans -= arr[cnt-1][0];
    			
    			//움직여서 온 쓰레기장의 쓰레기를 실을수있으면
        		if(weight + arr[cnt][1] <= w) {
        			weight += arr[cnt][1];
        		}
        		else { //넘치는경우
        			ans += arr[cnt][0]*2;
        			weight = arr[cnt][1];
        		}
        		if(weight == w && cnt+1 != n) { //가득 찬 경우 집갔다오기
    				ans += arr[cnt][0]*2;
    				weight = 0;
    			}
    			cnt++;
        	}
        	
        	ans += arr[cnt-1][0]; // 집으로 돌아오기
        	
        	sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}