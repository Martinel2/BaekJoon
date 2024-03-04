package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		LinkedList<Integer>[] list = new LinkedList[n];
		
		for(int i = 0; i<n; i++) {
			list[i] = new LinkedList<>();
		}
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	
        	list[a].add(b);//�ջ���� �ڿ� ������ ����� ����Ű����
        }
        
        //�ٽ�����Ʈ! ���������� ���� �����ؼ� ����ϴ� ��
        int[] degree = new int[n];//��������
        
        for(int i = 0; i<n; i++) {
        	List<Integer> adj = list[i];
        	for(int j : adj) degree[j]++;//����Ű�� ����� �� ���ϱ�
        }
        
        for(int i = 0; i<n; i++) {
        	if(degree[i] == 0) {//�տ��� ����Ű�� ����� ���� ��� - 1�����̸�
        		q.add(i);//ť�� �־ ����
        	}
        }
        
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	sb.append(idx+1).append(' ');
        	
        	List<Integer> adj = list[idx];//�ش� �л����� �ڿ� ������ �л�üũ
        	for(int node : adj) {
        		degree[node]--;
        		if(degree[node] == 0) q.add(node);//�ջ���� ������� �ڱⰡ 1������ ���
        	}
        }
        
        System.out.println(sb);
    }
}
