package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int[] N = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        int[] op={10000,10000,10000,10000,10000,10000,10000,10000};
        AList<Integer> Ns = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Double> times = new AList<>();
        for(int i =0;i<N.length;i++){
            Ns.addLast(N[i]);
            opCounts.addLast(op[i]);
            SLList<Integer> test=new SLList<>();
            int j=0;
            while(j<N[i]){
                test.addLast(j);
                j++;
            }
            //Perform 10000 getLast operations on the SLList
            Stopwatch sw = new Stopwatch();
            for (int k=0;k<op[i];k++){
                test.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns,times,opCounts);
    }

}
