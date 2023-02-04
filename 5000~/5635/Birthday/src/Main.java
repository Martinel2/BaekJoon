import java.io.*;
import java.util.*;

//5635 »ıÀÏ
public class Main {
	
	static class students{
		int day = 0;
		int month = 0;
		int year = 0;
		String name = "";
		
		students(String name, int day,int month,int year){
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		students oldest  = new students("",0,0,0);
		students youngest = new students("",0,0,0);
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			students temp = new students(name,day,month,year);
			if(i == 0) {
				oldest = new students(name,day,month,year);
				youngest = new students(name,day,month,year);
			}
			else {
				if(temp.year < oldest.year) {
					oldest = temp;
				}
				else if(temp.year == oldest.year) {
					if(temp.month < oldest.month)
						oldest = temp;
					else if(temp.day < oldest.day)
						oldest = temp;
				}
				
				if(temp.year > youngest.year) {
					youngest = temp;
				}
				else if(temp.year == youngest.year) {
					if(temp.month > youngest.month)
						youngest = temp;
					else if(temp.day > youngest.day)
						youngest = temp;
				}
			}
		}
		System.out.println(youngest.name+"\n"+oldest.name);
	}
}
