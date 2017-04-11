import java.io.*;
import java.util.*;


class ComplexNumberMultiplication
{
    public static void main(String[] args)
    {
	System.out.println("=== Complex Number Multiplication ===");
	Solution solution = new Solution();
        String a = "1+1i";
        String b = "1+1i";
        System.out.println(String.format("%s, %s", a, b));
        System.out.println("complex = "+solution.complexNumberMultiply(a, b));

        a = "1+-1i";
        b = "1+-1i";
        System.out.println(String.format("%s, %s", a, b));
        System.out.println("complex = "+solution.complexNumberMultiply(a, b));
}
}


class Solution
{
    public String complexNumberMultiply(String a, String b) {
        String[] array_a = a.split("\\+");
        String[] array_b = b.split("\\+");

        int a1 = Integer.parseInt(array_a[0]);
        int a2 = 0;
        if(array_a.length == 1) {
            a2 = 0;
        } else {
            a2 = Integer.parseInt(array_a[1].split("i")[0]);
        }

        int b1 = Integer.parseInt(array_b[0]);
        int b2 = 0;
        if(array_b.length == 1) {
            b2 = 0;
        } else {
            b2 = Integer.parseInt(array_b[1].split("i")[0]);
        }

        int x = a1*b1 + (-1)*a2*b2;
        int y = a1*b2 + a2*b1;

        return String.format("%d+%di", x, y);
    }
}
