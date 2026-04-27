import java.util.*;

public class Exp9_ALOHA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stations = sc.nextInt(), slots = sc.nextInt();

        Random r = new Random();
        int success = 0, collision = 0, idle = 0;

        for (int i = 1; i <= slots; i++) {
            int tx = 0;

            for (int j = 0; j < stations; j++)
                if (r.nextInt(2) == 1) tx++;

            if (tx == 0) {
                idle++;
                System.out.println("Slot " + i + " : Idle");
            } else if (tx == 1) {
                success++;
                System.out.println("Slot " + i + " : Successful Transmission");
            } else {
                collision++;
                System.out.println("Slot " + i + " : Collision Occurred");
            }
        }

        System.out.println("\nSimulation Results:");
        System.out.println("Successful Transmissions = " + success);
        System.out.println("Collisions = " + collision);
        System.out.println("Idle Slots = " + idle);
    }
}