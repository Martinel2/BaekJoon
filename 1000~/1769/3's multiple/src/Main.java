import java.io.*;
import java.util.*;


//1769 3ÀÇ ¹è¼ö
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int cnt = 0;
		while(0 == N || N >= 10)
		{
			sum = 0;
			while(N>0)
			{
				sum += N%10;
				N/=10;
			}
			cnt++;
			N=sum;
		}
		if(sum == 3 || sum == 6 || sum == 9)
			System.out.print(cnt + "\nYES");
		else
			System.out.print(cnt + "\nNO");
		
	}
}