package name.gavin.lessons.lesson3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FrogJmpTest {

    public int solution(int X, int Y, int D) {
        int delta = X-Y;
        if (delta<0) delta = -delta;
        if (delta == 0) return 0;

        return (delta+(D-1)) / D;
    }


    @Test
    public void testSimple() {
        int r = solution(10, 85, 30);
        assertEquals("Test", 3, r);
    }
}
