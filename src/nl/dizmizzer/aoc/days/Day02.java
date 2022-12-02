package nl.dizmizzer.aoc.days;

public class Day02 extends Day {
    @Override
    public long solveOne() {
        //A beats Y
        //B beats Z
        //C beats X

        //X is Rock gives 8
        //Y is PAPER gives 1
        //Z is scissors gives 6
        return input.stream().map(s -> s.split(" "))
                .mapToLong(input -> {
                    if (input[0].equals("A")) {
                        if (input[1].equals("X")) {
                            return 4;
                        }
                        if (input[1].equals("Y")) {
                            return 6 + 2;
                        }
                        if (input[1].equals("Z")) {
                            return 3;
                        }
                    }
                    if (input[0].equals("B")) {
                        if (input[1].equals("X")) {
                            return 1;
                        }
                        if (input[1].equals("Y")) {
                            return 5;
                        }
                        if (input[1].equals("Z")) {
                            return 9;
                        }
                    }
                    if (input[0].equals("C")) {
                        if (input[1].equals("X")) {
                            return 7;
                        }
                        if (input[1].equals("Y")) {
                            return 2;
                        }
                        if (input[1].equals("Z")) {
                            return 6;
                        }
                    }

                    return 0;
                }).sum();
    }

    @Override
    public long solveTwo() {
        return input.stream().map(s -> s.split(" "))
                .mapToLong(input -> {
                    if (input[0].equals("A")) {
                        if (input[1].equals("X")) {
                            return 3;
                        }
                        if (input[1].equals("Y")) {
                            return 4;
                        }
                        if (input[1].equals("Z")) {
                            return 8;
                        }
                    }
                    if (input[0].equals("B")) {
                        if (input[1].equals("X")) {
                            return 1;
                        }
                        if (input[1].equals("Y")) {
                            return 5;
                        }
                        if (input[1].equals("Z")) {
                            return 9;
                        }
                    }
                    if (input[0].equals("C")) {
                        if (input[1].equals("X")) {
                            return 2;
                        }
                        if (input[1].equals("Y")) {
                            return 6;
                        }
                        if (input[1].equals("Z")) {
                            return 7;
                        }
                    }

                    return 0;
                }).sum();

    }
}
