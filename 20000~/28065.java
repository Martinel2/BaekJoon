package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int n = Integer.parseInt(br.readLine());
    	
    	// 이전 수와의 차 > 다음 수와의 차
    	//5 1 4 2 3
    	//4 3 2 1
    	//큰수 작은수 큰수 작은 수
    	
    	int left = 1;
    	int right = n;
    	while(left<=right) {
    		sb.append(right).append(" ");
    		right--;
    		if(left>right) break;
    		sb.append(left).append(" ");
    		left++;
    	}
    	System.out.println(sb);
    }
}