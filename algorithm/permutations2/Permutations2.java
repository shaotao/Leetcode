import java.io.*;
import java.util.*;


class Permutations2
{
    public static void main(String[] args)
    {
        System.out.println("=== Permutations II ===");
        
        Solution solution = new Solution();
        
        //int[] num = {2, 2, 1, 1};
        //int[] num = {1,2,3,4,5};
        //int[] num = {-1,2,-1,2,1,-1,2,1};
        int[] num = {-1,2,-1,2,1,-1,2,1,3};
        //int[] num = {3,3,0,0,2,3,2};
        
        //ArrayList<ArrayList<Integer>> result = solution.permuteUnique2(num);

        ArrayList<ArrayList<Integer>> result = solution.permuteUnique(num);
                
        print_result(result); 
    }
    
    public static void print_result(ArrayList<ArrayList<Integer>> result)
    {
        System.out.println("number of unique permutations = "+result.size());
        for(int i = 0; i < result.size(); i++)
        {
            ArrayList<Integer> row = result.get(i);
            System.out.print((i+1)+"): ");
            for(int j = 0; j < row.size(); j++)
            {
                System.out.print(row.get(j));
                if(j != row.size()-1)
                {
                    System.out.print(", ");
                }
            }
            
            System.out.println();
        }
    }
}


class Solution
{
    public Solution()
    {
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        int[] taken = new int[num.length];

        for(int i = 0; i < taken.length; i++)
        {
            taken[i] = 0;
        }


        ArrayList<Integer> list = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> appearance_array = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++)
        {
            ArrayList<Integer> alist = new ArrayList<Integer>();
            appearance_array.add(alist);
            
        }

        permute(num, taken, list, result, appearance_array);

