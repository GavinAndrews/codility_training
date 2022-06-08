package name.gavin.lessons.lesson7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StoneWall {

    public int solution(int[] H) {

        Deque<Integer> heights = new ArrayDeque<>();

        int n = 0;

        for (int h : H) {
            Integer currentBlockHeight = heights.peekLast();
            if (currentBlockHeight == null) {
                currentBlockHeight = 0;
            }

            // Consider next block... three choices... shorter, taller, same
            if (currentBlockHeight == h) {
                // Nothing to do... existing block will extend right
                continue;
            }
            if (h > currentBlockHeight) {
                // New Block.. stacks on top of any that might be prevailing
                heights.addLast(h);
                n++;
            } else
            {
                // We are shrinking...
                while (heights.peekLast() != null && heights.peekLast() > h) {
                    heights.removeLast();
                }
                if (heights.peekLast() == null || heights.peekLast() < h) {
                    heights.addLast(h);
                    n++;
                }
            }
        }

        return n;
    }

    @Test
    public void testSimple() {

        int[] H = new int[9];
        H[0] = 8;   H[1] = 8;    H[2] = 5;
        H[3] = 7;    H[4] = 9;    H[5] = 8;
        H[6] = 7;    H[7] = 4;    H[8] = 8;

        int r = solution(H);
        assertEquals("Test", 7, r);
    }
}
