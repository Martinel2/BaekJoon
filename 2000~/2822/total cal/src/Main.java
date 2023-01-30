import java.io.*;
import java.util.*;

//2822 점수계산
public class Main {
	
	static class points implements Comparable<points>{
		int point = 0;
		int problem = 0;
		
		points(int point, int problem)
		{
			this.point = point;
			this.problem = problem;
		}
		
		@Override
		public int compareTo(points o) {
			return o.point - this.point;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		points[] tot = new points[8];
		boolean[] num = new boolean[9];
		for(int i = 1; i<=8; i++) {
			tot[i-1] = new points(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(tot);
		int total = 0;
		for(int i = 0; i<5; i++) {
			total += tot[i].point;
			num[tot[i].problem]= true; 
		}
		sb.append(total).append("\n");
		for(int i = 1; i<=8; i++)
			if(num[i])
				sb.append(i).append(" ");
		System.out.println(sb);
	}
}
