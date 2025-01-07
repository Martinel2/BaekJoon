package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());
    //오른쪽에 있는 수 중 자신보다 큰 수가 나오기 전까지의 모든층수를 확인 가능
    //이중 for문 시 시간초과
    //스택
    //들어온 순서대로 넣고, 들어오는 수보다 들어가 있는 수가 작으면 pop
    long ans = 0;
    Stack<Integer> b = new Stack<>();
    b.add(Integer.parseInt(br.readLine()));
    for(int i = 1; i<n; i++) {
    	int num = Integer.parseInt(br.readLine());
    	
    	while(!b.isEmpty() && b.peek() <= num) b.pop();
    	b.add(num);
    	//System.out.println(b.size() + " " + num + " " + b.peek());
    	ans += b.size()-1;
    	
    }
    System.out.println(ans);
  }
}