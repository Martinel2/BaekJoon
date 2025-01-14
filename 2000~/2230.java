package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n,m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        //음수인 경우와 양수인 경우 모두 존재
       
        long[] arr = new long[n];
        long ans = Long.MAX_VALUE;
        int neg = 0;
        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	if(arr[i] < 0) neg++;
        }
        Arrays.sort(arr);
        
        boolean match = false;
        //양수인 것끼리 두 포인터 
        int left = 0 + neg;
        int right = left+1;
        while(left<=right && right < n) {
        	long abs = arr[right] - arr[left];
        	
        	//차이가 m이하인 경우 차이를 증가시켜야함
        	if(abs < m) right++;
        	else if(abs == m) {
        		ans = abs;
        		match = true;
        		break;
        	}
        	else {
        		if(ans > abs) ans = abs;
        		left++;
        	}
        }

        //음수인 것과 양수의 최소갑부터 두포인터
        left = 0;
        right = neg;
        while(left<=right && right < n) {
        	long abs = arr[right] - arr[left];
        	
        	//차이가 m이하인 경우 차이를 증가시켜야함
        	if(abs < m) right++;
        	else if(abs == m) {
        		ans = abs;
        		match = true;
        		break;
        	}
        	else {
        		if(ans > abs) ans = abs;
        		left++;
        	}
        }

        
        //음수끼리 두 포인터
        left = 0;
        right = left+1;
        while(left<=right && right<neg) {
        	long abs = arr[right] - arr[left];
        	
        	//차이가 m이하인 경우 차이를 증가시켜야함
        	if(abs < m) right++;
        	else if(abs == m) {
        		ans = abs;
        		match = true;
        		break;
        	}
        	else {
        		if(ans > abs) ans = abs;
        		left++;
        	}
        }
        
        System.out.println(ans);
    }
}
