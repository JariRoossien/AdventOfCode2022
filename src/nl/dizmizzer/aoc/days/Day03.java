package nl.dizmizzer.aoc.days;

public class Day03 extends Day {

    @Override
    public long solveOne() {
        long sum = 0;
        for (String s : input) {
            String left = s.substring(0, s.length() / 2);
            String right = s.substring(s.length() / 2);
            char charFrom = getCharFrom(left, right);
            long pointsFor = getPointsFor(charFrom);
            sum += pointsFor;

        }
        return sum;
    }

    @Override
    public long solveTwo() {
        long sum = 0;
        for (int i = 0; i < input.size(); i += 3) {
            char c = getCharFrom(input.get(i), input.get(i + 1), input.get( i+ 2));
            sum += getPointsFor(c);
        }
        return sum;
    }

    private char getCharFrom(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i) + "")) return a.charAt(i);
        }
        return '-';
    }
    private char getCharFrom(String a, String b, String c) {
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i) + "") && c.contains(a.charAt(i) + "")) return a.charAt(i);
        }
        return '-';
    }

    private long getPointsFor(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        }
        else if (c >= 'A' && c <= 'Z'){
            return c - 'A' + 27;
        }
        return 0;
    }
}
