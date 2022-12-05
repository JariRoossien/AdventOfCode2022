package nl.dizmizzer.aoc.days;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends Day {

    List<Stack<Character>> stackList = new ArrayList<>();

    Pattern p = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");

    @Override
    public long solveOne() {
        for (int i = 10; i < input.size(); i++) {
            Matcher m = p.matcher(input.get(i));
            m.find();
            int amount = Integer.parseInt(m.group(1));
            int from = Integer.parseInt(m.group(2)) - 1;
            int to = Integer.parseInt(m.group(3)) - 1;
            for (int j = 0; j < amount; j++) {
                stackList.get(to).push(stackList.get(from).pop());
            }
        }
        for (Stack<Character> characters : stackList) {
            System.out.print(characters.peek());
        }
        System.out.println();
        return 0;
    }

    @Override
    public long solveTwo() {
        this.setup();
        for (int i = 10; i < input.size(); i++) {
            Matcher m = p.matcher(input.get(i));
            m.find();
            int amount = Integer.parseInt(m.group(1));
            int from = Integer.parseInt(m.group(2)) - 1;
            int to = Integer.parseInt(m.group(3)) - 1;

            Stack<Character> temp = new Stack<>();

            for (int j = 0; j < amount; j++) {
                Character pop = stackList.get(from).pop();
                temp.push(pop);
            }
            while (!temp.isEmpty())
                stackList.get(to).push(temp.pop());
        }
        for (Stack<Character> characters : stackList) {
            System.out.print(characters.peek());
        }
        System.out.println();
        return 0;
    }

    @Override
    public void setup() {
        super.setup();
        stackList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stackList.add(new Stack<>());
        }

        for (int y = 7; y >= 0; y--) {
            String line = input.get(y);
            for (int i = 0; i < 9; i++) {
                int letterIndex = 1 + i*4;
                if (line.length() <= letterIndex) continue;
                char c = line.charAt(letterIndex);
                if (c == ' ') continue;
                stackList.get(i).push(c);
            }
        }
    }
}
