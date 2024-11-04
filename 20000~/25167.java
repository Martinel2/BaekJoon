package solved;

import java.util.*;

public class Main {
    static class Node {
        List<String> wrongTime;
        List<String> solveTime;

        Node() {
            wrongTime = new ArrayList<>(Collections.nCopies(101, "."));
            solveTime = new ArrayList<>(Collections.nCopies(101, "."));
        }
    }

    static Map<String, Node> participantMap = new HashMap<>();
    static List<List<Pair>> submissionTimes = new ArrayList<>(101);
    static Map<String, Integer> totalScore = new HashMap<>();
    static List<Pair> results = new ArrayList<>();

    static class Pair {
        String name;
        int score;

        Pair(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static int calc(String wrongTime, String solveTime) {
        int wtHour = (wrongTime.charAt(0) - '0') * 10 + (wrongTime.charAt(1) - '0');
        int wtMinute = (wrongTime.charAt(3) - '0') * 10 + (wrongTime.charAt(4) - '0');
        int stHour = (solveTime.charAt(0) - '0') * 10 + (solveTime.charAt(1) - '0');
        int stMinute = (solveTime.charAt(3) - '0') * 10 + (solveTime.charAt(4) - '0');
        return (stHour * 60 + stMinute) - (wtHour * 60 + wtMinute);
    }

    static boolean compare(Pair a, Pair b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name) < 0;
        }
        return a.score < b.score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of problems
        int M = scanner.nextInt(); // Number of participants
        int P = scanner.nextInt(); // Number of submissions

        for (int i = 0; i <= 100; i++) {
            submissionTimes.add(new ArrayList<>());
        }

        Node tmpNode;
        for (int m = 1; m <= M; m++) {
            String name = scanner.next();
            tmpNode = new Node();
            participantMap.put(name, tmpNode);
            totalScore.put(name, 0);
        }

        for (int p = 1; p <= P; p++) {
            int num = scanner.nextInt();
            String time = scanner.next();
            String name = scanner.next();
            String result = scanner.next();

            if (result.equals("wrong")) {
                if (!participantMap.get(name).solveTime.get(num).equals(".")) continue;
                if (participantMap.get(name).wrongTime.get(num).equals(".")) {
                    participantMap.get(name).wrongTime.set(num, time);
                }
            } else if (result.equals("solve")) {
                if (participantMap.get(name).solveTime.get(num).equals(".")) {
                    participantMap.get(name).solveTime.set(num, time);
                }
            }
        }

        for (Map.Entry<String, Node> entry : participantMap.entrySet()) {
            String name = entry.getKey();
            Node node = entry.getValue();
            for (int i = 1; i <= N; i++) {
                String wt = node.wrongTime.get(i);
                String st = node.solveTime.get(i);
                if (wt.equals(".") && st.equals(".")) {
                    totalScore.put(name, totalScore.get(name) + M + 1);
                } else if (wt.equals(".") && !st.equals(".")) {
                    totalScore.put(name, totalScore.get(name) + M + 1);
                } else if (!wt.equals(".") && st.equals(".")) {
                    totalScore.put(name, totalScore.get(name) + M);
                } else if (!wt.equals(".") && !st.equals(".")) {
                    submissionTimes.get(i).add(new Pair(name, calc(wt, st)));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            submissionTimes.get(i).sort((a, b) -> {
                if (a.score == b.score) return a.name.compareTo(b.name);
                return a.score - b.score;
            });
            for (int j = 0; j < submissionTimes.get(i).size(); j++) {
                String name = submissionTimes.get(i).get(j).name;
                totalScore.put(name, totalScore.get(name) + (j + 1));
            }
        }

        for (Map.Entry<String, Integer> entry : totalScore.entrySet()) {
            results.add(new Pair(entry.getKey(), entry.getValue()));
        }

        results.sort((a, b) -> {
            if (a.score == b.score) {
                return a.name.compareTo(b.name); // Sort by name if scores are equal
            }
            return a.score - b.score; // Sort by score
        });

        
        for (Pair result : results) {
            System.out.println(result.name);
        }

        scanner.close();
    }
}
