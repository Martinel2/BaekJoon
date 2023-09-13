import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean[][] map = new boolean[6][7];
       boolean flag = true;
       String str = br.readLine();
       int firstOne = str.charAt(0)-'A';
       int firstTwo = str.charAt(1)-'0';
       int bOne = firstOne;
       int bTwo = firstTwo;
       map[firstOne][firstTwo] = true;
       for(int i=0;i<35;i++) {
    	   str = br.readLine();
    	   int one = str.charAt(0)-'A';
    	   int two = str.charAt(1)-'0';
    	   if((Math.abs(bOne-one)==2 && Math.abs(bTwo-two)==1)
    		|| (Math.abs(bOne-one)==1 && Math.abs(bTwo-two)==2)) {
    		   if(map[one][two]) {
	    		   flag = false;
	    		   break;
	    	   }
	    	   map[one][two] = true;
	    	   bOne = one;
	    	   bTwo = two;
    	   }
    	   else {
    		   flag = false;
    		   break;
    	   }
       }
       if(flag) {
    	   if((Math.abs(bOne-firstOne)==2 && Math.abs(bTwo-firstTwo)==1)
	       		|| (Math.abs(bOne-firstOne)==1 && Math.abs(bTwo-firstTwo)==2)) {
	    	   flag = true;
	       }
	       else {
	    	   flag = false;
	       }
       }
       
       if(flag) {
    	   System.out.println("Valid");
       }
       else {
    	   System.out.println("Invalid");
       }
       
	}
}