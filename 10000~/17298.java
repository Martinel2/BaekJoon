package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	
	static class NGE{
		int idx;
		int num;
		
		NGE(int idx, int num){
			this.idx = idx;
			this.num = num;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//���ÿ� ���� �ϳ��� �ֱ�
		//�������� ���� �� �ִ� ���� ���� ��
		//���� �������� ���� �� ũ�ٸ� ���ÿ� ����ִ� ���� ��ū���� �������� ��
		//���ִ� ���� �������� ������ ũ�ų� ������ �������� pop()
		//�� �˰����� �ݺ�
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<NGE> stack = new Stack<>();
		int[] ans = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().num < num) {
				NGE nge = stack.pop();
				ans[nge.idx] = num;
			}
			stack.add(new NGE(i,num));
		}
		
		for(int val : ans) {
			if(val == 0)
				val = -1;
			sb.append(val).append(' ');
		}
		
		System.out.println();
	}
}