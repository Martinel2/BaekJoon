import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//16967 �迭 �����ϱ�
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int H,W,X,Y;
		H = Integer.parseInt(st.nextToken()); // ù�迭�� ��
		W = Integer.parseInt(st.nextToken()); // ù�迭�� ��
		X = Integer.parseInt(st.nextToken()); // �þ�� ���� ��
		Y = Integer.parseInt(st.nextToken()); // �þ�� ���� ��
		
		int[][] B = new int[H+X][W+Y];
		int[][] A = new int[H][W];
		
		//(H+X)x(W+Y)�迭 ����
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
			else { //��������
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
