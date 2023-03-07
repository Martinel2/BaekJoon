package chainsawman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,M,F;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //����
		M = Integer.parseInt(st.nextToken()); //����
		F = Integer.parseInt(st.nextToken()); //���� ũ��
		
		char[][] wood = new char[N][M];
		int ans = 0;
		for(int i = 0; i<N; i++) {
			wood[i] = br.readLine().toCharArray();
		}
		
		//������
		if(N > 1) {
			for(int i = 1; i<N; i++) {
				//i��°�� i+1��°�� ��
				int wcnt = 0; // #and.
				int stridx = -1;
				
				for(int j = 0; j<M; j++) {
					if((wood[i-1][j] == '.' && wood[i][j] == '#') || 
							(wood[i-1][j] == '#' && wood[i][j] == '.')) {
						if(stridx == -1)
							stridx = j;
						wcnt++;
					}
					else if(wood[i-1][j] == '.' && wood[i][j] == '.') {
						if(stridx == -1)
							stridx = j;
					}
					//�ڸ���
					else {
						//���� F�� ��밡���Ҷ�
						if(stridx == 0 && F < wcnt) {
							ans += F;
						}
						else
							ans += wcnt;
						stridx = -1;
						wcnt = 0;
					}		
				}
				//�������� �������� F��밡��
				if(wcnt > 0) {
					if(F< wcnt)
						ans += F;
					else
						ans += wcnt;
				}
			}
		}
		//������
		if(M > 1) {
			for(int j = 1; j<M; j++) {
				//j��°�� j+1��°�� ��
				int wcnt = 0; // #and.
				int stridx = -1;
				
				for(int i = 0; i<N; i++) {
					if((wood[i][j-1] == '.' && wood[i][j] == '#') || 
							(wood[i][j-1] == '#' && wood[i][j] == '.')) {
						if(stridx == -1)
							stridx = i;
						wcnt++;
					}
					else if(wood[i][j-1] == '.' && wood[i][j] == '.') {
						if(stridx == -1)
							stridx = i;
					}
					//�ڸ���
					else {
						//���� F�� ��밡���Ҷ�
						if(stridx == 0 && F < wcnt) {
							ans += F;
						}
						else
							ans += wcnt;
						stridx = -1;
						wcnt = 0;
					}		
				}
				//�������� �������� F��밡��
				if(wcnt > 0) {
					if(F< wcnt)
						ans += F;
					else
						ans += wcnt;
				}
			}
		}
		System.out.println(ans);
	}
}
/*
4 5 1
#....
#....
#####
#...#
*/