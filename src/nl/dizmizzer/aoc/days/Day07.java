package nl.dizmizzer.aoc.days;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Day07 extends Day {
    Map parent = null;
    Map topMap = null;
    @Override
    public long solveOne() {

        Queue<Map> mapQueue = new ArrayBlockingQueue<>(10000);
        mapQueue.add(topMap);
        long sum = 0;
        while (!mapQueue.isEmpty()) {
            Map toCheck = mapQueue.poll();
            toCheck.children.forEach((key, val) -> mapQueue.add(val));
            long count = toCheck.getSizeForOne();
            if (count < 100000) {
                sum += count;
            }
        }
        return sum;
    }

    @Override
    public long solveTwo() {
        long openSize = 70000000 - topMap.getSizeForOne();
        long amountToFree = 30000000 - openSize;

        Map lowestAllowedMap = null;
        long mapValue = Long.MAX_VALUE;
        Queue<Map> mapQueue = new ArrayBlockingQueue<>(10000);
        mapQueue.add(topMap);
        long sum = 0;
        while (!mapQueue.isEmpty()) {
            Map toCheck = mapQueue.poll();
            toCheck.children.forEach((key, val) -> mapQueue.add(val));
            long count = toCheck.getSizeForOne();
            if (count > amountToFree && count < mapValue) {
                lowestAllowedMap = toCheck;
                mapValue = count;
            }
        }
        return mapValue;
    }

    private class Map {

        private final String id;
        private final Map parent;
        private final HashMap<String, Map> children = new HashMap<>();
        private final HashMap<String, AoCFile> files = new HashMap<>();

        public Map(String id, Map parent) {
            this.id = id;
            this.parent = parent;
        }

        public long getSizeForOne() {
            long count = 0;
            for (Map child : children.values()) {
                count += child.getSizeForOne();
            }

            for (AoCFile f : files.values()) {
                count += f.size;
            }
            return count;
        }
    }

    private class AoCFile {
        private String id;
        private long size;
        private Map parent;

        public AoCFile(String id, long size, Map parent) {
            this.id = id;
            this.size = size;
            this.parent = parent;
        }
    }

    @Override
    public void setup() {
        super.setup();
        for (String s : input) {
            if (s.startsWith("$ cd ")) {
                if (parent == null) {
                    parent = new Map("/", null);
                    topMap = parent;
                } else if (s.equals("$ cd ..")) {
                    parent = parent.parent;
                }
                else {
                    parent = parent.children.get(s.replace("$ cd ", ""));
                }
            } else if (s.startsWith("dir ")) {
                String folderName = s.replace("dir ", "");
                if (!parent.children.containsKey(folderName)) {
                    parent.children.put(folderName, new Map(folderName, parent));
                }
            } else if (!s.startsWith("$")) {
                String[] filedata = s.split(" ");
                long size = Long.parseLong(filedata[0]);
                parent.files.put(filedata[1], new AoCFile(filedata[1], size, parent));
            }
        }
    }
}
