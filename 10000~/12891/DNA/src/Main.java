import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		int[] alpha = new int[26]; 
		int[] checkCnt = new int[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String dna = st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			checkCnt[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<p; i++) {
			int ascii = dna.charAt(i);
			int alphabet = ascii - 65;
			alpha[alphabet]++; 
		}
		int index = -1;
		while(p+index < dna.length()) {
		  index++;
		  if(alpha[0] >= checkCnt[0] && alpha[2] >= checkCnt[1] && alpha[6] >= checkCnt[2] && alpha[19] >= checkCnt[3]) {
		      answer++;
		  }
		  if(p+index < dna.length()) { // 인덱스 초과 에러 예방
			  int start = dna.charAt(index) -65;
			  alpha[start]--;
			  int end = dna.charAt(p+index) -65;
			  alpha[end]++;
		  }
		}
		System.out.println(answer);
	}
}