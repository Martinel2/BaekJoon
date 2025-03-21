package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] op; // + , - , * , / 순으로 저장
	static int[] arr;
	static int n;
	static long max = Integer.MIN_VALUE;
	static long min = Integer.MAX_VALUE;
	
	static void bt(int idx, long sum) {
		if(idx == n) {
			max = Math.max(sum, max);
			min = Math.min(min, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			//System.out.println("idx="+idx+"  op list : "+op[0] + " "+op[1]+" "+op[2]+" "+op[3]);
			if(op[i] <= 0) continue;
			
			if(i==0) {
				//System.out.println("sum + arr[idx] = "+(sum+arr[idx]));
				op[i]--;
				bt(idx+1,sum+arr[idx]);
				op[i]++;
			}
			if(i==1) {
				op[i]--;
				bt(idx+1,sum-arr[idx]);
				op[i]++;
			}
			if(i==2) {
				op[i]--;
				bt(idx+1,sum*arr[idx]);
				op[i]++;
			}
			if(i==3) {
				//System.out.println("idx="+idx+"  sum / arr[idx] = "+(sum/arr[idx]));
				op[i]--;
				bt(idx+1,sum/arr[idx]);
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	op[i] = Integer.parseInt(st.nextToken());
        }
        
        bt(1,arr[0]);
        
        System.out.println(max);
        System.out.println(min);
    }
}