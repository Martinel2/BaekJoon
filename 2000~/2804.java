package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        
        int lenA = a.length();
        int lenB = b.length();
        
        int idxA=0;
        int idxB=0;
        
        
        while(!a.contains(b.subSequence(idxB, idxB+1))) {
        	idxB++;
        }
        
        while(!b.contains(a.subSequence(idxA, idxA+1))) {
        	idxA++;
        }
        
        for(int i = 0; i<lenB; i++) {
        	if(i == idxB) {
    			sb.append(a).append('\n');
    			continue;
        	}
        	for(int j = 0; j<lenA; j++) {
        		if(idxA == j) {
        			sb.append(b.charAt(i));
        		}
        		else {
        			sb.append('.');
        		}
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
    }
}
