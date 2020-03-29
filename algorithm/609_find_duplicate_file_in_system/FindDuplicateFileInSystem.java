import java.io.*;
import java.util.*;


class FindDuplicateFileInSystem
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Duplicate File in System ===");
        Solution solution = new Solution();
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> ret = solution.findDuplicate(paths);
        System.out.println("paths = "+Arrays.toString(paths));
        System.out.println("duplicates = "+ret);
    }
}


class Solution
{
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] items = path.split(" ");
            for (int i = 1; i < items.length; i++) {
                String[] fields = items[i].split("[()]");
                String file = String.format("%s/%s", items[0], fields[0]);
                String data = fields[1];
                List<String> list = map.get(data);
                if (list == null) {
                    list = new ArrayList<String>();
                    map.put(data, list);
                }
                list.add(file);
            }
        }

        List<List<String>> ret = new ArrayList<List<String>>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() > 1) {
                ret.add(map.get(key));
            }
        }

        return ret;
    }
}
