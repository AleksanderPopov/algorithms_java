package algorithms;

import java.util.Comparator;
import java.util.stream.IntStream;

public class TowersOfHanoi {


    public void stepsForNumberOfDisks(int number) {
        Peg a = new Peg(number);
        Peg b = new Peg(number);
        Peg c = new Peg(number);

        IntStream.range(1, number + 1).boxed().sorted(Comparator.reverseOrder()).forEach(a::put);
        printHanoi(a, b, c);
        moveDisks(number, a, b, c);
        printHanoi(a, b, c);
    }

//    private void stepsForNumberOfDisks(Peg a, Peg b, Peg c) {
////        printHanoi(a, b, c);
//        if (a.disks() <= 1) {
//            b.put(a.pop());
//        } else if (a.disks() == 2) {
//            c.put(a.pop());
//            b.put(a.pop());
//            b.put(c.pop());
//        } else {
//            stepsForNumberOfDisks(c, b, a);
//        }
//    }

    private void moveDisks(int quantity, Peg from, Peg to, Peg extra) {
        if (quantity == 1) {
            to.put(from.pop());
        } else if (quantity == 2) {
            extra.put(from.pop());
            to.put(from.pop());
            to.put(extra.pop());
        } else {
            moveDisks(quantity - 1, from, extra, to);
            to.put(from.pop());
            moveDisks(quantity - 1, extra, to, from);
        }
    }

    static class Peg {
        int[] disks;
        int pointer = -1;

        Peg(int disks) {
            this.disks = new int[disks];
        }

        int pop() {
            if (pointer >= 0) {
                int result = this.disks[pointer];
                this.disks[pointer--] = 0;
                return result;
            } else {
                return 0;
            }
        }

        void put(int disk) {
            if (this.pointer == -1) {
                this.disks[++pointer] = disk;
            } else {
                if (this.disks[pointer] < disk) throw new RuntimeException(String.format("tried to put %d on top of %d", disk, this.disks[pointer]));
                this.disks[++pointer] = disk;
            }
        }

        int disks() { return pointer + 1; }

        public String toString() {
            String result = "";
            for (int i = this.disks.length - 1; i >= 0; i--) {
                int disk = this.disks[i];
                result += ("\n" + (disk == 0 ? "|" : "" + disk));
            }
            return result;
        }
    }

    private void printHanoi(Peg a, Peg b, Peg c) {
        System.out.println("A B C");
        for (int i = a.disks.length - 1; i >= 0; i--) {
            int ad = a.disks[i];
            int bd = b.disks[i];
            int cd = c.disks[i];
            System.out.format("%s %s %s\n",
                    ad == 0 ? "|" : "" + ad,
                    bd == 0 ? "|" : "" + bd,
                    cd == 0 ? "|" : "" + cd);
        }
    }
}
