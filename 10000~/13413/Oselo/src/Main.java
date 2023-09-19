import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String src = br.readLine();
            String tgt = br.readLine();

            int w = 0, b = 0;
            while (n-- > 0) {
                if (src.charAt(n) != tgt.charAt(n)) {
                    if (src.charAt(n) == 'W')
                        w++;
                    else
                        b++;
                }
            }

            sb.append(Math.max(w, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}