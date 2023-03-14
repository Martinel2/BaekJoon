package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		
		int Tlen = T.length();
		int Plen = P.length();
		int cnt = 0;
		int[] f = new int[Plen];
		int begin = 1, m = 0;

		// 끝까지 확인한다.
		while(begin+m < Plen) {
		    // 일치하면 m을 증가시키고 실패함수를 초기화한다.
		    if(P.charAt(begin+m)==P.charAt(m)) {
		        m++;
		        f[begin+m-1] = m;
		    }
		    else {
		        if(m==0)//시작부터 불일치
		           begin++;
		        else {//일치하는 부분부터 다시 시작
		           begin += (m - f[m-1]);
		           m = f[m-1];
		        }
		    }
		}
		begin = 0; m = 0;
		while(begin <= Tlen-Plen) {
			if(m<Plen && T.charAt(begin+m) == P.charAt(m)) {//일치하면 m을 증가
				m++;
				
				if(m == Plen) {//완전일치할때
					cnt++;
					sb.append(begin+1).append("\n");
				}
			}
			else {//불일치할때
				if(m==0)//시작부터 불일치
					begin++;
				else {//일치하는 접두사부터 다시 시작
					begin += m-f[m-1];
					m = f[m-1];
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
