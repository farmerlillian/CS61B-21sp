package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> noResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        noResizing.addLast(4);
        buggy.addLast(4);
        noResizing.addLast(5);
        buggy.addLast(5);
        noResizing.addLast(6);
        buggy.addLast(6);
        for (int i = 0; i < 3; i++) {
            int last_moResizing = noResizing.getLast();
            int last_buggy = buggy.getLast();
            assertEquals(last_buggy, last_moResizing);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB=B.size();
                assertEquals(size,sizeB);
            }else if (L.size()<=0){
                //only call getLast and removeLast if L.size is greater than 0
                continue;
            } else if (operationNumber==2) {
                //getLast
                int last=L.getLast();
                int lastB=B.getLast();
                assertEquals(last,lastB);
            } else if (operationNumber==3) {
                //removeLast
                int remove=L.removeLast();
                int removeB=B.removeLast();
                assertEquals(removeB,remove);
            }
        }
    }
}
