import java.io.*;
import java.util.*;


class DesignTinyURL
{
    public static void main(String[] args)
    {
	System.out.println("=== Design TinyURL ===");
	Codec codec = new Codec();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = codec.encode(longUrl);
        System.out.println("longUrl = "+longUrl);
        System.out.println("encode(longUrl) = "+codec.encode(longUrl));
        System.out.println("decode(shortUrl) = "+codec.decode(shortUrl));
    }
}


class Codec
{
    private static final char[] array = new char[62];
    static {
        for(int i = 0; i < 10; i++) {
            array[i] = (char)('0'+i);
        }

        for(int i = 0; i < 26; i++) {
            array[10+i] = (char)('a'+i);
        }

        for(int i = 0; i < 26; i++) {
            array[36+i] = (char)('A'+i);
        }

        //System.out.println("array = "+Arrays.toString(array));
    }

    private HashMap<String, String> map = null;
    
    public Codec() {
        map = new HashMap<String, String>();
    }
    
    public String encode(String longUrl) {
        StringBuffer buf = new StringBuffer();
        long hashcode = longUrl.hashCode();

        hashcode += (int) Math.pow(2, 31);
        
        //System.out.println("hashcode = "+hashcode);

        while(hashcode > 0) {
            buf.insert(0, array[(int)(hashcode%62)]);
            hashcode = hashcode/62;
        }

        String key = buf.toString();
        map.put(key, longUrl);
        return key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
