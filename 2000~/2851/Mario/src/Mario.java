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
        	if(mush + sum > 100)//100���� Ŀ����
        	{
        		if((mush+sum)-100 <= 100-sum) { // ���ϴ°� �� �����ų� ����.
        			sum += mush;
        			break;
        		}
        		else //���ϸ� �� �־���.
        			break;
        	}
        	else
        	{
        		sum += mush;
        	}
        }
        //���
        System.out.println(sum);
	}
}