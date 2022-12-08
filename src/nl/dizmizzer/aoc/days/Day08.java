package nl.dizmizzer.aoc.days;

public class Day08 extends Day {
    int[][] grid;
    @Override
    public long solveOne() {
        long count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (isVisible(y, x)) count += 1;
            }
        }
        return count;
    }

    @Override
    public long solveTwo() {
        long highestCount = -1;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                highestCount = Long.max(getScenicScoreFor(y, x), highestCount);
            }
        }
        return highestCount;
    }

    public long getScenicScoreFor(int y, int x) {
        long upCount = 0;
        long leftCount = 0;
        long rightCount = 0;
        long downCount = 0;
        for (int px = x + 1; px < grid[0].length; px ++) {
            rightCount += 1;
            if (grid[y][px] >= grid[y][x]) {
                break;
            }
        }

        for (int nx = x - 1; nx >= 0; nx-- ) {
            leftCount += 1;
            if (grid[y][nx] >= grid[y][x]) {
                break;
            }
        }

        for (int py = y + 1; py < grid.length; py ++) {
            upCount += 1;
            if (grid[py][x] >= grid[y][x]) {
                break;
            }
        }

        for (int ny = y - 1; ny >= 0; ny--) {
            downCount += 1;
            if (grid[ny][x] >= grid[y][x]) {
                break;
            }
        }
        return leftCount * upCount * downCount * rightCount;
    }
    public boolean isVisible(int y, int x) {
        if (x == 0 || x == grid[0].length - 1 || y == 0 || y == grid.length - 1) return true;

        boolean isVisible = true;
        for (int px = x + 1; px < grid[0].length; px ++) {
            if (grid[y][px] >= grid[y][x]) {
                isVisible = false;
                break;
            }
        }
        if (isVisible) return true;
        isVisible = true;
        for (int nx = x - 1; nx >= 0; nx-- ) {
            if (grid[y][nx] >= grid[y][x]) {
                isVisible = false;
                break;
            }
        }
        if (isVisible) return true;
        isVisible = true;
        for (int py = y + 1; py < grid.length; py ++) {
            if (grid[py][x] >= grid[y][x]) {
                isVisible = false;
                break;
            }
        }
        if (isVisible) return true;
        isVisible = true;
        for (int ny = y - 1; ny >= 0; ny--) {
            if (grid[ny][x] >= grid[y][x]) {
                isVisible = false;
                break;
            }
        }

        return isVisible;
    }
    @Override
    public void setup() {
        super.setup();
        grid = new int[input.size()][input.get(0).length()];

        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                grid[y][x] = Character.getNumericValue(c);
            }
        }
    }
}
