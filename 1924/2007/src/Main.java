import java.io.*;
import java.util.*;


//1924 2007년
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int month = Integer.parseInt(st.nextToken());
		int date = Integer.parseInt(st.nextToken()) - 1;
		int m = 1;
		//지난 날을 7로 나누었을때 나머지로 요일을 알수 있음
		while(m != month)
		{
			if(m == 1 || m == 3 || m == 5 || m == 7 
					|| m == 8 || m == 10 || m == 12 )
				date += 31;
			else if(m == 2)
				date += 28;
			else
				date+= 30;
			m++;
		}
		date %= 7;
		
		switch(date)
		{
			case 0 :
				System.out.print("MON");
				break;
			case 1 :
				System.out.print("TUE");
				break;
			case 2 :
				System.out.print("WED");
				break;
			case 3 :
				System.out.print("THU");
				break;
			case 4 :
				System.out.print("FRI");
				break;
			case 5 :
				System.out.print("SAT");
				break;
			case 6 :
				System.out.print("SUN");
				break;
		}
	}
}