package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
       
        int[][] arr = new int[n][2];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++) {
        	double a = Double.parseDouble(st.nextToken());
        	int press = (int)(a*10)%10;
        	int push = (int)(a * 10) / 10;
        	//System.out.println(push + " " + press);
        	arr[i][0] = push;
        	arr[i][1] = press == 5? 1:0;
        }
        
        int ans = arr[0][0] + arr[0][1];
        for(int i = 1; i<n; i++) {
        	if(ans == 0 && arr[i][1] > 0) {
        		ans++;
        	}
        	//System.out.println(arr[i][0]);
        	ans += arr[i][0];
        }
        System.out.println(ans);
    }
}