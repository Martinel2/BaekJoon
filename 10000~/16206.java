package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 % 10 == o2 % 10) {
					return o1 / 10 - o2 / 10;
				}
				return o1 % 10 - o2 % 10;
			}
		});

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 10) {
				answer += 1;
			} else if (num > 10) {
				queue.add(num);
			}
		}

		while (m > 0 && !queue.isEmpty()) {
			int num = queue.poll();

			num -= 10;
			answer += 1;
			m -= 1;
			if (num == 10) {
				answer += 1;
			} else if (num > 10) {
				queue.add(num);
			}
		}
		System.out.println(answer);
	}
}
