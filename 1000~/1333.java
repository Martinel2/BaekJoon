package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int time = 0;

        while (true) {
            if (time % d == 0) {
                boolean isDuringSong = false;

                for (int i = 0; i < n; i++) {
                    int songStart = i * (l + 5);
                    int songEnd = songStart + l;

                    if (time >= songStart && time < songEnd) {
                        isDuringSong = true;
                        break;
                    }
                }

                if (!isDuringSong) {
                    System.out.println(time);
                    return;
                }
            }
            time++;
        }
        
    }
}    