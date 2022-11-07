import java.io.*;



//17218 비밀번호 만들기
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int Alen = A.length();
		int Blen = B.length();
		String[][] dp = new String [Alen][Blen];
		for(int i = 0; i<Alen; i++){
			for(int j = 0; j<Blen; j++)
				dp[i][j] = "";
		}
		boolean f = false;
		for(int i = 0; i<Alen; i++){
			if(A.charAt(i) == B.charAt(0) || f) {
				f = true;
				dp[i][0] += B.charAt(0);
			}
		}
		f = false;
		for(int i = 0; i<Blen; i++){
			if(B.charAt(i) == A.charAt(0) || f) {
				f = true;
				dp[0][i] += A.charAt(0);
			}
		}
		for(int i = 1; i<Alen; i++) {
			for(int j = 1; j<Blen; j++) {
				if(A.charAt(i) == B.charAt(j))
					dp[i][j] = dp[i-1][j-1] + B.charAt(j);
				else {
					if(dp[i-1][j].length() < dp[i][j-1].length())
						dp[i][j] = dp[i][j-1];
					else
						dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[Alen-1][Blen-1]);
	}
}