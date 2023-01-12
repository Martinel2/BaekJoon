import java.io.*;
import java.util.*;

//1072 °ÔÀÓ
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		double X = Long.parseLong(st.nextToken());
		double Y = Long.parseLong(st.nextToken());
		double Z = Math.floor(Y*100/X);;
		if(Z >= 99)
			System.out.print("-1");
		else {
			int low = 1;
		      int high = (int)X;
		      int mid;
		      int res = -1;
		      while(low<=high){
		         mid = (low+high)/2;
		         if(Z<Math.floor((Y+mid)*100/(X+mid))){
		            res = mid;
		            high = mid-1;
		         }else{
		            low = mid+1;
		         }
		      }
		 
		      System.out.println(res);
		}
	}
}

