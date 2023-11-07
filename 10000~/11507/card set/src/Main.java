import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean gre = true;
	static boolean greska(boolean[] s, int num) {
		if(s[num]) 
			gre = false;
		else
			s[num] = true;
		return gre;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		boolean[] P = new boolean[14];
		boolean[] K = new boolean[14];
		boolean[] H = new boolean[14];
		boolean[] T = new boolean[14];
		
		for(int i = 0; i<s.length(); i+=3) {
			int num=0;
			String card = s.substring(i,i+3);
			if(card.charAt(1) == '0') 
				num = Integer.valueOf(card.substring(2));
			else
				num = Integer.valueOf(card.substring(1));
			
			char shape = card.charAt(0);
			
			if(shape == 'P') {
				if(!greska(P,num))
					break;
			}
			else if(shape == 'K') {
				if(!greska(K,num))
					break;
			}
			else if(shape == 'H') {
				if(!greska(H,num))
					break;
			}
			else {
				if(!greska(T,num))
					break;
			}
		}
		
		if(!gre)
			System.out.println("GRESKA");
		else {
			int p=13,k=13,h=13,t=13;
			
			for(int i = 1; i<=13; i++) {
				if(P[i])
					p--;
				if(K[i])
					k--;
				if(H[i])
					h--;
				if(T[i])
					t--;
			}
			System.out.println(p+" "+k+" "+h+" "+t);
		}
		
	}
}
