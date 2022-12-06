package nl.dizmizzer.aoc.days;

public class Day06 extends Day {
    @Override
    public long solveOne() {
        String line = input.get(0);
        int i;
        for (i = 4; i < line.length(); i++) {
            String sub =line.substring(i - 4, i);
            if (!hasDuplicate(sub)) break;
        }
        return i;
    }

    @Override
    public long solveTwo() {
        String line = input.get(0);
        int i;
        for (i = 14; i < line.length(); i++) {
            String sub =line.substring(i - 14, i);
            if (!hasDuplicate(sub)) break;
        }
        return i;

    }

    public boolean hasDuplicate(String sub) {
        for (int i = 0; i < sub.length(); i++) {
            for (int j = i + 1; j < sub.length(); j++) {
                if (sub.charAt(i) == sub.charAt(j)) return true;
            }
        }

        return false;
    }
}
