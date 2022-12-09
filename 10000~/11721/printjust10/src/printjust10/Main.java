package printjust10;

import java.io.*;

//11721 10개씩 끊어 출력하기
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int idx = 0;
		int len = s.length();
		while(idx<len) {
			String m;
			int abs = len - idx;
			if(abs<10){
				m = s.substring(idx,len);
			}
			else{
				m = s.substring(idx,idx+10);
			}
			idx += 10;
			System.out.println(m);
		}
	}
}
