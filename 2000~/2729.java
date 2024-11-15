import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String ans = "";
            int alen = a.length()-1;
            int blen = b.length()-1;
            int carry = 0;
            while(alen >=0 && blen >=0){
                int anum = a.charAt(alen) - '0';
                int bnum = b.charAt(blen) - '0';
                int sum = anum + bnum + carry;
                
                if(sum == 2){
                    carry = 1;
                    ans = '0' + ans;
                }
                else if(sum == 3){
                    carry = 1;
                    ans = '1' + ans;
                }
                else{
                    carry = 0;
                    ans = String.valueOf(sum).charAt(0) + ans;
                }
                //System.out.println("sum= "+ sum + " " + ans);
                alen--;
                blen--;
            }
            while(alen >= 0){
                int anum = a.charAt(alen) - '0';
                int sum = anum + carry;
                if(sum == 2){
                    carry = 1;
                    ans = '0' + ans;
                }
                else{
                    carry = 0;
                    ans = String.valueOf(sum).charAt(0) + ans;
                }
                alen--; 
            }
            while(blen >= 0){
                int bnum = b.charAt(blen) - '0';
                int sum = bnum + carry;
                if(sum == 2){
                    carry = 1;
                    ans = '0' + ans;
                }
                else{
                    carry = 0;
                    ans = String.valueOf(sum).charAt(0) + ans;
                }
                blen--; 
            }
            if(carry == 1){
                ans = '1' + ans;
            }

            boolean findone = false;
            for(int i = 0; i<ans.length(); i++){
                if(ans.charAt(i) != '0'){
                    ans = ans.substring(i,ans.length());
                    findone = true;
                    break;
                }
            }
            if(!findone) ans = "0";
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
