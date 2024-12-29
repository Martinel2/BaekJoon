package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	
        	if (s == 0) {
                sb.append("0 0\n");
                continue;
            }

            if (a > s && b > s) {
                sb.append("Impossible\n");
                continue;
            }
        	
        	int ma = Math.min(a, b);
        	int mb = ma == a? b:a;
        	
        	int mbs = s/mb;
        	
        	boolean chk = false;
            boolean[] v = new boolean[ma];
            for (int i = mbs; !chk && i >= 0; i--) {
                int r = s - mb * i;
                int mod = r%ma;
                if (v[mod]) {
                    chk = false;
                    break;
                }
                v[mod] = true;
                if (mod != 0) continue;

                chk = true;
                if (mb == a) {
                    sb.append(i + " " + (r/ma)).append('\n');
                } else {
                    sb.append((r/ma) + " " + i).append('\n');
                }
            }
            if (!chk)
                sb.append("Impossible\n");
        }
        System.out.println(sb);
    }

    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}