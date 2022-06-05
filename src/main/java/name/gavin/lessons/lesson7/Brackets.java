package name.gavin.lessons.lesson7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Brackets {


    public int solution(String S) {

        if (S == null || S.length()==0) return 1;

        Deque<Character> queue = new ArrayDeque<>();

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if ((c == '(' || c == '[' || c == '{')) {
                queue.addLast(c);
            } else
            {
                if (queue.size() == 0) return 0;
                char shouldMatch = queue.removeLast();
                if ((c == ')')&&(shouldMatch != '(')) return 0;
                if ((c == '}')&&(shouldMatch != '{')) return 0;
                if ((c == ']')&&(shouldMatch != '[')) return 0;
            }
        }
        return queue.size() == 0 ? 1 : 0;
    }

    @Test
    public void testSimple() {

        String S = "{[()()]}";

        int r = solution(S);
        assertEquals("Test", 1, r);
    }

    @Test
    public void testSimple2() {

        String S = "([)()]";

        int r = solution(S);
        assertEquals("Test", 0, r);
    }
}
