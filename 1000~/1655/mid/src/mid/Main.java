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

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2); //��������
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); //��������

        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(br.readLine()); //���� �Է¹ޱ�

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num); 
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                if(minHeap.peek() < maxHeap.peek()){ //�ΰ� ���ؼ� ���������� ��ũ��
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp); //���� ��ü�ϱ�
                }

            sb.append(maxHeap.peek() + "\n"); //���������� ���� ����
        }
        System.out.println(sb);
    }
}
