import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2670
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[] arr = new double[N];
		arr[0] = Double.parseDouble(br.readLine());
		double max = arr[0];
		for(int i = 1; i<N; i++)
		{
			double num = Double.parseDouble(br.readLine());
			arr[i] = Math.max(num*arr[i-1], num);
			
			if(arr[i] > max)
				max = arr[i];
		}
		
		System.out.printf("%.3f", max);
	}
}
