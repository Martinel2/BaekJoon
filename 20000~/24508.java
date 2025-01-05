package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
	        int[] arr = new int[n];
	        st = new StringTokenizer(br.readLine());
	        int notZeroCnt = 0;
	        for (int i = 0; i < n; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	            if (arr[i] != 0)
	                notZeroCnt++;
	        }
	        if (notZeroCnt == 0) {
	            System.out.println("YES");
	            return;
	        } else if (notZeroCnt == 1) {
	            System.out.println("NO");
	            return;
	        }
	        Arrays.sort(arr);
	        int low = n-notZeroCnt;
	        int high = n-1;
	        while (t>0 && low<high) {
	            int remain = k-arr[high];
	            if (arr[low] < remain) {
	                arr[high]+=arr[low];
	                t-=arr[low];
	                low++;
	            } else {
	                arr[high]+=remain;
	                arr[low]-=remain;
	                t-=remain;
	                high--;
	                if (arr[low]==0)
	                    low++;
	            }
	        }
	        System.out.println(low>high&&t>=0?"YES":"NO");
    }
}
