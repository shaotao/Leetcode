import java.io.*;
import java.util.*;


public class LRUCache {

    int size_limit;
    int count;
    HashMap<Integer, Integer> map;
    int[] keys;

    public LRUCache(int capacity) 
    {
        size_limit = capacity;
        map = new HashMap<Integer, Integer>();
        keys = new int[size_limit];
	count = 0;
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key)) 
        { 
            for(int i = 0; i < keys.length; i++)
            {
                if(keys[i] == key)
                {
		    int tmp = keys[i];
		    
		    for(int j = i; j > 0; j--)
		    {
			keys[j] = keys[j-1];
		    }
		    keys[0] = tmp;
		    
                    break;
                }
            }
            return map.get(key); 
        }
        else { return -1; }
    }
    
    public void set(int key, int value) 
    {
	if(map.containsKey(key) == true)
	{
            for(int i = 0; i < keys.length; i++)
            {
                if(keys[i] == key)
                {
		    int tmp = keys[i];
		    
		    for(int j = i; j > 0; j--)
		    {
			keys[j] = keys[j-1];
		    }
		    keys[0] = tmp;
		    
                    break;
                }
            }
	}
	else
	{
	    if(count < size_limit)
	    {
		count++;
	    }
	    else
	    {
		map.remove(keys[size_limit-1]);
	    }

	    // remove the last item
	    int last_idx = count < size_limit? count: size_limit-1;
	    for(int i = last_idx; i > 0; i--)
	    {
		keys[i] = keys[i-1];
	    }
	    keys[0] = key;
	}
	map.put(key, value);
    }

    public static void main(String[] args)
    {
	System.out.println("=== LRU Cache ===");
	
	LRUCache cache = new LRUCache(2);
	cache.set(2, 1);
	System.out.println("1");
	cache.set(2, 2);
	System.out.println("2");
	cache.get(2);
	System.out.println("3");
	cache.set(1, 1);
	System.out.println("4");
	cache.set(4, 1);
	System.out.println("5");
	cache.get(2);
	System.out.println("6");
    }
}
