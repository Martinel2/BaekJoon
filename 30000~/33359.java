package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> arrayA = new ArrayList<>();
        List<String> arrayB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayA.add(scanner.next());
        }
        for (int i = 0; i < n; i++) {
            arrayB.add(scanner.next());
        }

        Result result = matchElements(arrayA, arrayB);

        List<String> finalArrayA = new ArrayList<>(result.matched);
        finalArrayA.addAll(result.remainingA);
        List<String> finalArrayB = new ArrayList<>(result.matched);
        finalArrayB.addAll(result.remainingB);

        System.out.println(result.matched.size());
        System.out.println(String.join(" ", finalArrayA));
        System.out.println(String.join(" ", finalArrayB));
    }

    public static Result matchElements(List<String> arrayA, List<String> arrayB) {
        Map<String, Integer> countA = new HashMap<>();
        Map<String, Integer> countB = new HashMap<>();

        for (String s : arrayA) {
            countA.put(s, countA.getOrDefault(s, 0) + 1);
        }
        for (String s : arrayB) {
            countB.put(s, countB.getOrDefault(s, 0) + 1);
        }

        Set<String> allElements = new HashSet<>();
        allElements.addAll(arrayA);
        allElements.addAll(arrayB);

        List<String> matched = new ArrayList<>();
        List<String> remainingA = new ArrayList<>();
        List<String> remainingB = new ArrayList<>();

        for (String element : allElements) {
            int aCount = countA.getOrDefault(element, 0);
            int bCount = countB.getOrDefault(element, 0);
            int common = Math.min(aCount, bCount);

            for (int i = 0; i < common; i++) matched.add(element);
            for (int i = 0; i < aCount - common; i++) remainingA.add(element);
            for (int i = 0; i < bCount - common; i++) remainingB.add(element);
        }

        return new Result(matched, remainingA, remainingB);
    }

    static class Result {
        List<String> matched;
        List<String> remainingA;
        List<String> remainingB;

        Result(List<String> matched, List<String> remainingA, List<String> remainingB) {
            this.matched = matched;
            this.remainingA = remainingA;
            this.remainingB = remainingB;
        }
    }
}
