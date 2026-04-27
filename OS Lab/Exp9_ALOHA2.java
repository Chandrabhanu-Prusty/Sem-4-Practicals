import java.util.*;

public class Exp9_ALOHA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), slots = sc.nextInt();

        Random r = new Random();
        int[] res = new int[3]; // 0=idle,1=success,2=collision

        for (int i = 1; i <= slots; i++) {
            int tx = 0;
            for (int j = 0; j < n; j++) tx += r.nextInt(2);

            int type = (tx == 0) ? 0 : (tx == 1) ? 1 : 2;
            res[type]++;

            String msg = (type == 0) ? "Idle" :
                         (type == 1) ? "Successful Transmission" :
                         "Collision Occurred";

            System.out.println("Slot " + i + " : " + msg);
        }

        System.out.println("\nSimulation Results:");
        System.out.println("Successful Transmissions = " + res[1]);
        System.out.println("Collisions = " + res[2]);
        System.out.println("Idle Slots = " + res[0]);
    }
}