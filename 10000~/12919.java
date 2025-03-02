package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static String s;  // s는 고정된 문자열
    static String t;  // t는 변환 대상 문자열

    public static boolean find(String t) {
        if (t.length() == s.length()) {
            return t.equals(s);
        }
        //System.out.println(t);
        // 'B'일 경우
        if (t.charAt(0) == 'B' 
        		&& find(new StringBuilder(t).reverse().toString().substring(0,t.length()-1))) {
            return true;
        }
        
        // 'A'일 경우
        if (t.charAt(t.length() - 1) == 'A' 
        		&& find(t.substring(0, t.length() - 1))) {
            return true;
        }
        
        return false;
    }
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		s = br.readLine();
		t = br.readLine();
		
		// find(t)가 true면 1, 아니면 0을 출력
        System.out.println(find(t) ? 1 : 0);
	}	
}
