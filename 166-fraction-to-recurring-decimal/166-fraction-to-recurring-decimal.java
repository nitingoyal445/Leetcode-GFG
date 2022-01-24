class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        boolean flag1 = numerator<0;
        boolean flag2 = denominator<0;
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        StringBuilder ans = new StringBuilder();
        boolean flag = false;
        long q = num / den;
        long r = num % den;
        ans.append(q);
        if(r == 0){
            if((flag1 ==true && flag2 == false) || (flag1 == false && flag2 == true)){
                ans.insert(0,"-");
            }
            return ans.toString();
        }else{
            ans.append(".");
            HashMap<Long, Integer> map = new HashMap<>(); // reminder vs ans.length
            while(r!=0){
                if(map.containsKey(r)){
                    int len = map.get(r);
                    ans.insert(len,"(");
                    ans.append(")");
                    break;
                }else{
                    map.put(r,ans.length());
                     r*=10;
                    q = r / den;
                    r = r % den;
                    ans.append(q);
                }
            }
        }
        if((flag1 ==true && flag2 == false) || (flag1 == false && flag2 == true)){
                ans.insert(0,"-");
        }
        return ans.toString();
    }
}