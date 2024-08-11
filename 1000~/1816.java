import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
     public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        
        for(int i=0; i<loop; i++) {
            long number = Long.parseLong(reader.readLine());
            for(int j=2; j<=1000000; j++) {
                if(number%j == 0) {
                    System.out.println("NO");
                    break;
                }
                if(j==1000000) {
                    System.out.println("YES");   
                }
            }
        }
     }
 }
