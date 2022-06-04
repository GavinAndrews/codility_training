package name.gavin.lessons.lesson13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FibFrog {

    public int solution(int[] A) {

        if (A.length == 0) return 1;

        // Build Possible Steps i.e. fib(n) <= total GAP
        Set<Integer> steps = new HashSet<>();
        int n = 1;
        int value;
        do {
            value = fib(n);
            steps.add(value);
            n++;
        } while (value <= (A.length+1));

        int r = solve(steps.toArray(new Integer[1]), A);

        return r;
    }

    class State {
        int position;

        public State(int position) {
            this.position = position;
        }
    }

    int solve(Integer[] steps, int[] A) {

        Queue<State> states = new ArrayDeque<>();

        HashSet<Integer> visited = new HashSet<>();
        visited.add(-1);

        states.add(new State(-1));

        int depth = 0;

        while (!states.isEmpty()) {

            Queue<State> newStates = new ArrayDeque<>();

            for (State state : states) {
                int oldPosition = state.position;
                for (int offset : steps) {
                    int newPosition = oldPosition + offset;
                    if (newPosition == A.length) {
                        return depth+1;
                    }
                    if ((newPosition>=0 && newPosition<A.length && A[newPosition]==1)&&!visited.contains(newPosition)) {
                        visited.add(newPosition);
                        newStates.add(new State(newPosition));
                    }
                }
            }
            depth++;
            states = newStates;
        }

        return -1;
    }

    // fib(25) = 121393 (>100K)
    static Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n < 2) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        int value = fib(n - 1) + fib(n - 2);
        memo.put(n, value);
        return value;
    }


    @Test
    public void testSimple() {

        int[] A = new int[11];
        A[0] = 0;
        A[1] = 0;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;
        A[5] = 0;
        A[6] = 1;
        A[7] = 0;
        A[8] = 0;
        A[9] = 0;
        A[10] = 0;

        int r = solution(A);
        assertEquals("Test", 3, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[1];
        A[0] = 1;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }

    @Test
    public void testSimple3() {

        int[] A = new int[2];
        A[0] = 1;
        A[1] = 1;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }

    @Test
    public void testSimple4() {

        int[] A = new int[3];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;

        int r = solution(A);
        assertEquals("Test", 2, r);
    }
}
