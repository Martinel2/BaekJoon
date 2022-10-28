import java.io.*;
import java.util.*;


//10825 ±¹¿µ¼ö
public class Main {
	static class students implements Comparable<students>{
		String name = "";
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		students(String name, int kor,int eng,int math)
		{
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		@Override
		public int compareTo(students o) {
			if(this.kor != o.kor)
				return o.kor - this.kor;
			else
			{
				if(this.eng != o.eng)
					return this.eng - o.eng;
				else
				{
					if(this.math != o.math)
						return o.math - this.math;
					else
						return this.name.compareTo(o.name);
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		students[] arr = new students[N];
		
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new students(st.nextToken(),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i].name);
	}
}
/*
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90
*/