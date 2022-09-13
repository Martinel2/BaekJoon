package calyear;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class calyear {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String s[] = br.readLine().split(" ");
        
        int E,S,M;
        E = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        M = Integer.parseInt(s[2]);
        
        int A=1,B=1,C=1;
        int cnt = 1;
        
        ////E에 맞추기
        int k = E-A;
        
        A += k;
        B += k;
        C += k;
        cnt += k;
        
        while(B != S || C != M)
        {
        	B = (B+15)%28;
        	C= (C+15)%19;
        	cnt +=15;
        }
        System.out.println(cnt);
	}
}
