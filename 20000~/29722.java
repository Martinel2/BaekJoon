package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), "-");
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		
		if(d+n > 30) {
			int cm = 0;
			int sumd = d+n;
			while(sumd > 30){
				sumd -= 30;
				cm++;
			}
			d = sumd;
			if(cm + m > 12) {
				int cy = 0;
				int summ = cm+m;
				while(summ > 12) {
					summ -= 12;
					cy++;
				}
				m = summ;
				y += cy;
			}else m += cm;
		}else d = d+n;
		
		String ans = "";
		ans += String.valueOf(y) + "-";
		ans += m < 10 ? "0"+String.valueOf(m)+"-":String.valueOf(m)+"-";
		ans += d < 10 ? "0"+String.valueOf(d):String.valueOf(d);
		System.out.println(ans);
	}	
}