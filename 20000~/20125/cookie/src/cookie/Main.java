package cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N= Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		for(int i = 0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int hx=0, hy=0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(board[i][j] == '*') {
					hx = j;
					hy = i+1;
					break;
				}
			}
			if(hy != 0)
				break;
		}
		
		//팔 길이 알아내기
		int lArm=0,rArm=0;
		for(int i = 0; i<N; i++) {
			if(board[hy][i] == '*') {
				lArm = hx - i;
				break;
			}
		}
		for(int i = N-1; i>hx; i--) {
			if(board[hy][i] == '*') {
				rArm = i-hx;
				break;
			}
		}
		
		//허리길이 알아내기
		int w=0;
		for(int i = hy+1; i<N; i++) {
			if(board[i][hx] == '*')
				w++;
			else
				break;
		}
		
		//다리길이 알아내기
		int lLeg=0,rLeg=0;
		for(int i = hy+w+1; i<N; i++) {
			if(board[i][hx-1] == '*')
				lLeg++;
			if(board[i][hx+1] == '*')
				rLeg++;
		}
		
		
		System.out.println((hy+1) + " " + (hx+1));
		System.out.println(lArm + " " + rArm + " " + w + " " + lLeg + " " + rLeg);
	}
}

/*
5
_____
__*__
_***_
__*__
_*_*_

10
__________
_____*____
__******__
_____*____
_____*____
_____*____
____*_*___
____*_____
____*_____
____*_____
 */
