package solved;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
    }

    public static void solve(Scanner sc) {
        // Reading the input values
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline
        
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        // BFS to explore each state
        Queue<State> queue = new LinkedList<>();
        ArrayList<Integer> al  = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	al.add(i);
        }
        queue.offer(new State(0, al, new ArrayList<>()));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int round = current.round;
            List<Integer> remaining = current.remaining;
            List<String> moves = current.moves;
            
            if (remaining.isEmpty()) {
                continue;
            }

            // If we have fewer than or equal to K players left, print the result
            if (remaining.size() <= K) {
                System.out.println(round);
                for (String move : moves) {
                    System.out.print(move);
                }
                System.out.println();
                return;
            }

            // If we've reached the max rounds, skip
            if (round == M) {
                continue;
            }

            // Try all possible moves (R, S, P)
            for (String move : new String[] {"R", "S", "P"}) {
                List<Integer> newRemaining = new ArrayList<>();
                for (int i : remaining) {
                    if ((move.equals("R") && arr[i].charAt(round) == 'P') ||
                        (move.equals("S") && arr[i].charAt(round) == 'R') ||
                        (move.equals("P") && arr[i].charAt(round) == 'S')) {
                        newRemaining.add(i);
                    }
                }
                // Enqueue the new state for the next round
                List<String> newMoves = new ArrayList<>(moves);
                newMoves.add(move);
                queue.offer(new State(round + 1, newRemaining, newMoves));
            }
        }

        // If no solution is found, print -1
        System.out.println(-1);
    }

    // Helper class to represent the state in BFS
    static class State {
        int round;
        List<Integer> remaining;
        List<String> moves;

        State(int round, List<Integer> remaining, List<String> moves) {
            this.round = round;
            this.remaining = remaining;
            this.moves = moves;
        }
    }
}
