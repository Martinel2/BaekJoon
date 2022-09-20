import java.io.*;
import java.util.*;


//1935 후위표기식2
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
		
		int N = Integer.parseInt(br.readLine());//피연산자 갯수
		Stack<Double> stack = new Stack<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		s = br.readLine().toCharArray();//후위표기식 입력받기
		int slen = s.length;
		for(int i = 65; i<65+N; i++)//키가 알파벳 대응하는 수는 입력받기
			hm.put((char)i, Integer.parseInt(br.readLine()));
		
		for(int i = 0; i<slen; i++)
		{
			if((int)'A' <= (int)s[i] && (int)s[i] <= (int)'Z')//키에 대응하는 수로 변환 
				stack.add((double)hm.get(s[i]));
			else//연산자가 나옴
			{
					double b = stack.pop();//스택이므로 b로 먼저 받기
					double a = stack.pop();
					stack.push(cal(a,b,s[i]));//계산
			}
		}
		System.out.printf("%.2f", stack.pop());//소수점둘째까지 출력
	}
}