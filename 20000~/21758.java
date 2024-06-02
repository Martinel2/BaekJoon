package solved;

import java.util.*;
import java.io.*;

public class Main{

	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());

		arr=new int[n+1];
		for(int i=1;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int left = leftHoney();
		int right = rightHoney();
		int mid = midHoney();

		int max=Math.max(left,Math.max(right,mid));
		System.out.println(max);
		
	}
	public static int leftHoney() { //벌통이 오른쪽에 위치
		int sum[]=new int[arr.length];
		
		for(int i=2;i<arr.length;i++)
			sum[i]=sum[i-1]+arr[i-1];
		
		int endSum=sum[arr.length-1];
		int max=0;
			
		for(int i=1;i<arr.length-1;i++) {
			max=Math.max(max,endSum-arr[i]+sum[i]);
		}
		
		return max;
	}
	public static int rightHoney() { //벌통이 왼쪽에 위치
		
		int sum[]=new int[arr.length];
			
		for(int i=arr.length-2;i>=1;i--) 
			sum[i]=sum[i+1]+arr[i+1];
		
		int endSum=sum[1];
		
		int max=0;
		
		for(int i=2;i<arr.length;i++) 
			max=Math.max(max,endSum-arr[i]+sum[i]);
		
		
		return max;
		
	}
	public static int midHoney() { //벌통이 가운데에 위치
		int leftSum[]=new int[arr.length];
		int rightSum[]=new int[arr.length];
		
		for(int i=2;i<leftSum.length;i++)
			leftSum[i]=leftSum[i-1]+arr[i];
		
		for(int i=rightSum.length-2;i>=1;i--) 
			rightSum[i]=rightSum[i+1]+arr[i];
		
		int max=0;
		for(int i=1;i<arr.length;i++) 
			max=Math.max(max,leftSum[i]+rightSum[i]);
		
		return max;
	}
}
