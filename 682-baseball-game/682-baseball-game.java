class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum=0;
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                int rem = list.remove(list.size()-1);
                sum-=rem;
            }else if(ops[i].equals("D")){
                int val = list.get(list.size()-1);
                list.add(val*2);
                sum+= val*2;
            }else if(ops[i].equals("+")){
                int val1 = list.get(list.size()-1);
                int val2 = list.get(list.size()-2);
                list.add(val1+val2);
                sum+=val1+val2;
            }else{
                int val = Integer.parseInt(ops[i]);
                list.add(val);
                sum+=val;
            }
        }
        return sum;
    }
}