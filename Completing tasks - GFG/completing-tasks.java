// { Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] arr = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Tasks ans = new Solution().findTasks(arr, m, n);
            for (Integer x : ans.tanya) {
                System.out.print(x + " ");
            }
            System.out.println();
            for (Integer x : ans.manya) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class Tasks {
    ArrayList<Integer> tanya, manya;

    Tasks() {
        tanya = new ArrayList<>();
        manya = new ArrayList<>();
    }
}

// } Driver Code Ends


// check Tasks class in driver

class Solution {
    Tasks findTasks(int[] arr, int m, int n) {
        HashSet<Integer> set = new HashSet<>();
	    for(int val: arr){
	        set.add(val);
	    }
	    boolean flag = true;
	    ArrayList<Integer> one = new ArrayList<>();
	    ArrayList<Integer> two = new ArrayList<>();
	    for(int i=1;i<=n;i++){
	        if(set.contains(i)==false){
	            if(flag){
	                one.add(i);
	            }else{
	                two.add(i);
	            }
	            flag=!flag;
	        }
	    }
	    Tasks task=new Tasks();
	    task.tanya=one;
	    task.manya=two;
	    return task;
    }
}
