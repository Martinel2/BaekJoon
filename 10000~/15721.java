import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    static int A, T, F;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());
    }

    static int solve() {
        int b = 0;
        int d = 0;
        int cnt = 2;
        while(true) {
            for(int i = 0; i < 4; i++) {
                if(i % 2 == 0) {
                    b++;
                } else {
                    d++;
                }

                if((b == T && F == 0) || (d == T && F == 1)) {
                    return (b+d-1) % A;
                }
            }

            for(int i = 0; i < cnt; i++) {
               b++;
               if(b == T && F == 0) {
                   return (b+d-1) % A;
               }
            }

            for(int i = 0; i < cnt; i++) {
                d++;
                if(d == T && F == 1) {
                    return (b+d-1) % A;
                }
            }

            cnt++;
        }
    }
}
