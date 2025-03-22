package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visit = new boolean[n+1];
        long[] f = new long[n+1]; //팩토리얼 저장
        
        f[0] = 1;
        for(int i=1; i<n+1; i++) f[i] = f[i-1]*i;
        
        st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        
        if(p==1) {
        	long k = Long.parseLong(st.nextToken());
        	
        	for(int i=0; i<n; i++) {
        		for(int j=1; j<=n; j++) { // 1~n까지의 숫자를 배치
        			if(visit[j]) continue; //이미 넣은 숫자면 패스
        			
        			//팩토리얼 값이 구해야할 가짓수 보다 작으면 빼주기
        			//자릿 수당 나올 수 있는 경우의 수를 제거해주는 것
        			//가지치기하는 느낌
        			if(f[n-i-1] < k) k -= f[n-i-1]; 
        			else { // 크다면 그 가짓수안에 해당 순열이 존재할 것
        				arr[i] = j;
        				visit[j] = true;
        				break;
        			}
        		}
        	}
        	
        	for(int i=0; i<n; i++) System.out.print(arr[i] + " ");
        } else {
        	for(int i=0; i<n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	//위에서 받은 순열의 위치를 찾아야 함.
        	long ans = 1;
        	for(int i=0; i<n; i++) {
        		for(int j=1; j<arr[i]; j++) {
        			if(!visit[j]) {
        				ans += f[n-i-1];
        			}
        		}
        		visit[arr[i]] = true;
        	}
        	System.out.println(ans);
        }
    }
}