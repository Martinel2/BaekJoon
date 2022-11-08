import java.io.*;
import java.util.*;


//25581 �� �ι�� ���Ա�
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] san = new int[N];
		int[] heun = new int[N];
		for(int i = 0; i<N; i++){
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int len = arr.length-1;
		int k  = 0;
		while(k*2 < N)
		{
			int temp = arr[k];
			arr[k] = arr[len-k];
			arr[(N-1)-k] = temp;
			k++;
		}
		int sant = 0;
		int hnt = 1;
		heun[0] = 0;
		for(int i = 0; i<=len; i++) {
			if(i % 2 == 0)
			{
				if(sant == 0)
					san[sant] = arr[i];
				else
					san[sant] = arr[i] + san[sant-1];
				if(sant < len) {
					san[sant+1] = san[sant];
					sant+=2;
				}
			}
			else{
				if(hnt == 1)
					heun[hnt] = arr[i];
				else
					heun[hnt] = arr[i] + heun[hnt-1];
				if(hnt < len) {
					heun[hnt+1] = heun[hnt];
					hnt+=2;
				}
			}
		}
		int[][] dp = new int[N][2];
		dp[len][0] = san[len]; dp[len][1] = heun[len];
		int i,j;
		for(i = len-1; i>=0; i--) {
			int A,B;
			if(i % 2 == 0)//�����ϰ� ����
			{
				if(len-3 >= i) {
					for(j = i+2; j<len; j+=2){
						//  (2���� ����ؼ� �ι谡 �� ��) + (������ i+1~j������ ������=�׻��� �����ϰ� ����) + (j��°���� �����ϰ� �� ��)
						A = (san[i] + arr[i+1])*2 + (heun[j]-heun[i+1]) + (san[len]-san[j]);
						//  (���Ⱑ j��°���� 2���� ����� ��) + (���Ⱑ j��°���� ������ ����)
						B = (heun[i] + (san[j]-san[i]) + arr[j+1])*2 + (heun[len]-heun[j+1]);
						// i �̻��� ������ 2���� ��������� j�� ������ �ִ� �ּ� = dp[i][x]
						if(dp[i][1] < B || (dp[i][1] == B && dp[i][0] > A)) {
							dp[i][0] = A;
							dp[i][1] = B;
						}
					}
					if(dp[i][0] < dp[i+1][0]) { // i �̻��̹Ƿ� i+1�� ������ �� ����
						dp[i][0] = dp[i+1][0];
						dp[i][1] = dp[i+1][1];
					}
					else if(dp[i][0] == dp[i+1][0])
						dp[i][1] = Math.min(dp[i][1],dp[i+1][1]);
				}
				else {
					//  (2���� ����ؼ� �ι谡 �� ��)
					A = (san[i] + arr[i+1])*2;
					//  (���Ⱑ i��°���� ����)+ (�׵ڿ� ����)
					B = heun[i] + (san[len]-san[i+1]);
					dp[i][0] = A;
					dp[i][1] = B;	
				}
			}
			else {
				//���Ⱑ ����
				if(len-3 >= i) {
					for(j = i+2; j<len; j+=2){
						//  (2���� ����ؼ� �ι谡 �� ��) + (�������� i+1~j������ ������=�׻��� ���Ⱑ ����) + (j��°���� ���Ⱑ �� ��)
						B = (heun[i]+arr[i+1])*2 + (san[j]-san[i+1]) + (heun[len]-heun[j]);
						//  (�����ϰ� j��°���� 2���� ����� ��) + (�����ϰ� j��°���� ������ ����)
						A = (san[i] + (heun[j]-heun[i]) + arr[j+1])*2 + (san[len]-san[j+1]);
						// i �̻��� ������ 2���� ��������� j�� ������ �ִ� �ּ� = dp[i][x]
						if(dp[i][0] < A || (dp[i][0] == A && dp[i][1] > B)) {
							dp[i][0] = A;
							dp[i][1] = B;
						}
					}
					if(dp[i][1] < dp[i+1][1]) { // i �̻��̹Ƿ� i+1�� ������ �� ����
						dp[i][0] = dp[i+1][0];
						dp[i][1] = dp[i+1][1];
					}
					else if(dp[i][1] == dp[i+1][1])
						dp[i][0] = Math.min(dp[i][0],dp[i+1][0]);
			    }
				else {
					//  (2���� ����ؼ� �ι谡 �� ��)
					B = (heun[i]+arr[i+1])*2;
					//  (�����ϰ� i��°���� ���� ��) + (i+1���� N-1���� ����)
					A = san[i] + (heun[len]-heun[i+1]);
					dp[i][0] = A;
					dp[i][1] = B;
				}
			}
		}
		for(i = 0; i<=len; i++)
		{
			System.out.println("������:" + dp[i][0] + "   " + "����:"+ dp[i][1]);
		}
		System.out.println(dp[0][0]);
	}
}