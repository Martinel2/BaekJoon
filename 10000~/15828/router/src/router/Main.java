package router;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//15828
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> buff = new LinkedList<>();
		
		int size = Integer.parseInt(br.readLine());
		
		while(true) {
			int packet = Integer.parseInt(br.readLine());
			
			if(packet == -1)
				break;
			else if(packet == 0) {
				buff.poll();
			}
			else if(size > buff.size()) {
				buff.add(packet);
			}
		}
		if(buff.isEmpty())
			System.out.println("empty");
		else
			for(int val : buff) {
				System.out.print(val+ " ");
			}
	}
}
