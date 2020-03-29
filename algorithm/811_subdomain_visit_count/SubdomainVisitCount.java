import java.io.*;
import java.util.*;


class SubdomainVisitCount
{
    public static void main(String[] args)
    {
        System.out.println("=== Subdomain Visit Count ===");
        Solution solution = new Solution();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> ret = solution.subdomainVisits(cpdomains); 
        System.out.println("cpdomains = "+Arrays.toString(cpdomains));
        System.out.println("subdomain visits = "+ret);
    }
}


class Solution
{
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] fields = cpdomain.split(" ");
            int count = Integer.parseInt(fields[0]);
            String[] parts = fields[1].split("\\.");
            String temp = "";
            for (int i = parts.length-1; i>= 0; i--) {
                int base = count;
                temp = parts[i]+ ((i==parts.length-1)?"":".") +temp;
                if (map.containsKey(temp)) {
                    base += map.get(temp);
                }
                //System.out.println("put: "+ temp+"->"+base);
                map.put(temp, base);
            }
        }

        List<String> list = new ArrayList<String>();
        for (String key : map.keySet()) {
            list.add(map.get(key)+" "+key);
        }
        return list;
    }
}
