import java.io.*;
import java.util.*;


class ValidNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Valid Number ===");
        Solution solution = new Solution();
        
        String[] inputs = {"1 ", ".1", "+.8", ".-4", "4e+", "0", " 0.1 ", "abc", "1 a", "2e10", "+-.", "6e6.5", "0e", "4e+", "  -+ "};
        
        for(String input: inputs)
        {
            boolean ret = solution.isNumber(input);
            System.out.println("\""+input+"\" => "+ret);
        }
    }
}


class Solution
{
    // [-]?[0-9]+{.[0-9]+}{e[-]?[0-9]+{.[0-9]+}}
    public boolean isNumber(String s)
    {
        if(s == null || s.length() == 0) { return false; }

        s = s.trim();

        // split by 'e' if any
        int e_idx = s.indexOf('e');
        if (e_idx < 0) {
            return isFloat(s);
        } else {
            String base = s.substring(0, e_idx);
            String exponent = s.substring(e_idx+1, s.length());
            if(base.length() == 0 || exponent.length() == 0) { return false; }
            //return (isFloat(base) && isFloat(exponent));
            return (isFloat(base) && isNonEmptyInt(exponent));
        }
    }

    public String strip_sign(String s)
    {
        if(s != null && s.length() > 0) {
            if(s.charAt(0) == '-' || s.charAt(0) == '+') {
                s = s.substring(1, s.length());
            }
        }
        
        return s;
    }

    public boolean isFloat(String s)
    {
        s = strip_sign(s);
        if(s == null || s.length() == 0) { return false; }
        
        // split by '.' if any
        int dot_idx = s.indexOf('.');
        if (dot_idx < 0) {
            return isNonEmptyInt(s);
        } else {
            String integral = s.substring(0, dot_idx);
            String decimal = s.substring(dot_idx+1, s.length());
            if(integral.length() == 0 && decimal.length() == 0) {
                return false;
            }

            if (integral.equals("")) { integral = "0"; }
            if (decimal.equals("")) { decimal = "0"; }
            
            return (isPosInt(integral) && isPosInt(decimal));
        }        
    }
    
    public boolean isPosInt(String s)
    {
        if (s == null) { return false; }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        
        return true;
    }

    public boolean isNonEmptyInt(String s) {
        if (s == null) { return false; }
        s = strip_sign(s);
        
        if(s.length() == 0) { return false; }
        
        return isPosInt(s);        
    }

    public boolean isInt(String s)
    {
        if (s == null) { return false; }
        s = strip_sign(s);
        
        return isPosInt(s);
    }
}
