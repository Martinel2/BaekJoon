import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열 A의 크기
        int K = Integer.parseInt(st.nextToken()); //반복횟수

        st = new StringTokenizer(br.readLine(),","); //수열A 콤마처리
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
            result.add(i);
        }
        if(K==0) {//반복횟수가 0일때
            for(int m = 0; m < result.size(); m++) {
                result.set(m, A.get(m));
            }
        }else {
            for (int j = 0; j < K; j++) {//방법 반복
                if(j==0) {
                    for(int m = 0; m < result.size()-1; m++) {
                        result.set(m, A.get(m+1) - A.get(m));
                    }
                }else {
                    for(int m = 0; m < result.size()-1; m++) {
                        result.set(m, result.get(m+1) - result.get(m));
                    }
                }
                result.remove(result.size()-1);
            }
        }
        for(int n = 0; n < result.size(); n++) {//마지막 출력
            if(n == result.size()-1) {
                System.out.print(result.get(n));
            }
            else {
                System.out.print(result.get(n)+",");
            }
        }
    }	
}
