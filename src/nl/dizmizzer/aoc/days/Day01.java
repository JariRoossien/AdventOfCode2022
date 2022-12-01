package nl.dizmizzer.aoc.days;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day01 extends Day {
    @Override
    public long solveOne() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        int sum = 0;
        for (String s : input) {
            if (s.trim().equals("")) {
                integerQueue.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(s);
            }
        }
        return integerQueue.poll();
    }

    @Override
    public long solveTwo() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        int sum = 0;
        for (String s : input) {
            if (s.trim().equals("")) {
                integerQueue.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(s);
            }
        }
        int first = integerQueue.poll();
        int second = integerQueue.poll();
        int third = integerQueue.poll();
        return first + second + third;
    }
}
