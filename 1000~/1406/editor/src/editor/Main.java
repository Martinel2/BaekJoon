package editor;
import java.util.*;
import java.io.*;

//1406 에디터
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> Left = new Stack<>();
		Stack<Character> Right = new Stack<>();
		
		char[] s = br.readLine().toCharArray(); // 초기 입력 문자
		for(int i = 0; i<s.length; i++) {
			Left.add(s[i]);
		}
		
		int M = Integer.parseInt(br.readLine()); // 명령어 갯수
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char com = st.nextToken().charAt(0);
			
			if(com == 'L') { // 왼쪽 이동
				if(!Left.isEmpty()){
					Right.add(Left.pop());
				}
			}
			else if(com == 'D') { // 오른쪽 이동
				if(!Right.isEmpty()) {
					Left.add(Right.pop());
				}
			}
			else if(com == 'B') { //삭제
				if(!Left.isEmpty())
					Left.pop();
			}
			else { // 추가
				Left.add(st.nextToken().charAt(0));
			}
		}
		while(!Left.isEmpty())
			Right.add(Left.pop());
		while(!Right.isEmpty())
			sb.append(Right.pop());
		System.out.println(sb);
	}
}