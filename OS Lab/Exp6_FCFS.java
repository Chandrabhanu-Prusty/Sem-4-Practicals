import java.util.*;

public class Exp6_FCFS {
    public static void main(String[] args) {
        int[] req = {82,170,43,140,24,16,190};
        int head = 50, seek = 0;

        for (int x : req) {
            seek += Math.abs(x - head);
            head = x;
        }
        System.out.println("FCFS Total Head Movement: " + seek);
    }
}