package persia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class persia {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 0 0 0 0 입력시 무한루프 종료
			if(a == 0 && b == 0 && c == 0 && d == 0) break;
			
			//최소나이 최대나이 사이 공백 넣고 출력
			System.out.println((c - b) + " " + (d - a));
		}
	}
}
