package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, arr[];
		N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left, right, res=0;
        for(int i = N-1; i >= 0; i--){
            for(int j=i-1; j>=0; j--){
                for(int k=0; k<=j; k++){
                    if(arr[i]-(arr[j]+arr[k]) <= 0) break;
                    left = 0;
                    right = k;
                    while(left <= right){
                        int mid = left + (right - left)/2;
                        if(arr[mid] >= arr[i]-(arr[j]+arr[k])){
                            right = mid - 1;
                            res = mid;
                        }
                        else{
                            left = mid + 1;
                        }
                    }

                    if(arr[res] == arr[i]-(arr[j]+arr[k])){
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }

	}
}