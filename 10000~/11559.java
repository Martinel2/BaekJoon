package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    private static char[][] map;
    private static boolean end;
    private static int chainCnt;
    private static int[][] xy = {{-1,0},{0,-1},{1,0},{0,1}};

    private static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String fieldStr = br.readLine();
            for(int j = 0; j<6; j++) map[i][j] = fieldStr.charAt(j);
        }

        while(!end)puyoPuyo();
        System.out.println(chainCnt);
    }

    static void  puyoPuyo(){
        boolean[][] visited = new boolean[12][6];
        boolean isPuyo = false;
        Deque<Node> puyoDeque = new LinkedList<>();
        for(int i = 11; i>=0; i--){
            for(int j = 0; j<6; j++){
                if(i>=0&&!visited[i][j]&&map[i][j] != '.'){
                    char c = map[i][j];
                    int tempCnt = 0;
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i,j));
                    puyoDeque.add(new Node(i,j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        Node temp = queue.poll();
                        tempCnt++;
                        for (int k = 0; k < 4; k++) {
                            int tempY = temp.y+xy[k][0];
                            int tempX = temp.x+xy[k][1];
                            if(tempY>=0&&tempY<12&&tempX>=0&&tempX<6&&!visited[tempY][tempX]&&map[tempY][tempX]== c){
                                queue.add(new Node(tempY,tempX));
                                puyoDeque.add(new Node(tempY,tempX));
                                visited[tempY][tempX] = true;
                            }
                        }
                    }
                    if(tempCnt>=4)isPuyo = true;
                    else for (int k = 0; k < tempCnt; k++) puyoDeque.removeLast();
                }
            }
        }
        if(!isPuyo) end = true;
        //연쇄 일어나면 .으로 만들기 후 아래부터 map[j][i]가 '.'이면 문자 값 바꿔줘야함
        else {
            chainCnt++;

            while(!puyoDeque.isEmpty()){
                Node tempNode = puyoDeque.removeFirst();
                map[tempNode.y][tempNode.x] = '.';
            }

            for (int i = 0; i < 6; i++) {
                loop: for (int j = 11; j > 0; j--) {
                    if(map[j][i] == '.'){
                        for (int k = j-1; k >=0 ; k--) {
                            if(map[j][i]!=map[k][i]){
                                map[j][i] = map[k][i];
                                map[k][i] = '.';
                                continue loop;
                            }
                        }
                    }
                }
            }
        }
    }
}