package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr =new int[n+1];
        int cnt = 0;
        ArrayList<Integer> al = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i  =0; i<=n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	
        	if(arr[i] > 0) al.add(i);
        	if(arr[i] == 1) cnt++;
        }
        
        int dice = Integer.parseInt(br.readLine());
        
        boolean safe = false;
        for(int m : al) {
    		if(m+dice > n) continue;
        	if(arr[m] == 1) {
        		if(arr[m+dice] == 1) {
        			cnt-=2;
        			if(cnt != 0) break;
        		}
        		else if(arr[m+dice] + 1 >= 2) {
        			cnt--;
        			if(cnt != 0) break;
        		}
        		
        	}
        	else if(arr[m+dice] + 1 >= 2 && arr[m]-1 >= 2) {
        		//3개 이상인 곳에서 움직이는 경우
        		//3 1 -> 2 2가 된다면
        		if(arr[m+dice] == 1) {
        			cnt-=1;
        			if(cnt != 0) break;
        		}
        		
        		//3 2 -> 2 3이 되는 경우는 변화가 없으니 생략
        	} else continue;
        	if(cnt==0) {
    			safe = true;
    			System.out.println("YES");
    			System.out.println(m + " " + (m+dice));
    			break;
    		}
        }
        if(!safe) System.out.println("NO");
	}
}