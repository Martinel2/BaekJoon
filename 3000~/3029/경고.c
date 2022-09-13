/*첫째 줄에 현재 시간이 hh:mm:ss 형식으로 주어진다. (시, 분, 초) hh는 0보다 크거나 같고, 23보다 작거나 같으며, 분과 초는 0보다 크거나 같고, 59보다 작거나 같다.

둘째 줄에는 나트륨을 던질 시간이 위와 같은 형식으로 주어진다.

출력
첫째 줄에 정인이가 기다려야 하는 시간을 입력과 같은 형식으로 출력한다.
*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int change(char c1, char c2) {			//char -> int
	
	int res = 0;
	if (c1 == '0') {
		res = c2 - '0';
	}
	else {
		res = (c1 - '0') * 10 + (c2 - '0');
	}
	return res;
}


int main() {


	char curTime[9], nextTime[9];
	scanf("%s", curTime);
	scanf("%s", nextTime);

	int cur_h = change(curTime[0], curTime[1]);
	int cur_m = change(curTime[3], curTime[4]);
	int cur_s = change(curTime[6], curTime[7]);

	int next_h = change(nextTime[0], nextTime[1]);
	int next_m = change(nextTime[3], nextTime[4]);
	int next_s = change(nextTime[6], nextTime[7]);


	if (cur_h==next_h && cur_m==next_m && cur_s==next_s) {	//적어도 1초를 기다리므로
		printf("24:00:00");
	}
	else {

		if (cur_s > next_s) {
			next_m -= 1;
			next_s += 60;
		}
		int s = next_s - cur_s;

		if (cur_m > next_m) {
			next_h -= 1;
			next_m += 60;
		}
		int m = next_m - cur_m;

		int h;
		if (cur_h > next_h) {
			h = (24 - cur_h) + next_h;
		}
		else {
			h = next_h - cur_h;
		}


		//출력 처리
		if (h < 10) {
			printf("0");
		}
		printf("%d:", h);

		if (m < 10) printf("0");
		printf("%d:", m);

		if (s < 10) printf("0");
		printf("%d", s);


	}

	return 0;

}
