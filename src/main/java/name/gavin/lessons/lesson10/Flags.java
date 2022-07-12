package name.gavin.lessons.lesson10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Flags {

    public int solution(int[] A) {

        List<Integer> peaks = new ArrayList<>();
        for (int i=1; i<A.length-1; i++) {
            if ((A[i-1] < A[i])&&(A[i] > A[i+1])) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) return 0;
        if (peaks.size() == 1) return 1;

        int span = peaks.get(peaks.size()-1) - peaks.get(0);

        int maxFlags = (int)Math.sqrt(span);
        if (maxFlags * maxFlags < span) maxFlags++;

        for (int flagTry=maxFlags; flagTry>0; flagTry--) {
            int count = 1;
            int current = peaks.get(0);
            for (int j=1; j<peaks.size(); j++)
            {
                int next = peaks.get(j);
                if ((next - current) >= flagTry) {
                    count++;
                    current = next;
                }
            }
            if (count >= flagTry) {
                return flagTry;
            }
        }
        return 1;
    }

    @Test
    public void testSimple() {

        int[] A = new int[12];
        A[0] = 1;
        A[1] = 5;
        A[2] = 3;
        A[3] = 4;
        A[4] = 3;
        A[5] = 4;
        A[6] = 1;
        A[7] = 2;
        A[8] = 3;
        A[9] = 4;
        A[10] = 6;
        A[11] = 2;

        int r = solution(A);
        assertEquals("Test", 3, r);
    }
}
