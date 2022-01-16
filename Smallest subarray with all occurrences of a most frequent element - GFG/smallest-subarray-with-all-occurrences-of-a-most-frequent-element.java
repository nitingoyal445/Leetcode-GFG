// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int arr[], int n)
    {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> imap = new HashMap<>();
        
        int mfreq = 0;
        int si = 0;
        int ei = 0;
        int len = 0;
        
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            
            if(fmap.containsKey(val)){
                // update frequency
                fmap.put(val, fmap.get(val)+1);
            }else{
                //insert element wth frequency 1 and set strating index
                fmap.put(val, 1);
                imap.put(val, i);
            }
            
            if(mfreq<fmap.get(val)){
                mfreq = fmap.get(val);
                si = imap.get(val);
                ei = i;
                len = ei-si+1;
            }else if(mfreq == fmap.get(val)){
                int nlen = i - imap.get(val) +1; // if new length is shorter then previos length
                if(nlen < len){
                    si = imap.get(val);
                    ei = i;
                    len = nlen;
                }
            }else{
                //nothing to do
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = si;i<=ei;i++){
            list.add(arr[i]);
        }
        return list;
    }
  
    
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends