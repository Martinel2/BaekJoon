import java.io.*;
import java.util.*;

public class ddd {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//최소값 = 두개 비교해서 더 작은 걸로
		char[][] larr = {
				{'q','w','e','r','t'},
				{'a','s','d','f','g'},
				{'z','x','c','v','0'},
		};
		char[][] rarr= {
				{'y','u','i','o','p'},
				{'h','j','k','l','0'},
				{'b','n','m','0','0'}
		};
		char left = st.nextToken().charAt(0);
		char right = st.nextToken().charAt(0);
		//왼쪽의 x,y인덱스, 오른쪽의 인덱스
		int lx = 0, rx=0, ly=0, ry=0;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				if (larr[i][j]==left || rarr[i][j] == left) {
					lx=i;
					ly=j;
				}
				if (rarr[i][j]==right || larr[i][j] == right) {
					rx=i;
					ry=j;
				}
			}
		}
		
		String str = br.readLine();
		
		int dist =str.length(); // 누르는 시간 미리 더하기
		
		for (int i=0; i<str.length();i++) {
			char temp=str.charAt(i);
			
			//키보드 위치 찾기
			Loop :for (int k=0; k<3; k++) {
				for (int j=0; j<5; j++) {
					//왼손으로
					if (larr[k][j]==temp) {
						int ldist=Math.abs(lx-k) + Math.abs(ly-j); //손가락 이동시간
						 dist+=ldist; 
						 lx=k;
						 ly=j;
						 break Loop;
					}
					//오른손으로
					else if(rarr[k][j]==temp) {
						int rdist=Math.abs(rx-k) + Math.abs(ry-j); //손가락 이동시간
						dist+=rdist;
						 rx=k;
						 ry=j;
						 break Loop;
					}
				}
			}		
		}
		System.out.println(dist);
	}
}