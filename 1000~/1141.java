package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        // Input Strings
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0 ; i < N; i++) {
            String origin = words[i];
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                // If not same,
                if(i != j) {
                    String comp = words[j];
                    // origin이 같거나 짧을 때만 접두사가 되므로
                    if(origin.length() <= comp.length()) {
                        for(int k = 0; k < origin.length(); k++) {
                            if(origin.equals(comp)) {
                                cnt++;
                                break;
                            }
                            if(origin.charAt(k) != comp.charAt(k)) {
                                cnt++;
                                break;
                            }
                        }
                    } else {
                        cnt++;
                    }
                }
            }
            if(cnt == N - 1) {
                set.add(origin);
            }
        }
        System.out.println(set.size());
	}
}