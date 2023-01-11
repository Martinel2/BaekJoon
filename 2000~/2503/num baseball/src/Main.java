import java.io.*;
import java.util.*;

//2503 숫자야구
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[1000];
		int cnt = 0;
		for(int i = 123; i<=987; i++) {
			if(i/100 == i/10%10) continue;
			else if(i/10%10 == i%10) continue;
			else if(i/100 == i%10) continue;
			
			if(i/10%10 == 0) continue;
			if(i%10 == 0) continue;
			
			arr[i] = true;
			cnt++;
		}
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int j = 123; j<=987; j++) {
				if(!arr[j]) continue;
				
				else {
					int stemp = 0;
					int btemp = 0;
					
					if(num/100 == j/100) 
						stemp++;
					else {
						if(num/10%10 == j/100)
							btemp++;
						else if(num%10 == j/100)
							btemp++;
					}
					
					if(num/10%10 == j/10%10) 
						stemp++;
					else {
						if(num/100 == j/10%10)
							btemp++;
						else if(num%10 == j/10%10)
							btemp++;
					}
					
					if(num%10 == j%10) 
						stemp++;
					else {
						if(num/10%10 == j%10)
							btemp++;
						else if(num/100 == j%10)
							btemp++;
					}
					
					if(strike != stemp || ball != btemp) {
						cnt--;
						arr[j] = false;
					}
				}
			}
		}
		
		System.out.print(cnt);
	}
}
