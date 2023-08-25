package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem1700 {
    public static void main(String[] args) {

    }

    public int countStudents_(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum(), s0 = students.length - s1;
        for (int sandcich : sandwiches) {
            if (sandcich == 0 && s0 > 0) --s0;
            else if (sandcich == 1 && s1 > 0) --s1;
            else return s1 + s0;
        }
        return 0;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> deque = new ArrayDeque<>();
        for (int s : students) deque.offer(s);
        for (int i = 0; i < sandwiches.length && !deque.isEmpty(); i++) {
            int size = deque.size();
            while (deque.peek() != sandwiches[i] && --size > 0) deque.offer(deque.poll());
            if (size == 0) return deque.size();
            deque.poll();
        }
        return 0;
    }
}
