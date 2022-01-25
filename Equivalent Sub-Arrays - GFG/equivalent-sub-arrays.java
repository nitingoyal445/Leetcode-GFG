// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i  < n; i++){
            set.add(arr[i]);
        }
		//write your code here
		int k = set.size();  // distinct elements
		int ans = 0;
		int i = -1;
		int j = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    while(i<arr.length-1){
		        f1 = true;
		        i++;
		        map.put(arr[i], map.getOrDefault(arr[i],0)+1);
		        
		        if(map.size()==k){
		            ans+=arr.length-i;
		            break;
		        }
		    }
		    
		    while(j<i){
		        f2 = true;
		        j++;
		        if(map.get(arr[j])==1){
		            map.remove(arr[j]);
		        }else{
		            map.put(arr[j], map.get(arr[j])-1);
		        }
		        
		        if(map.size()==k){
		            ans+=arr.length-i;
		        }else{
		            break;
		        }
		    }
		    if(f1 == false && f2 == false){
		        break;
		    }
		}
		return ans;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends