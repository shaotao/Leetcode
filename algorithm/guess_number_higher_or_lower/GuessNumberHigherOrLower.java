import java.io.*;
import java.util.*;


class GuessNumberHigherOrLower
{
    public static void main(String[] args)
    {
	System.out.println("=== Guess Number Higher or Lower ===");
	Solution solution = new Solution();

        //solution.selectActual(100);
        //System.out.println("Return "+solution.guessNumber(100)+".");

        solution.setActual(2126753390, 1702766719);
        System.out.println("Return "+solution.guessNumber(2126753390)+".");
    }
}

class GuessGame
{
    int actual = 1;

    public void setActual(int n, int actual) {
        this.actual = actual;

        System.out.println("n = "+n+", I pick "+actual+".");
    }
    
    public void selectActual(int n) {
        if(n <= 0) {
            System.out.println("invalid n = "+n);
            System.exit(0);
        }

        Random rand = new Random();
        actual = rand.nextInt(n)+1;

        System.out.println("n = "+n+", I pick "+actual+".");
    }
    
    public int guess(int num) {
        if(actual < num) { return -1; }
        else if(actual == num) { return 0; }
        else { return 1; }
    }
}

class Solution extends GuessGame
{
    public int guessNumber(int n) {
        int ret = 0;

        long left = 1;
        long right = n;
        int mid = 1;

        while(right >= left) {

            mid = ((int)((left+right)/2));

            ret = guess(mid);

            if(ret == 0) {
                return mid;
            } else if(ret < 0) {
                if(mid == right) {
                    right--;
                } else {
                    right = mid;
                }
            } else {
                if(mid == left) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        
        return mid;
    }
}
