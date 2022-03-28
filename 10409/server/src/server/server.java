package server;

import java.util.*;

public class server {

	public static void main(String[] args) {
		
		int T,C,i; //T: task  C:total time
		Scanner input = new Scanner(System.in);
		
		T = input.nextInt();
		C = input.nextInt();
		
		int sum = 0, task = 0;
		
		int[] t = new int[T];
		
		for(i = 0; i<T; i++) {
			t[i] = input.nextInt();
		}
		for(i = 0; i<T; i++) {
			sum += t[i];
			
			if(sum>C) // time over
				break;
			else
				task++;
		}
		System.out.println(task);

	}

}
