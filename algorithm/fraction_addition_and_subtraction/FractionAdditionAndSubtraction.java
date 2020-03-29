import java.io.*;
import java.util.*;


class FractionAdditionAndSubtraction
{
    public static void main(String[] args)
    {
	System.out.println("=== Fraction Addition and Subtraction ===");
	Solution solution = new Solution();

        String[] inputs = {"-1/2+1/2",
                           "-1/2+1/2+1/3",
                           "1/3-1/2",
                           "5/3+1/3"
        };

        for(String input : inputs) {
            System.out.println(String.format("input=\"%s\", output=\"%s\"",
                                             input,solution.fractionAddition(input)));
        }
    }
}

class Fraction
{
    boolean positive = true;
    int numerator;
    int denominator;

    public Fraction(boolean positive, int numerator, int denominator) {
        this.positive = positive;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return String.format("%s%s/%s", (positive)?"":"-", numerator, denominator);
    }
}

class Solution
{
    public String fractionAddition(String expression) {

        String ret = null;

        List<Fraction> list = getFractions(expression);

        int denominator = 1;
        for(Fraction f : list) {
            if(denominator% f.denominator != 0) {
                denominator *= f.denominator;
            }
        }

        int numerator = 0;
        for(Fraction f : list) {
            int tmp = ((f.positive?1:(-1)) * f.numerator * (denominator/f.denominator));
            numerator += tmp;
        }
        
        int min = (int)((Math.abs(numerator) < denominator)?Math.abs(numerator):denominator);
        
        for(int i = (min>2?min:2); i >= 2; i--) {
            if(numerator%i == 0 && denominator%i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }

        return String.format("%s/%s", numerator, denominator);
    }

    public List<Fraction> getFractions(String expression) {
        ArrayList<Fraction> list = new ArrayList<Fraction>();
        
        // scan the list of fractions
        // 1. sign, 2. numerator, 3. denominator
        int stage = 1;

        boolean positive = true;
        int numerator = 0;
        int denominator = 1;
        
        StringBuffer buf = null;
        int count = 0;
        for(char ch : expression.toCharArray()) {
            if (stage == 1) {
                if (ch == '-') {
                    positive = false;
                    buf = new StringBuffer();
                    stage = 2;
                } else if (ch == '+'){
                    positive = true;
                    buf = new StringBuffer();
                    stage = 2;
                } else if (Character.isDigit(ch)) {
                    buf = new StringBuffer();
                    buf.append(ch);
                    stage = 2;
                } else {
                    System.out.println("invalid input: "+expression+", stage = "+stage);
                    return null;
                }
                stage = 2;
            } else if (stage == 2) {
                if(Character.isDigit(ch)) {
                    buf.append(ch);
                } else if (ch == '/') {
                    numerator = Integer.parseInt(buf.toString());
                    buf = new StringBuffer();
                    stage = 3;
                } else {
                    System.out.println("invalid input: "+expression+", stage = "+stage);                    
                    return null;                    
                }
            } else {
                if(Character.isDigit(ch)) {
                    buf.append(ch);
                } else if(ch == '+') {
                    denominator = Integer.parseInt(buf.toString());
                    list.add(new Fraction(positive, numerator, denominator));
                    positive = true;
                    buf = new StringBuffer();
                    stage = 1;
                } else if (ch == '-') {
                    denominator = Integer.parseInt(buf.toString());
                    list.add(new Fraction(positive, numerator, denominator));
                    positive = false;
                    buf = new StringBuffer();
                    stage = 1;                    
                } else {
                    System.out.println("invalid input: "+expression+", stage = "+stage);
                    return null;                    
                }
            }
        }

        if(stage == 3) {
            denominator = Integer.parseInt(buf.toString());
            list.add(new Fraction(positive, numerator, denominator));
        }

        return list;
    }
}
