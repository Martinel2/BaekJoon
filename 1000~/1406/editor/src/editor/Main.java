package editor;
import java.util.*;
import java.io.*;

//1406 ������
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> Left = new Stack<>();
		Stack<Character> Right = new Stack<>();
		
		char[] s = br.readLine().toCharArray(); // �ʱ� �Է� ����
		for(int i = 0; i<s.length; i++) {
			Left.add(s[i]);
		}
		
		int M = Integer.parseInt(br.readLine()); // ��ɾ� ����
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char com = st.nextToken().charAt(0);
			
			if(com == 'L') { // ���� �̵�
				if(!Left.isEmpty()){
					Right.add(Left.pop());
				}
			}
			else if(com == 'D') { // ������ �̵�
				if(!Right.isEmpty()) {
					Left.add(Right.pop());
				}
			}
			else if(com == 'B') { //����
				if(!Left.isEmpty())
					Left.pop();
			}
			else { // �߰�
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