import java.io.*;


//9663 N-Queen
public class Main {
	
	static int[] board;
	static int cnt = 0;
	static int N;
	
	static void nqueen(int c) {
		if(c == N) {
			cnt++;
			return;
		}
		else {
			for(int i = 0; i<N; i++) {
				board[c] = i;
				boolean flag = true;
				for(int j = 0; j<c; j++) {
					if(board[c] == board[j] || c-j == Math.abs(board[c]-board[j])) {
						flag = false;
						break;
					}
				}
				if(flag) {
					nqueen(c+1);
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		nqueen(0);
		System.out.println(cnt);
	}
}