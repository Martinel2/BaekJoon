import java.io.*;
import java.util.*;

//Àý´ñ°ªÈü
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> ppq = new PriorityQueue<>();
		PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++)
		{
			int data = Integer.parseInt(br.readLine());
			
			if(data == 0)
			{
				if(!ppq.isEmpty()) {
					if(!mpq.isEmpty())
					{
						if(ppq.peek() < mpq.peek()*-1)
						{
							sb.append(ppq.remove() + "\n");
						}
						else
							sb.append(mpq.remove() + "\n");
					}
					else
						sb.append(ppq.remove() + "\n");
				
				}
				else if(!mpq.isEmpty())
				{
					sb.append(mpq.remove() + "\n");
				}
				else
					sb.append("0\n");
			}
			else
			{
				if(data < 0)
					mpq.add(data);
				else
					ppq.add(data);
			}
		}
		System.out.print(sb);
		
	}
}
