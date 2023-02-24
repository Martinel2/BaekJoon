import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//16967 배열 복원하기
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int H,W,X,Y;
		H = Integer.parseInt(st.nextToken()); // 첫배열의 행
		W = Integer.parseInt(st.nextToken()); // 첫배열의 열
		X = Integer.parseInt(st.nextToken()); // 늘어나는 행의 수
		Y = Integer.parseInt(st.nextToken()); // 늘어나는 열의 수
		
		int[][] B = new int[H+X][W+Y];
		int[][] A = new int[H][W];
		
		//(H+X)x(W+Y)배열 제공
		for(int i = 0; i<H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<H; i++) {
			if(i<X) {
				for(int j = 0; j<W; j++) {
					A[i][j] = B[i][j];
				}
			}
			else { //마지막줄
				for(int j = 0; j<Y; j++)
					A[i][j] = B[i][j];
				for(int j = Y; j<W; j++) {
					A[i][j] = B[i][j] - A[i-X][j-Y];
				}
			}
		}
		for(int i = 0; i<H; i++) {
			for(int val : A[i])
				System.out.print(val+" ");
			System.out.println();
		}
	}
}
