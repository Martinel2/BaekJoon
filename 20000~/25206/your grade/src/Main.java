import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//25206 너의 평점은
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double time = 0;
		double sum = 0;
		
		for(int i = 0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			String sub = st.nextToken();
			double grade = Double.parseDouble(st.nextToken());
			String S = st.nextToken();
			
			if(S.equals("P"))
				continue;
			else{
				time += grade;
				if(S.equals("A+")) {
					sum += grade*4.5;
				}
				else if(S.equals("A0")) {
					sum += grade*4.0;
				}
				else if(S.equals("B+")) {
					sum += grade*3.5;
				}
				else if(S.equals("B0")) {
					sum += grade*3.0;
				}
				else if(S.equals("C+")) {
					sum += grade*2.5;
				}
				else if(S.equals("C0")) {
					sum += grade*2.0;
				}	
				else if(S.equals("D+")) {
					sum += grade*1.5;
				}
				else if(S.equals("D0")) {
					sum += grade*1.0;
				}			
			}
		}
		System.out.printf("%.6f",sum/time);
	}
}
