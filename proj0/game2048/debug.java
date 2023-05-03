package game2048;
import org.junit.Test;

import static org.junit.Assert.*;

public class debug {
    public static void main(String[] args) {
        int[][] before = new int[][] {
                {10, 20, 0, 0},
                {30, 0, 0, 0},
                {0, 2, 4, 0},
                {2, 0, 0, 100},
        };

        Model model = new Model(before, 0, 0, false);

        boolean changed = model.tilt(Side.EAST);
    }
}
