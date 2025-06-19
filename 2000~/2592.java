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
		
		int sum = 0;
		int max = 0;
		int fre = 0;
		int[] arr = new int[100];
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num/10]++;
			sum += num;
			if(max < arr[num/10]) {
				max = arr[num/10];
				fre = num;
			}
		}
		System.out.println(sum/10);
		System.out.println(fre);
    }
}