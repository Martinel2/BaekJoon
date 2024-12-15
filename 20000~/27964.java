package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        HashSet<String> hs = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	String s = st.nextToken();
        	if(s.endsWith("Cheese")) hs.add(s);
        }
        //System.out.println(hs.size());
        String ans = hs.size()>=4? "yummy":"sad";
        
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}