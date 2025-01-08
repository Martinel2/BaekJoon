package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
    	arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
    	int page = Integer.parseInt(st.nextToken());
    	if(page >= arr[i]) ans++;
    }
    System.out.println(ans);
  }
}