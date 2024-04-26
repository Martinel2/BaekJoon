package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        long[][] num = new long[65][11];
        
        for(int i=0; i<10; i++) {
        	num[1][i] = 1;
        }
        num[1][10] = 10;
        
        for(int i =2; i<=64; i++) {
        	num[i][0] = num[i-1][10];
        	long sum = num[i][0];
        	for(int j = 1; j<10; j++) {
        		//System.out.println(num[i][j-1]+" - "+num[i-1][j-1]);
        		num[i][j] = num[i][j-1] - num[i-1][j-1];
        		sum += num[i][j];
        	}
        	num[i][10] = sum;
        }
        
        // 0 0~9, 1 1~9, 2 2~9 ... 99
        // 0 (0 0~9, 1 1~9... 99) 1 (1 1~9, 2 2~9, ... 99)
        while(t-->0) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(num[n][10]).append('\n');
        }
        System.out.println(sb);
	}
}