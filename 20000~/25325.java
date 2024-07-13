import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            hashMap.put(st.nextToken(), 0); // 학생 이름 0으로 초기화
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 체크를 위한 StringTokenizer 초기화

            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                hashMap.put(s, hashMap.get(s) + 1); // 인기 + 1
            }
        }

        List<String> keySet = new ArrayList<>(hashMap.keySet());

        keySet.sort((o1, o2) -> { // 정렬
            if(hashMap.get(o1) - hashMap.get(o2) == 0)
                return o1.compareTo(o2);
            else
                return hashMap.get(o2) - hashMap.get(o1);
        });

        for(String key : keySet) {
            System.out.println(key + " " + hashMap.get(key));
        }

    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
