import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int diffCount;
		int[] alpa = new int[26];
		int[] temp;
		
		int N = Integer.parseInt(br.readLine());
		
		// 기준이 되는 단어
		String firstWord = br.readLine();
		int len = firstWord.length();
		
		for(int i = 0; i < len; i++) {
			int w = (int) firstWord.charAt(i) - 'A';
			alpa[w]++;
		}
		
		for(int i = 0; i < N-1; i++) {
			// 배열복사(깊은 복사)
			temp = alpa.clone();
			diffCount = 0;
			String words = br.readLine();
			int lenW = words.length();
			for(int j = 0; j < lenW; j++) {
				int c = (int) words.charAt(j) - 'A';
				
				if(temp[c] > 0) {
					temp[c]--;
				} else {
					diffCount++;
				}
			}
			if(len > lenW) {
				diffCount += len - lenW;
			}
			
			if(((len - lenW == 0) || (Math.abs(len - lenW) == 1)) && (diffCount == 0 || diffCount == 1)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}