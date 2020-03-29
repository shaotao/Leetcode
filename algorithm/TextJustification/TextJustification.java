import java.io.*;
import java.util.*;


class TextJustification
{
    public static void main(String[] args)
    {
	System.out.println("=== TextJustification ===");
	
	Solution solution = new Solution();
	//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
	//int L = 16;


	//String[] words = {"My","momma","always","said,","Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
	int L = 20;

	String[] words = {"Fourscore","and","seven","years","ago","our","fathers","brought","forth","on","this","continent","a","new","nation,","conceived","in","liberty","and","dedicated","to","the","proposition","that","all","men","are","created","equal.","Now","we","are","engaged","in","a","great","civil","war,","testing","whether","that","nation","or","any","nation","so","conceived","and","so","dedicated","can","long","endure.","We","are","met","on","a","great","battlefield","of","that","war.","We","have","come","to","dedicate","a","portion","of","that","field","as","a","final","resting-place","for","those","who","here","gave","their","lives","that","that","nation","might","live.","It","is","altogether","fitting","and","proper","that","we","should","do","this.","But","in","a","larger","sense,","we","cannot","dedicate,","we","cannot","consecrate,","we","cannot","hallow","this","ground.","The","brave","men,","living","and","dead","who","struggled","here","have","consecrated","it","far","above","our","poor","power","to","add","or","detract.","The","world","will","little","note","nor","long","remember","what","we","say","here,","but","it","can","never","forget","what","they","did","here.","It","is","for","us","the","living","rather","to","be","dedicated","here","to","the","unfinished","work","which","they","who","fought","here","have","thus","far","so","nobly","advanced.","It","is","rather","for","us","to","be","here","dedicated","to","the","great","task","remaining","before","us--that","from","these","honored","dead","we","take","increased","devotion","to","that","cause","for","which","they","gave","the","last","full","measure","of","devotion--that","we","here","highly","resolve","that","these","dead","shall","not","have","died","in","vain,","that","this","nation","under","God","shall","have","a","new","birth","of","freedom,","and","that","government","of","the","people,","by","the","people,","for","the","people","shall","not","perish","from","the","earth."};

	//int L = 80;

	//String[] words = {""};
	//int L = 2;

	String input = array_to_string(words);

	System.out.println("input = \""+input+"\"");
	System.out.println("L = "+L);

	ArrayList<String> result = solution.fullyJustify(words, L);

	for(int i = 0; i < result.size(); i++)
	{
	    System.out.println("\""+result.get(i)+"\"");
	}
    }

    public static String array_to_string(String[] array)
    {
	StringBuffer result = new StringBuffer("");
	
	for(int i = 0; i < array.length; i++)
	{
	    if(i > 0)
	    {
		result.append(" ");
	    }

	    result.append(array[i]);	    
	}

	return result.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public ArrayList<String> fullyJustify(String[] words, int L)
    {
	ArrayList<String> result = new ArrayList<String>();

	// get the number of words per row
	int num_words = words.length;

	int curr_count = 0;
	int curr_length = 0;

	ArrayList<Integer> count_list = new ArrayList<Integer>();
	for(int i = 0; i < num_words; i++)
	{
	    if(curr_length > 0)
	    {
		curr_length += 1;
	    }

	    curr_length += words[i].length();

	    if(curr_length > L)
	    {
		// this word is too long for the current row
		// record the current row and start a new row
		count_list.add(curr_count);
		
		curr_count = 1;
		curr_length = words[i].length();
	    }
	    else
	    {
		curr_count += 1;
	    }
	}

	//System.out.println("curr_count = "+curr_count);
	//System.out.println("curr_length = "+curr_length);

	// get the last row
	if(curr_count > 0)
	{
	    count_list.add(curr_count);
	}

	// now we have the count_list, we start to justify the words
	int idx_word = -1;
	int idx_word2 = -1;
	
	for(int i = 0; i < count_list.size(); i++)
	{
	    //System.out.println("count = "+count_list.get(i));

	    // we compute the number of gaps between the words
	    int num_chars = 0;
	    int num_words_row = count_list.get(i);
	    for(int j = 1; j <= num_words_row; j++)
	    {
		idx_word += 1;

		num_chars += words[idx_word].length();

	    }

	    int num_spaces = L - num_chars;

	    ArrayList<Integer> space_list = new ArrayList<Integer>();
	    
	    int num_gaps = num_words_row-1;
	    if(num_gaps <= 0)
	    {
		num_gaps = 1;
	    }

	    int unit_spaces = num_spaces/num_gaps;
	    int residual = num_spaces - unit_spaces*num_gaps;
	    
	    //System.out.println("unit_spaces = "+unit_spaces);
	    //System.out.println("residual = "+residual);
	    //System.out.println("num_gaps = "+num_gaps);

	    for(int j = 0; j < num_gaps; j++)
	    {	
		if(i < count_list.size()-1)
		{
		    if(j < residual)
		    {
			space_list.add(unit_spaces+1);
		    }
		    else
		    {
			space_list.add(unit_spaces);
		    }
		}
		else
		{
		    if(num_spaces > 0)
		    {
			space_list.add(1);
		    }
		}
	    }

	    //System.out.println("space_list size = "+space_list.size());
	    //for(int idx_space = 0; idx_space < space_list.size(); idx_space++)
	    //{
	    //System.out.println(idx_space+" -> "+space_list.get(idx_space));
	    //System.out.println("num_spaces = "+num_spaces);
	    //}

	    if(i == count_list.size()-1 && num_spaces > num_words_row-1)
	    {
		if(num_words_row == 1)
		{
		    space_list.remove(space_list.size()-1);
		}

		// update the last item in space_list for the last row
		space_list.add(num_spaces - (num_words_row-1));

	    }


	    // create the string for this row
	    StringBuffer str = new StringBuffer("");

	    for(int j = 0; j < num_words_row; j++)
	    {
		idx_word2 += 1;
		str.append(words[idx_word2]);
		
		// append spaces after this word
		if(j < space_list.size())
		{
		    str.append(new String(new char[space_list.get(j)]).replace('\0', ' '));
		}
	    }

	    result.add(str.toString());	    
	}	
	
	return result;
    }
}


