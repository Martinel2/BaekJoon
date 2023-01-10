import java.io.*;
import java.util.*;

//1063 킹
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int size = 8;
		int[][] arr = new int[8][8];
		
		st = new StringTokenizer(br.readLine(), " ");
		String k = st.nextToken();
		String d = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		int krow = (k.charAt(0)-'A');
		int kcol = size - (k.charAt(1)-'0');
		arr[kcol][krow] = 1;
		int drow = (d.charAt(0)-'A');
		int dcol = size - (d.charAt(1)-'0');
		arr[dcol][drow] = 2;
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			//오른쪽으로
			if(s.equals("R")) {
				int kx = kcol;
				int ky = krow + 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if(0<=drow+1 && drow+1<8) {
							arr[dcol][drow] = 0;
							drow += 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//왼쪽으로
			if(s.equals("L")) {
				int kx = kcol;
				int ky = krow - 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if(0<=drow-1 && drow-1<8) {
							arr[dcol][drow] = 0;
							drow -= 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//아래로
			if(s.equals("B")) {
				int kx = kcol+1;
				int ky = krow;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if(0<=dcol+1 && dcol+1<8) {
							arr[dcol][drow] = 0;
							dcol += 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//위로
			if(s.equals("T")) {
				int kx = kcol-1;
				int ky = krow;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if(0<=dcol-1 && dcol-1<8) {
							arr[dcol][drow] = 0;
							dcol -= 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//오른쪽위로
			if(s.equals("RT")) {
				int kx = kcol-1;
				int ky = krow + 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if((0<=dcol-1 && dcol-1<8) && (0<=drow+1 && drow+1<8)) {
							arr[dcol][drow] = 0;
							dcol -= 1; drow += 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//왼쪽위로
			if(s.equals("LT")) {
				int kx = kcol-1;
				int ky = krow - 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if((0<=dcol-1 && dcol-1<8) && (0<=drow-1 && drow-1<8)) {
							arr[dcol][drow] = 0;
							dcol -= 1; drow -= 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//오른쪽 아래로
			if(s.equals("RB")) {
				int kx = kcol+1;
				int ky = krow + 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if((0<=dcol+1 && dcol+1<8) && (0<=drow+1 && drow+1<8)) {
							arr[dcol][drow] = 0;
							dcol += 1; drow += 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
			//왼쪽 아래로
			if(s.equals("LB")) {
				int kx = kcol+1;
				int ky = krow - 1;
				if((0<=kx && kx<8) && (0<=ky && ky<8)) {
					if(dcol == kx && drow == ky) {
						if((0<=dcol+1 && dcol+1<8) && (0<=drow-1 && drow-1<8)) {
							arr[dcol][drow] = 0;
							dcol += 1; drow -= 1;
							arr[dcol][drow] = 2;
							arr[kcol][krow] = 0;
							arr[kx][ky] = 1;
							kcol = kx;  krow = ky;
						}
					}
					else {
						arr[kcol][krow] = 0;
						arr[kx][ky] = 1;
						kcol = kx;  krow = ky;
					}
				}
			}
		}
		char anskrow = (char)(krow + 'A');
		char ansdrow = (char)(drow + 'A');
		System.out.print(anskrow + "" + (size-kcol) + "\n" + ansdrow + "" + (size-dcol) );
	}
}

