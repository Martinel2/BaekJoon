package solved;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());    //N 입력받기
        int i = 0;  //KBS1을 찾기 위한 화살표
        int j = 0;  //KBS2를 찾기 위한 화살표
        String temp = "";   //요소의 위치를 바꾸기 위한 temp 변수 생성
        String[] chList = new String[n];    //채널 리스트를 담기 위한 chList 배열 생성

        for (int k = 0; k < n; k++) {
            chList[k] = br.readLine();  //채널 입력받아서 chList에 담기
        }
        while (!chList[0].equals("KBS1")) { //맨 처음에 KBS1이 오면 종료
            if (!chList[i].equals("KBS1")) {    //KBS1을 찾을 때까지 화살표 내려감
                bw.write("1");  //1 출력
                i++;    //화살표 내려감

            } else {    //찾으면,
                bw.write("4");  //4 출력
                temp = chList[i];   //위치 변경
                chList[i] = chList[i - 1];
                chList[i - 1] = temp;
                i--;
            }

        }
        while (!chList[1].equals("KBS2")) { //두번 째에 KBS2가 오면, 종료
            if (!chList[j].equals("KBS2")) {    //KBS2를 찾을 때까지 화살표 내려감
                bw.write("1");
                j++;

            } else {    //찾으면 위치 변경하며 올라감
                bw.write("4");
                temp = chList[j];
                chList[j] = chList[j - 1];
                chList[j - 1] = temp;
                j--;
            }
        }
        bw.flush();
    }
}
