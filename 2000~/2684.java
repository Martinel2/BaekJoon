package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //ttt tth tht thh htt hth hht hhh
        int t= Integer.parseInt(br.readLine());
        while(t-->0) {
        	int[] arr = new int[8];
        	String s = br.readLine();
        	for(int i = 0; i<s.length()-2; i++) {
        		String pat = s.substring(i, i+3);
        		switch(pat) {
        			case "TTT":
        				arr[0]++;
        				break;
        			case "TTH":
        				arr[1]++;
        				break;
        			case "THT":
        				arr[2]++;
        				break;
        			case "THH":
        				arr[3]++;
        				break;
        			case "HTT":
        				arr[4]++;
        				break;
        			case "HTH":
        				arr[5]++;
        				break;
        			case "HHT":
        				arr[6]++;
        				break;
        			case "HHH":
        				arr[7]++;
        				break;
        		}
        	}
        	sb.append(arr[0]+ " " + arr[1]+ " " + arr[2]+ " " + arr[3]+ " " + arr[4]+ " " + arr[5]+ " " + arr[6]+ " " + arr[7]).append('\n');
        }
        System.out.println(sb);
    }
}
