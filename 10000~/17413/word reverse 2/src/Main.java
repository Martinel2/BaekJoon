import java.io.*;
import java.util.*;


//17413 단어뒤집기 2
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "<");//<기준으로 문자열 자르기
		int l = st.countTokens();//자른 문자열의 갯수 파악
		if(l>1)//1이상이면 <>가 존재한다는 뜻
		{
			for(int i = 0; i<l; i++)
			{
				String s = st.nextToken();
				int cnt = 0;
				sb.append("<");
				while(s.charAt(cnt) != '>')//태그 처리
				{
					sb.append(s.charAt(cnt));
					cnt++;
				}
				sb.append(">");
				String temp = s.substring(cnt+1, s.length());//태그 이후 부분은 뒤집기
				String[] sbl = temp.split(" ");//공백기준으로 자르기
				for(int j = 0; j<sbl.length; j++) {
					for(int k = sbl[j].length()-1; k>=0; k--)//단어 뒤집기
						sb.append(sbl[j].charAt(k));
					if(j<sbl.length-1)//단어의 마지막부분 = 태그가 시작하는 부분이므로 공백x
						sb.append(" ");
				}
			}
		}
		else// <>가 없으면
		{
			String[] sbl = st.nextToken().split(" ");//공백기준으로 자르기
			for(int i = 0; i<sbl.length; i++)
			{
				for(int j = sbl[i].length()-1; j>=0; j--)//단어 뒤집기
					sb.append(sbl[i].charAt(j));
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}