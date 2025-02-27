package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
     // 최솟값과 최댓값을 찾아줄 treemap
        TreeMap<Integer, Integer> num = new TreeMap<>();
        int ans = 0;
        int a = 0;
        int b = 0;
        while (a < n && b < n) {
            num.put(arr[a], a);
            if (num.lastKey() - num.firstKey() > 2) {
                for (Map.Entry<Integer, Integer> entry : num.entrySet()) {
                    if (entry.getValue() == b) {
                        num.remove(entry.getKey());
                        break;
                    }
                }
                b++;
            } else {
                // 최대 길이
                ans = Math.max(ans, a - b + 1);
                a++;
            }
        }
        System.out.print(ans);
    }
}