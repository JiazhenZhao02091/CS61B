package Lab.lab2.tests.bomb;

import Lab.lab2.src.bomb.Bomb;
import Lab.lab2.src.common.IntList;

public class BombMain {
    public static void main(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct passwords to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            IntList res = null;
            res = new IntList(Integer.parseInt(String.valueOf('8')), res);
            res = new IntList(Integer.parseInt(String.valueOf('0')), res);
            res = new IntList(Integer.parseInt(String.valueOf('3')), res);
            res = new IntList(Integer.parseInt(String.valueOf('9')), res);
            res = new IntList(Integer.parseInt(String.valueOf('0')), res);
            b.phase1(res); // Figure this out too
        }
        if (phase >= 2) {
            /**
             * create an array that spilt with ' ', then contains 1337 element.
             * */
            String res = "";
            for(int i = 0 ; i < 1337 ; i ++){
                res += "i ";
            }
            res += "-81201430";
            b.phase2(res);
        }
    }
}
