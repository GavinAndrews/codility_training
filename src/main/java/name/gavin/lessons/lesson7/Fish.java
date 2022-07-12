package name.gavin.lessons.lesson7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Fish {

    class Tiddler {
        int size;
        boolean upStream;

        public Tiddler(int size, boolean upStream) {
            this.size = size;
            this.upStream = upStream;
        }
    }

    public int solution(int[] A, int[] B) {

        int n = A.length;
        if (n <= 1) return n;

        int upstream_survivors = 0;

        Stack<Tiddler> river = new Stack<>();

        for (int i = 0; i < n; i++) {

            Tiddler t = new Tiddler(A[i], B[i] == 0);

            if (!t.upStream) {
                // We save downstream fish onto the stack as these will collide with
                // upstream fish (see later)...
                river.push(t);
            }
            else
            {
                // Going upstream... might collide with other downstream fish in the stack
                while (river.size()>0)
                {
                    if (river.peek().size <= t.size) {
                        // Consume smaller fish...
                        river.pop();
                    } else {
                        // Bigger fish... kills our new tiddler
                        break;
                    }
                }
                if (river.isEmpty()) upstream_survivors++;
            }
        }

        return river.size()+upstream_survivors;
    }

    @Test
    public void testSimple() {

        int[] A = new int[5];
        A[0] = 4;
        A[1] = 3;
        A[2] = 2;
        A[3] = 1;
        A[4] = 5;

        int[] B = new int[5];
        B[0] = 0;
        B[1] = 1;
        B[2] = 0;
        B[3] = 0;
        B[4] = 0;

        int r = solution(A, B);
        assertEquals("Test", 2, r);
    }
}
