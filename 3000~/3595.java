package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int a=0,b=0,c=0;
		int min = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i * i * i <= n; i++) {
            if (n % i == 0) {
                for (int j = i; j * j <= n / i; j++) {
                    if (n / i % j == 0) {
                        int k = n / i / j, val = i * j + j * k + i * k;
                        if (min > val) {
                            min = val;
                            a = i;
                            b = j;
                            c = k;
                        }
                    }
                }
            }
        }
		System.out.println(a+" "+b+" "+c);
	}
}