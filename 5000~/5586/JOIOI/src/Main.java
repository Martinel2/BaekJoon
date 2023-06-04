import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] joi = {'J','O','I'};
		char[] ioi = {'I','O','I'};
		
		int cntJOI = 0;
		int cntIOI = 0;
		int indexJOI = 0;
		int indexIOI = 0;
		String s = br.readLine();
		
		int slen = s.length();
		
		for(int i = 0; i<slen; i++) {
			if(s.charAt(i) == joi[indexJOI]) {
				indexJOI = (indexJOI+1)%3;
				if(indexJOI == 0)
					cntJOI++;
			}
			else
				indexJOI = 0;
			if(s.charAt(i) == ioi[indexIOI]) {
				indexIOI = (indexIOI+1)%3;
				if(indexIOI == 0) {
					cntIOI++;
					indexIOI++;
				}
			}
			else
				indexIOI = 0;
		}
		
		System.out.println(cntJOI);
		System.out.println(cntIOI);
	}
}
