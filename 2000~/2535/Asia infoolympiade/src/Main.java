import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class info implements Comparable<info>{
		int nation;
		int stuNo;
		int grade;
		
		info(int nation, int stuNo, int grade){
			this.nation = nation;
			this.stuNo = stuNo;
			this.grade = grade;
		}
		
		@Override
		public int compareTo(info o) {
			return o.grade - this.grade;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		info[] arr = new info[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int nation = Integer.parseInt(st.nextToken());
			int stuNo = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[i] = new info(nation,stuNo,grade);
		}
		Arrays.sort(arr);
		int gold,silver;
		
		gold = arr[0].nation;
		silver = arr[1].nation;
		
		sb.append(arr[0].nation+" "+arr[0].stuNo).append('\n');
		sb.append(arr[1].nation+" "+arr[1].stuNo).append('\n');
		
		if(gold == silver) {
			for(int i = 2; i<N; i++) {
				if(silver != arr[i].nation){
					sb.append(arr[i].nation+" "+arr[i].stuNo);
					break;
				}
			}
		}
		else sb.append(arr[2].nation+" "+arr[2].stuNo);
		
		System.out.println(sb);
	}
}
