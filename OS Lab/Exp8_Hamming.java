import java.util.*;

public class Exp8_Hamming {
    static int calcR(int m){
        int r=0;
        while(Math.pow(2,r)<m+r+1) r++;
        return r;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int m=sc.nextInt();
        int[] data=new int[m];
        for(int i=0;i<m;i++) data[i]=sc.nextInt();

        int r=calcR(m), n=m+r;
        int[] h=new int[n+1];

        int j=0;
        for(int i=1;i<=n;i++)
            h[i]=((i&(i-1))==0)?0:data[j++];

        for(int i=0;i<r;i++){
            int pos=1<<i, p=0;
            for(int k=1;k<=n;k++)
                if((k&pos)!=0) p^=h[k];
            h[pos]=p;
        }

        System.out.print("Hamming Code: ");
        for(int i=1;i<=n;i++) System.out.print(h[i]);

        int[] rec=new int[n+1];
        for(int i=1;i<=n;i++) rec[i]=sc.nextInt();

        int err=0;
        for(int i=0;i<r;i++){
            int pos=1<<i, p=0;
            for(int k=1;k<=n;k++)
                if((k&pos)!=0) p^=rec[k];
            if(p!=0) err+=pos;
        }

        if(err==0) System.out.println("\nNo error detected");
        else{
            System.out.println("\nError at position: "+err);
            rec[err]^=1;
            System.out.print("Corrected: ");
            for(int i=1;i<=n;i++) System.out.print(rec[i]);
        }
    }
}