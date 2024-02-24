package Lab.lab3.src.timing;

import java.util.List;

public class TimingData {
    private List<Integer> Ns; // element size of the data structure
    private List<Double> times; // The total time required for all operations, in seconds.
    private List<Integer> opCounts; // operation times

    public TimingData(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        this.Ns = Ns;
        this.times = times;
        this.opCounts = opCounts;
    }

    public void print(){
        System.out.println("Ns" + "\t\t\t" + "times" + "\t\t" + "opCounts");
        for(int i = 0 ; i < Ns.size() ; i ++){
            System.out.println(Ns.get(i) + "\t\t" + times.get(i) + "s\t\t" + opCounts.get(i));
        }
    }

    public List<Integer> getNs() {
        return this.Ns;
    }

    public List<Double> getTimes() {
        return this.times;
    }

    public List<Integer> getOpCounts() {
        return this.opCounts;
    }
}
