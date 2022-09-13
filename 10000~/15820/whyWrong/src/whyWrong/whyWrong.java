package whyWrong;
import java.util.*;

public class whyWrong {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String TestCase;
		TestCase = input.nextLine();
		String[] parse = TestCase.split(" ");
		int T1,T2,i,j;
		T1 = Integer.parseInt(parse[0]);
		T2 = Integer.parseInt(parse[1]);
		
		for(i=0; i<T1; i++) {
			TestCase = input.nextLine();
			parse = TestCase.split(" ");
			int S1=Integer.parseInt(parse[0]),S2=Integer.parseInt(parse[1]);
			if(S1 != S2) {
				System.out.println("Wrong Answer");
				break;
			}
		}
		if(i == T1) {
			for(j = 0; j<T2; j++) {
				TestCase = input.nextLine();
				parse = TestCase.split(" ");
				int S1=Integer.parseInt(parse[0]),S2=Integer.parseInt(parse[1]);
				if(S1 != S2) {
					System.out.println("Why Wrong!!!");
					break;
				}
			}
			if(j==T2)
				System.out.println("Accepted");
		}
	}
}
