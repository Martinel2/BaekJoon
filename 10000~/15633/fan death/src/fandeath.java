import java.util.*;


public class fandeath {

	public static void main(String[] args) {
		
		int n;
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		n = input.nextInt();
		
		for(int i = 1; i<=n; i++) {
			
			if(n%i == 0)
				sum += i;
		}
		
		System.out.println(sum*5-24);
	}

}
