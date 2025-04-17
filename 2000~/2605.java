package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> list = new ArrayList<Integer>();
 		ArrayList<Integer> line = new ArrayList<Integer>();
 		
 		int num = Integer.parseInt(br.readLine()); // 학생수 입력
 		st = new StringTokenizer(br.readLine());
 		for(int i = 0; i < num; i++) {
 			list.add(Integer.parseInt(st.nextToken()));
 		} // 뽑은 번호 배열 입력
 		
 		for(int i = 0; i < num; i++) {
 			line.add(list.get(i), i+1);
 		} // list 인덱스 가져와서 그 숫자에 넣기
 		
 		for(int i = num-1; i >= 0; i--) {
 			System.out.print(line.get(i) + " ");
 		} // 순서대로 출력이니 거꾸로 출력
	}
}