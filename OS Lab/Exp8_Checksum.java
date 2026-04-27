import java.util.*;

public class Exp8_Checksum {
    static String add(String a,String b){
        int n=Math.max(a.length(),b.length());
        a=String.format("%"+n+"s",a).replace(' ','0');
        b=String.format("%"+n+"s",b).replace(' ','0');

        StringBuilder r=new StringBuilder();
        int c=0;
        for(int i=n-1;i>=0;i--){
            int s=(a.charAt(i)-'0')+(b.charAt(i)-'0')+c;
            r.append(s%2); c=s/2;
        }
        if(c==1) return add(r.reverse().toString(),"1");
        return r.reverse().toString();
    }

    static String comp(String s){
        StringBuilder r=new StringBuilder();
        for(char c:s.toCharArray()) r.append(c=='0'?'1':'0');
        return r.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        String sum=sc.next();

        for(int i=1;i<n;i++)
            sum=add(sum,sc.next());

        String checksum=comp(sum);
        System.out.println("Checksum: "+checksum);

        String total=sc.next();
        for(int i=1;i<n;i++)
            total=add(total,sc.next());

        total=add(total,checksum);

        if(!total.contains("0"))
            System.out.println("No error detected");
        else
            System.out.println("Error detected");
    }
}