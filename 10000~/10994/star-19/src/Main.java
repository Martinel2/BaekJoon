import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static void star(int n) {
		for(int i = 4; i<=(4*n); i++) {
			
			//상하 뚜껑
			if(i == 4 || i == 4*n) {
				//가장자리
				for(int j = 0; j<N-n; j++) 
					System.out.print("* ");
				
				for(int j = 4; j<1+(4*n); j++) {
					System.out.print("*");
				}
				
				//가장자리
				for(int j = 0; j<N-n; j++) 
					System.out.print(" *");
			}
			else if(i == 6) {
				star(n-1);
			}
			else {
				//가장자리
				for(int j = 0; j<N-n; j++) 
					System.out.print("* ");
				
				System.out.print("*");
				for(int j = 4; j<(4*n)-1; j++)
					System.out.print(" ");
				System.out.print("*");
				
				//가장자리
				for(int j = 0; j<N-n; j++) 
					System.out.print(" *");
			}
			
			if(i == 6) {
				i = (4*n)-2;
			}
			else
				System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		star(N);
	}
}
