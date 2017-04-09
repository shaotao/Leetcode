import java.io.*;
import java.util.*;


class RestoreIPAddresses
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();

	//String s = "0279245587303";
	String s = "010010";
	
	ArrayList<String> result = solution.restoreIpAddresses(s);


	System.out.println("=== welcome to RestoreIPAddresses ===");
	System.out.println("s = "+s);
	System.out.println("total number of IP addresses: "+result.size());
	for(int i = 0; i < result.size(); i++)
	{
	    System.out.println(result.get(i));	   	    
	}
    }
}



class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
	// use a HashMap to avoid duplicates
	HashMap<String, String> map = new HashMap<String, String>();

        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < 3 && i < s.length()-3; i++)
        {
            for(int j = i+1; j <= i+3 && j < s.length()-2; j++)
            {
                for(int k = j+1; k <= j+3 && k < s.length()-1; k++)
                {
                    // get the 4 numbers
                    String str1 = s.substring(0, i+1);
                    String str2 = s.substring(i+1, j+1);
                    String str3 = s.substring(j+1, k+1);
                    String str4 = s.substring(k+1, s.length());

		    if(str1.length() <= 0 || str1.length() > 3 ||
		       str2.length() <= 0 || str2.length() > 3 ||
		       str3.length() <= 0 || str3.length() > 3 ||
		       str4.length() <= 0 || str4.length() > 4)
		    {
			continue;
		    }
                    
                    int num1 = Integer.parseInt(str1);
                    int num2 = Integer.parseInt(str2);
                    int num3 = Integer.parseInt(str3);
                    int num4 = Integer.parseInt(str4);
                    
                    if(num1 >= 0 && num1 <= 255 &&
                       num2 >= 0 && num2 <= 255 &&
                       num3 >= 0 && num3 <= 255 &&
                       num4 >= 0 && num4 <= 255)
                       {
			   String ip_str = num1 +"."+num2+"."+num3+"."+num4;
			   
			   if(ip_str.length() != s.length()+3)
			   {
			       continue;
			   }

			   if(map.containsKey(ip_str))
			   {
			       continue;
			   }
			   
			   map.put(ip_str, ip_str);
			   
                           result.add(ip_str);
                       }
                }
            }
        }


        return result;
    }
}
