package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        // 0 = ' ', 대문자 - 64 , 소문자 - 50
        
        int[] arr = new int[53];
        boolean lock = true;
        
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[num]++;
        }
        
        String s = br.readLine();
        for(int i = 0; i<s.length(); i++) {
        	char a = s.charAt(i);
        	if(a == ' ' && arr[0] > 0)
        		arr[0]--;
        	else if((65<= a && a <= 90) && arr[a-64] > 0)
        		arr[a-64]--;
        	else if(97<= a && arr[a-70] > 0)
        		arr[a-70]--;
        	else {
        		lock = false;
        		break;
        	}
        }
        
        char ans = lock? 'y':'n';
        System.out.println(ans);
        
    }
}
