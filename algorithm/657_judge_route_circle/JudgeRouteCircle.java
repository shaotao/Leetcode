import java.io.*;
import java.util.*;


class JudgeRouteCircle
{
    public static void main(String[] args)
    {
	System.out.println("=== Judge Route Circle ===");
	Solution solution = new Solution();

        String[] movesArray = {"UD", "LL"};
        for(String moves: movesArray) {
            System.out.println("moves: "+moves+", circle: "+solution.judgeCircle(moves));
        }
    }
}


class Solution
{
    public boolean judgeCircle(String moves) {
        long x = 0L;
        long y = 0L;
        
        for(int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            switch(ch) {
            case 'U':
                y++; break;
            case 'D':
                y--; break;
            case 'L':
                x--; break;
            case 'R':
                x++; break;
            }
        }
        
        return (x==0L) && (y==0L);
    }
}
