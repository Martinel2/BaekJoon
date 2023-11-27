import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int len = s.length();
		String ans = "";
		//밑줄이 포함되면 c++, 아니면 java
		if(s.contains("_")) {
			boolean upper = false;
			boolean error = false;
			for(int i = 0; i<len; i++) {
				char alpa = s.charAt(i);
				if('A' <= alpa && alpa <= 'Z') {
					error = true;
					break;
				}
				if(upper) {
					if(alpa == '_' ) {
						error = true;
						break;
					}
					ans += (char)(alpa-32);
					upper = false;
				}
				else if(alpa == '_') { 
					if(i==0) {
						error = true;
						break;
					}
						
					upper = true;
				}
				else
					ans += alpa;
			}
			if(error || upper)
				System.out.println("Error!");
			else
				System.out.println(ans);
		}
		else {
			boolean error = false;
			for(int i = 0; i<len; i++) {
				char alpa = s.charAt(i);
				if('A' <= alpa && alpa <= 'Z') {
					if(i == 0) {
						error = true;
						break;
					}
					ans += '_';
					ans += (char)(alpa + 32);
				}
				else
					ans += alpa;
			}
			
			if(error)
				System.out.println("Error!");
			else
				System.out.println(ans);
		}
	}
}
