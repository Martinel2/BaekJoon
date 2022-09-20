import java.io.*;
import java.util.*;


//1935 ����ǥ���2
public class Main {
	static char[] s;
	static double cal(double a, double b, char s)
	{
		if(s == '+')
			return a+b;
		else if(s == '-')
			return a-b;
		else if(s == '*')
			return a*b;
		else
			return a/b;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//�ǿ����� ����
		Stack<Double> stack = new Stack<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		s = br.readLine().toCharArray();//����ǥ��� �Է¹ޱ�
		int slen = s.length;
		for(int i = 65; i<65+N; i++)//Ű�� ���ĺ� �����ϴ� ���� �Է¹ޱ�
			hm.put((char)i, Integer.parseInt(br.readLine()));
		
		for(int i = 0; i<slen; i++)
		{
			if((int)'A' <= (int)s[i] && (int)s[i] <= (int)'Z')//Ű�� �����ϴ� ���� ��ȯ 
				stack.add((double)hm.get(s[i]));
			else//�����ڰ� ����
			{
					double b = stack.pop();//�����̹Ƿ� b�� ���� �ޱ�
					double a = stack.pop();
					stack.push(cal(a,b,s[i]));//���
			}
		}
		System.out.printf("%.2f", stack.pop());//�Ҽ�����°���� ���
	}
}