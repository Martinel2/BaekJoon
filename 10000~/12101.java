package solved;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int len, N, K;
    //백트레킹 탐색 진행할 1, 2, 3 배열
    static int[] num = {1, 2, 3};
    //백트레킹에 현재 방법에 속한 숫자들
    static int[] cur = new int[11];
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력값 저장
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //백트레킹 진행
        search(0, 0);
        //K번째 방법이 존재하지 않을 경우
        if(K != 0){
            bw.write("-1");
        }else{	//K번째 방법이 존재할 때
            //K번째 방법에 대해서 '+' 수식 형식으로 설정
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < len; i++) {
                result.append(cur[i]);
                result.append("+");
            }
            result.deleteCharAt(result.length()-1);
            //K번째 방법 BufferedWriter 저장
            bw.write(result.toString());
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //백트레킹을 통해서 1, 2, 3 방법을 탐색하는 함수입니다.
    static void search(int sum, int depth){
        if(sum == N){	//정수 N을 만들었을 때
            K--;		//K번째 방법을 찾기 위해 -1
            len = depth;	//현재 방법의 길이 저장
            return;
        }
        //다음 숫자 탐색
        for(int i=0;i<3;i++){
            //더했을 때 N을 넘어가거나, K번째 방법을 찾았을 때
            if(sum + num[i] > N || K == 0){
                break;
            }
            //다음 수 탐색
            cur[depth] = num[i];
            search(sum + num[i], depth + 1);
        }
    }
}