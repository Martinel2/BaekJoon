package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();		
    while(true) {			
    	st = new StringTokenizer(br.readLine());			
    	int l1 = Integer.parseInt(st.nextToken());			
    	int [] arr=new int [l1];			
    	for(int i=0;i<l1;i++)				
    		arr[i]=Integer.parseInt(st.nextToken());			
    	if(l1==0)	// 마지막줄에 입력받는 값이 0하나면 종료				
    		break;			
    	st = new StringTokenizer(br.readLine());			
    	int l2 = Integer.parseInt(st.nextToken());			
    	int[] brr = new int[l2];			
    	for(int i=0;i<l2;i++)				
    		brr[i]=Integer.parseInt(st.nextToken());			
    	int t1=0, t2=0, sum=0, i=0, j=0;			
    	// t1은 수열 1을 통해서 만들어지는 값, t2는 수열 2를 통해서 만들어 지는 값			
    	// sum은 최종으로 출력되는 값, i는 수열 1의 index, j는 수열 2의 index			
    	while(i<l1 && j<l2) {				
    		if(arr[i]==brr[j]) {	
    			// 교차점에 위치하게 되면 					
    			sum+=Math.max(t1, t2);// 수열 1을 통한 값과 수열2를 통한 값 중 큰 값을 선택					
    			sum+=arr[i];	// 교차점 위치는 저장되지 않았기에 교차점 값을 추가					
    			t1=t2=0;	// 큰 값을 선택했기에, 더해지는 temp값을 초기화					
    			i++;					
    			j++;				
    		}				
    		else if(arr[i]<brr[j] && i<l1)	// i가 수열1의 범위 안에 있고, 값이 수열2의 값보다 작다면 수열 1을 증가					
    			t1+=arr[i++];				
    		else if(arr[i]>brr[j] && j<l2)	// j가 수열2의 범위 안에 있고, 값이 수열1의 값보다 작다면 수열 2을 증가					
    			t2+=brr[j++];			
    		}			
    	for(;i<l1;i++)	// while의 조건이 i가 l1보다 작고, j가 l2보다 작은 것이기 때문에 i와 j의 값으로 종료되었다면 남은 범위를 탐색해서 마지막 경로 까지의 큰 값을 찾음				
    		t1+=arr[i];			
    	for(;j<l2;j++)				
    		t2+=brr[j];			
    	sum+=Math.max(t1, t2);	// 마지막 경로의 최대 값을 저장			
    	sb.append(sum+"\n");		
    	}		
    System.out.println(sb.toString());
    	
  }
}