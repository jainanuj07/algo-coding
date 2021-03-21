package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;

public class Test {

    public static void main(String args[]) {
        int [] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;

        double val = Arrays.stream(arr).average().getAsDouble();


        String s = "abc";

        int x = s.charAt(0)-'0';

        int l = 'a';
        int ll = Character.getNumericValue('Z');
        System.out.println("x==="+ x+"  "+(int)s.charAt(0)+" "+l+"  "+ll);
        /*int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            System.out.println(letters[c]);
            System.out.println(c);
        }*/

        System.out.println("l==="+ 5%13);

        String a ="11";
        String b = "1";

        int m = a.length()-1;
        int n = b.length()-1;
        int carry=0;
        StringBuilder ss = new StringBuilder();
        while(m>=0 || n>=0)
        {
            int xx = m>=0 ? a.charAt(m) - '0' :0;
            int y = n>=0 ? b.charAt(n) - '0' :0;

            int d = xx^y^carry;
            carry = xx & y;

            ss.append(d);
            m--;
            n--;
        }

        if(carry==1)
            ss.append(carry);

        System.out.println( ss.reverse().toString());


    }
}
