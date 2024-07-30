package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //0~40 중 X를 골라서 BX만큼 수면
        //이후부터는 과제하나에 40-X만큼의 시간만 소요
        //기한 - 자는 시간(BX)-이전에 과제를 한 시간 >= (A-X)이면 과제 완료가능
        //과제를 하고 자는 경우, 과제하기전에 자는 경우
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
       
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++) {
        	arr[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int ans = 0;
        for(int x = 0; x<A; x++) {
        	int sleep = B * x;
        
        	for(int i = 0; i<n; i++) {
        		int j = 0;
        		int time = 0;
            	int max = 0;
        		for(j = 0; j<i; j++) {
        			if(time+A <= arr[j]) {
            			time += A;
            			max++;
            		}
        			else break;
        		}
        		time += sleep;
        		//System.out.println("sleep"+time + " "+ max);
        		for(int k = j; k<n; k++) {
        			if(time+(A-x) <= arr[k]) {
        				max++;
        				time += (A-x);
        			}
        			else break;
        		}
        		//System.out.println(max + " " + time);
        		ans = Math.max(max, ans);
        	}
        }
        System.out.println(ans);
    }
}