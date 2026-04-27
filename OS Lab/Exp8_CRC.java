import java.util.*;

public class Exp8_CRC {
    static String xor(String a,String b){
        StringBuilder r=new StringBuilder();
        for(int i=1;i<b.length();i++)
            r.append(a.charAt(i)==b.charAt(i)?'0':'1');
        return r.toString();
    }

    static String div(String data,String key){
        int k=key.length();
        String tmp=data.substring(0,k);

        for(int i=k;i<data.length();i++){
            if(tmp.charAt(0)=='1')
                tmp=xor(key,tmp)+data.charAt(i);
            else
                tmp=xor("0".repeat(k),tmp)+data.charAt(i);
        }

        if(tmp.charAt(0)=='1') tmp=xor(key,tmp);
        else tmp=xor("0".repeat(k),tmp);

        return tmp;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String data=sc.next(), key=sc.next();
        String appended=data+"0".repeat(key.length()-1);

        String rem=div(appended,key);
        String code=data+rem;

        System.out.println("Codeword: "+code);

        String rec=sc.next();
        if(div(rec,key).contains("1"))
            System.out.println("Error detected");
        else
            System.out.println("No error detected");
    }
}