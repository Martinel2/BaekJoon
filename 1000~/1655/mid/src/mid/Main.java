package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2); //오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); //내림차순

        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(br.readLine()); //숫자 입력받기

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num); 
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                if(minHeap.peek() < maxHeap.peek()){ //두개 비교해서 내림차순이 더크면
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp); //서로 교체하기
                }

            sb.append(maxHeap.peek() + "\n"); //내림차순의 숫자 저장
        }
        System.out.println(sb);
    }
}