        return result;
    }

    public void permute(int[] num, int[] taken, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, ArrayList<ArrayList<Integer>> appearance_array)
    {
        // try to select a number to append to the list
        for(int i = 0; i < taken.length; i++)
        {
            // skip the taken number
            if(taken[i] == 1)
            {
                continue;
            }
            
            // skip this number if it was used in this position before
            if( (list.size()+1) < num.length)
            {
                appearance_array.get(list.size()+1).clear();
            }

            boolean appeared = false;
            ArrayList<Integer> alist = appearance_array.get(list.size());
            for(int j = 0; j < alist.size(); j++)
            {
                if(alist.get(j) == num[i])
                {
                    appeared = true;
                    break;
                }
            }
            // debug appearance_array
            // System.out.println(">>>>>>>>>>>>>>>>>");
            // System.out.println(list.size()+": try "+num[i]+", appeared = "+appeared);
            // for(int row = 0; row < appearance_array.size(); row++)
            // {
            //     ArrayList<Integer> one_row = appearance_array.get(row);
            //     for(int col = 0; col < one_row.size(); col++)
            //     {
            //         System.out.print(one_row.get(col)+", ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("<<<<<<<<<<<<<<<");

            
            if(appeared == true)
            {
                continue;
            }

            // ok, this number is not taken,
            taken[i] = 1;
            list.add(num[i]);

            if(list.size() >= num.length)
            {
                // this is a full list
                // duplicate the list
                ArrayList<Integer> list_copy = new ArrayList<Integer>(list);
                
                // insert the elements in the list to appearance_array
                for(int idx = 0; idx < list_copy.size(); idx++)
                {
                    if(appearance_array.get(idx).contains(list_copy.get(idx)) == false)
                    {
                        appearance_array.get(idx).add(list_copy.get(idx));
                    }
                }

                //Permutations2.print_result(appearance_array);

                result.add(list_copy);
                taken[i] = 0;
                list.remove(list.size()-1);

                return;
            }
            else
            {
                permute(num, taken, list, result, appearance_array);
                taken[i] = 0;
                list.remove(list.size()-1);
            }            
        }
        
    }


    public ArrayList<ArrayList<Integer>> permuteUnique2(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        int[] taken = new int[num.length];

        for(int i = 0; i < taken.length; i++)
        {
            taken[i] = 0;
        }


        ArrayList<Integer> list = new ArrayList<Integer>();
        permute2(num, taken, list, result);

        // next we remove the duplicates
        //filter_duplicates(result);
        //filter_duplicates2(result);
        result = filter_duplicates3(result);

        return result;
    }


    public void quicksort(ArrayList<Integer>[] list, int start_idx, int end_idx)
    {

        int i = start_idx;
        int j = end_idx;

        if(end_idx <= start_idx)
        {
            return;
        }

        Random rand = new Random();
        ArrayList<Integer> pivot = list[start_idx + rand.nextInt(end_idx-start_idx+1)];

        while(i <= j)
        {
            while(i < end_idx && cmp_list(list[i], pivot) < 0)
            {
                i++;
            }

            while(j > start_idx && cmp_list(list[j], pivot) > 0)
            {
                j--;
            }

            if(i <= j)
            {
                ArrayList<Integer> temp = list[i];
                list[i] = list[j];
                list[j] = temp;


                if(i < end_idx)
                {
                    i++;
                }

                if(j > start_idx)
                {
                    j--;
                }
            }
        }

        quicksort(list, start_idx, j);
        quicksort(list, i, end_idx);
    }

    public ArrayList<ArrayList<Integer>> filter_duplicates3(ArrayList<ArrayList<Integer>> result)
    {
        // store result list as array
        ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[result.size()];

        for(int i = 0; i < result.size(); i++)
        {
            list[i] = result.get(i);
        }
        
        quicksort(list, 0, list.length-1);


        ArrayList<ArrayList<Integer>> result_list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> prev = null;
        for(int i = 0; i < list.length; i++)
        {
            ArrayList<Integer> item = list[i];

            if(prev == null || cmp_list(item, prev) != 0 )
            {
                result_list.add(item);
            }
            prev = item;
        }

        return result_list;
    }

    public void filter_duplicates2(ArrayList<ArrayList<Integer>> result)
    {
        if(result == null)
        {
            return;
        }

        ArrayList<Integer> remove_idx_list = new ArrayList<Integer>();

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        for(int i = 0; i < result.size(); i++)
        {
            int key = result.get(i).hashCode();
            if(hashmap.get(key) != null)
            {
                remove_idx_list.add(0, i);
            }
            else
            {
                hashmap.put(key, key);
            }

        }


        for(int i = 0; i < remove_idx_list.size(); i++)
        {
            result.remove((int)(remove_idx_list.get(i)));
        }
    }

    public void filter_duplicates(ArrayList<ArrayList<Integer>> result)
    {
        if(result == null)
        {
            return;
        }

        for(int i = result.size()-1; i >= 0; i--)
        {
            ArrayList<Integer> list_i = result.get(i);
            for(int j = i-1; j >= 0; j--)
            {
                ArrayList<Integer> list_j = result.get(j);
                
                if(cmp_list(list_i, list_j) == 0)
                {
                    result.remove(i);
                    break;
                }
            }
        }        
    }
    
    public int cmp_list(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        if((list1 == null && list2 != null) || 
           (list1 != null && list2 == null) )
        {
            return -2;
        }

        if(list1 == null && list2 == null)
        {
            return 0;
        }

        if(list1.size() != list2.size())
        {
            return -2;
        }

        for(int i = 0; i < list1.size(); i++)
        {
            if(list1.get(i) < list2.get(i))
            {
                return -1;
            }
            else if(list1.get(i) > list2.get(i))
            {
                return 1;
            }
        }

        return 0;
    }

    public void permute2(int[] num, int[] taken, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
    {
        // try to select a number to append to the list
        for(int i = 0; i < taken.length; i++)
        {
            // skip the taken number
            if(taken[i] == 1)
            {
                continue;
            }

            // ok, this number is not take,
            taken[i] = 1;
            list.add(num[i]);

            if(list.size() >= num.length)
            {
                // this is a full list
                // duplicate the list
                ArrayList<Integer> list_copy = new ArrayList<Integer>(list);
                result.add(list_copy);
                taken[i] = 0;
                list.remove(list.size()-1);
                return;
            }
            else
            {
                permute2(num, taken, list, result);
                taken[i] = 0;
                list.remove(list.size()-1);
            }
        }
        
    }
}
