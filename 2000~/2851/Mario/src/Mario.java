import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Mario {
	public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int mush;
        for(int i = 0;  i<10; i++) {
        	mush = Integer.parseInt(reader.readLine());
        	if(mush + sum > 100)//100보다 커질때
        	{
        		if((mush+sum)-100 <= 100-sum) { // 더하는게 더 가깝거나 같음.
        			sum += mush;
        			break;
        		}
        		else //더하면 더 멀어짐.
        			break;
        	}
        	else
        	{
        		sum += mush;
        	}
        }
        //출력
        System.out.println(sum);
	}
}