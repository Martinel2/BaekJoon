import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[2];
		int[][] w = new int[2][2];
		int[] s = new int[2];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken())-1;
			
			String[] time = st.nextToken().split(":");
			int[] timeInt = new int[2];
			if(time[0].charAt(0) == '0')
				timeInt[0] = time[0].charAt(1) - '0';
			else
				timeInt[0] = Integer.valueOf(time[0]);
			
			if(time[1].charAt(0) == '0')
				timeInt[1] = time[1].charAt(1) - '0';
			else
				timeInt[1] = Integer.valueOf(time[1]);
			
			int winner = -1;
			if(s[0] > s[1]) {
				winner = 0;
			}
			else if(s[0] < s[1])
				winner = 1;
			else
				winner = -1;
			
			s[team]++;
			if(s[0] > s[1]) {
				if(winner == 0)
					continue;
				t[0] = timeInt[0];
				t[1] = timeInt[1];
				//System.out.println(t[0]+":"+t[1]);
			}
			else if(s[0] == s[1]) {
				winner = -1;
				if(team == 0) {
					int h = timeInt[0] - t[0];
					int m = 0;
					if(timeInt[1] - t[1] < 0) {
						h--;
						m = 60 - t[1] + timeInt[1];
					}
					else
						m = timeInt[1] - t[1];
					w[1][0] += h;
					w[1][1] += m;
					if(w[1][1] >= 60) {
						w[1][0]++;
						w[1][1] %= 60;
					}
				}
				else {
					int h = timeInt[0] - t[0];
					int m = 0;
					if(timeInt[1] - t[1] < 0) {
						h--;
						m = 60 - t[1] + timeInt[1];
					}
					else
						m = timeInt[1] - t[1];
					w[0][0] += h;
					w[0][1] += m;
					if(w[0][1] >= 60) {
						w[0][0]++;
						w[0][1] %= 60;
					}
				}
			}
			else {
				if(winner == 1)
					continue;
				t[0] = timeInt[0];
				t[1] = timeInt[1];
			}
			
		}
		
		if(s[0] > s[1]) {
			int h = 47 - t[0];
			int m = 60 - t[1];

			w[0][0] += h;
			w[0][1] += m;
			if(w[0][1] >= 60) {
				w[0][0]++;
				w[0][1] %= 60;
			}
		}
		else if(s[0] < s[1]) {
			int h = 47 - t[0];
			int m = 60 - t[1];
			
			w[1][0] += h;
			w[1][1] += m;
			if(w[1][1] >= 60) {
				w[1][0]++;
				w[1][1] %= 60;
			}
		}
		
		for(int i = 0; i<2; i++) {
			String hour = "";
			String min = "";
			if(w[i][0] < 10) {
				hour += '0' + String.valueOf(w[i][0]);
			}
			else {
				hour += String.valueOf(w[i][0]);
			}
			
			if(w[i][1] < 10) {
				min += '0' + String.valueOf(w[i][1]);
			}
			else {
				min += String.valueOf(w[i][1]);
			}
			
			System.out.println(hour+":"+min);
		}
	}
}
/*
5
1 01:10
1 02:20
2 45:30
2 46:40
2 47:50
*/
