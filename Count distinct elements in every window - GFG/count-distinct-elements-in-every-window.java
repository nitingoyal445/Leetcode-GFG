// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    int i = 0;
	    while(i<= k-2){
	        map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
	        i++;
	    }
	    i--;
	    int j = -1;
	    while(i< arr.length -1){
	        i++;
	        map.put(arr[i], map.getOrDefault(arr[i], 0)+1); // acquire
	        
	        list.add(map.size()); //work
	        
	        //release
	        j++;
	        int freq = map.get(arr[j]);
	        if(freq == 1){
	            map.remove(arr[j]);
	        }else{
	            map.put(arr[j], freq-1);
	        }
	    }
		return list;
    }
}

