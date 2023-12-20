package paint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dot = 46;
		int v = 124;
		int m = 45;
		int p = 43;
		
		char[][] arr = new char[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				arr[i][j] = '.';
			}
		}
		
		
		String s= br.readLine();
		
		int x=0,y=0;
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == 'U') {
				if(y !=0) {
					if(arr[y][x] == (char)m || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)v;
					y--;
					if(arr[y][x] == (char)m || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)v;
				}
			}
			else if(c == 'D') {
				if(y != N-1){	
					if(arr[y][x] == (char)m || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)v;
					y++;
					if(arr[y][x] == (char)m || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)v;
				}
			}
			else if(c == 'L') {
				
				if(x != 0){	
					if(arr[y][x] == (char)v || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)m;
					x--;
					if(arr[y][x] == (char)v || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)m;
				}
			}
			else {
				
				if(x != N-1){
					if(arr[y][x] == (char)v || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)m;
					x++;
					if(arr[y][x] == (char)v || arr[y][x] == (char)p)
						arr[y][x] = (char)p;
					else
						arr[y][x] = (char)m;
				}
			}
			
			/*for(int k = 0; k<N; k++) {
				for(char cs : arr[k])
					System.out.print(cs);
				System.out.println();
			}
			System.out.println();*/
			
		}
		
		for(int i = 0; i<N; i++) {
			for(char c : arr[i])
				System.out.print(c);
			System.out.println();
		}
	}
}
