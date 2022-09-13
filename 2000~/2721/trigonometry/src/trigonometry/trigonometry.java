package trigonometry;

import java.util.*;

/*T(n) = 1 + ... + n = n(n+1)/2

k*T(k+1) = k(k+1)(k+2)/2
*/
public class trigonometry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int TestCase;
		TestCase = input.nextInt();
		
		while(TestCase-- != 0)
		{
			int n,sum = 0;
			n = input.nextInt();
			
			for(int k = 1; k<=n; k++) {
				sum += k*(k+1)*(k+2)/2;
			}
			System.out.println(sum);
		}
		
		
	}

}
