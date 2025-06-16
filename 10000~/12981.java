package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//26 17...2 21...1
		//26+17+21+2=
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        int cnt = arr[0];
        arr[1]-=arr[0];
        arr[2]-=arr[0];
        
        cnt += arr[1]/3 + arr[2]/3;
        cnt += arr[1]%3!=0 ? 1 : 0;
        cnt += arr[2]%3!=0 ? 1 : 0;
        
        if (arr[1]%3 == 1 && arr[2]%3 == 1)
            cnt--;
        System.out.println(cnt);
    }
}