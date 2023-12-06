package water;

import java.io.*;

public class Main {
    static int n, m, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        int ans = 0;
        if (n <= k)
            ans = 0;

        else {
            int r = 0;
            while (true) {
                int cnt = 0;
                int num = n;
                while (num != 0) {
                    if (num % 2 == 1)
                        cnt++;
                    num = num / 2;
                }

                if(cnt <= k) {
                    break;
                }
                r++;
                n++;
            }
            ans = r;
        }
        bw.write( ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}