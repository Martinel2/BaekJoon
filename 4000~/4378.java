import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String key = "QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        String s;
        while((s = br.readLine()) != null) {
	        String ans = "";
	        String[] sarr = s.split(" ");
	        for(String str : sarr) {
	        	for(int i = 0; i<str.length(); i++) {
	        		ans += key.charAt(key.indexOf(str.substring(i,i+1))-1);
	        	}
	        	ans += " ";
	        }
	        sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}