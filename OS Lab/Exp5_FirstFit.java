import java.util.*;
public class Exp5_FirstFit {
    public static void main(String[] args) {
        int[] block = {100, 500, 200, 300, 600};
        int[] process = {212, 417, 112, 426};

        int[] alloc = new int[process.length];
        Arrays.fill(alloc, -1);

        for (int i = 0; i < process.length; i++){
            for (int j = 0; j < block.length; j++){
                if (block[j] >= process[i]) {
                    alloc[i] = j;
                    block[j] -= process[i];
                    break;
                }
            }
        }
        System.out.println("P\tSize\tBlock");
        for (int i = 0; i < process.length; i++)
            System.out.println((i+1)+"\t"+process[i]+"\t\t"+
                (alloc[i]==-1?"NA":alloc[i]+1));
    }
}