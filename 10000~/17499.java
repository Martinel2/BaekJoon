package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	  public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    // 문제 입력
	    int N = Integer.parseInt(st.nextToken());
	    int Q = Integer.parseInt(st.nextToken());

	    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

	    // 수열 시작을 가리킬 인덱스
	    int p = 0;

	    // 쿼리 시작
	    for (int i = 0; i < Q; i++) {
	      st = new StringTokenizer(br.readLine());
	      String op = st.nextToken();
	      int a = Integer.parseInt(st.nextToken());

	      switch (op) {
	        case "1":
	          // a_i에 x만큼 더함
	          int b = Integer.parseInt(st.nextToken());
	          int aa = (N + p + (a - 1)) % N;
	          arr[aa] += b;
	          break;
	        case "2":
	          // 수열을 오른쪽으로 a칸 시프트
	          // -> 시작 인덱스를 왼쪽으로 a칸 옮김
	          // 인덱스 범위 주의
	          p = (N + p - a) % N;
	          break;
	        case "3":
	          // 수열을 왼쪽으로 a칸 시프트
	          // -> 시작 인덱스를 오른쪽으로 a칸 옮김
	          // 인덱스 범위 주의
	          p = (N + p + a) % N;
	          break;
	      }
	    }

	    // 수열 시작을 가리키는 인덱스를 기준으로
	    // 결과 문자열로 합치기
	    for (int i = p; i < N; i++) {
	      sb.append(arr[i]).append(' ');
	    }
	    for (int i = 0; i < p; i++) {
	      sb.append(arr[i]).append(' ');
	    }

	    System.out.println(sb.toString().trim());
	   }

}