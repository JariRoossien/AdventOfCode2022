package nl.dizmizzer.aoc.days;

import java.util.ArrayList;
import java.util.List;

public class Day04 extends Day {
    List<CleaningPair> pairs = new ArrayList<>();

    @Override
    public long solveOne() {
        return pairs.stream().filter(CleaningPair::pairsAreInEachother).count();

    }

    @Override
    public long solveTwo() {
        return pairs.stream().filter(CleaningPair::pairsOverlap).count();
    }

    @Override
    public void setup() {
        super.setup();
        for (String s : input) {
            String[] pair = s.split(",");
            String[] pairL = pair[0].split("-");
            String[] pairR = pair[1].split("-");
            CleaningElf left = new CleaningElf(Integer.parseInt(pairL[0]), Integer.parseInt(pairL[1]));
            CleaningElf right = new CleaningElf(Integer.parseInt(pairR[0]), Integer.parseInt(pairR[1]));
            pairs.add(new CleaningPair(left, right));
        }
    }

    private static class CleaningPair {
        private CleaningElf left;
        private CleaningElf right;

        public boolean pairsAreInEachother() {
            return (left.start >= right.start && left.finish <= right.finish) ||
            (right.start >= left.start && right.finish <= left.finish);
        }

        public boolean pairsOverlap() {
            return (left.finish >= right.start && left.start <= right.finish);
        }

        public CleaningPair(CleaningElf left, CleaningElf right) {
            this.left = left;
            this.right = right;
        }
    }

    private static class CleaningElf {
        long start;
        long finish;

        public CleaningElf(long start, long finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
