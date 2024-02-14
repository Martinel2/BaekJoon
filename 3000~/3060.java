import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 = 1 + 2+4+6
// 2 = 2 + 1+3+5
// 3 = 3 + 2+4+6
// 4 = 4 + 1+3+5
// 5 = 5 + 2+4+6
// 6 = 6 + 1+3+5

// 1+~+6 = 4(1+~+6)

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int cnt = 1;
            
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i = 0; i<6; i++)
                sum += Integer.parseInt(st.nextToken());
            
            while(n >= sum){
                cnt++;
                sum *= 4;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);    
    }
}
