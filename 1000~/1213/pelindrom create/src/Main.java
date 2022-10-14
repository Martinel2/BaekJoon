import java.io.*;


//1213 펠린드롬만들기
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cntarr = new int[26];
		String s = br.readLine();
		int slen = s.length();
		for(int i = 0; i<slen; i++)
			cntarr[ s.charAt(i) - 'A' ]++;
		//홀수가 두개이상이면 만들 수 없음
		int cnt = 0;
		int h=-1;
		for(int i = 0; i<26; i++){
			if(cntarr[i] % 2 != 0) {
				cnt++;
				h = i;
			}
			if(cnt>=2)
				break;
		}
		if(cnt>=2)
			System.out.println("I'm Sorry Hansoo");
		else{
			int divlen = 0;
			if(slen % 2 == 0)//정확히 절반인 구간에 홀수개인 알파벳을 넣어야함
				divlen = slen/2;
			else
				divlen = slen/2+1;
			s = "";
			cnt = 0;
			for(int i = 0; i<26; i++){
				for(int j = 0; j < (int)(cntarr[i]/2); j++){
					s += (char)((int)'A' + i);
					//절반인 구간에 홀수개인 알파벳이 존재
					if(s.length() == divlen && h != -1){
						s += (char)((int)'A' + h);
						break;
					}
				}
				cnt += cntarr[i];
				if(s.length() == divlen) {
					break;
				}
				//홀수개가 있음에도 2이상이여서 원래길이의 절반이 되지 않음
				if(cnt == slen) {
					s += (char)((int)'A' + h);
					break;
				}
			}
			//홀수개가 존재할때는 마지막 알파벳을 제외하고 뒤집기
			if(h != -1){
				for(int i = s.length()-2; i>=0; i--){
					s += s.charAt(i);
				}
			}
			//짝수개만 있을때는 그대로 뒤집기
			else{
				for(int i = s.length()-1; i>=0; i--){
					s += s.charAt(i);
				}
			}
			System.out.println(s);
		}
	}
}