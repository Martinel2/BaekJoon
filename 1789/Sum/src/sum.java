import java.io.*;
import java.util.*;


public class sum {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
        double S = Double.parseDouble(br.readLine());
        double i=1;
        int cnt = 0;
        double sum = 0;
        while(sum < S)
        {
        	sum += i;
        	i++;
        	cnt++;
        }
        System.out.println(cnt-1);
        bw.close();
	} 

}
