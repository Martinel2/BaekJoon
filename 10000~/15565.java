package solved;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();	//라이언 인형 위치 저장 리스트
        st = new StringTokenizer(br.readLine()," ");
        //인형 정보 저장
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == 1){		//라이언 인형일 때
                list.add(i);
            }
        }
        //라이언 인형의 개수가 K보다 작을 때
        if(list.size()<K){
            bw.write("-1");
        }else{		//라이언 이형의 개수가 K 이상일 때
            int result = Integer.MAX_VALUE;
            //첫 번째 라이언부터 탐색 진행
            for(int i=0;i<=list.size()-K;i++){
                int start = list.get(i);
                int end = list.get(i+K-1);
                result = Math.min(result, end-start+1);
            }
            //최소 크기 BufferedWriter 저장
            bw.write(String.valueOf(result));
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}