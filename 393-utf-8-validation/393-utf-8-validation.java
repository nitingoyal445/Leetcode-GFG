class Solution {
    public boolean validUtf8(int[] data) {
        int rBytes =0; //remaninig bytes
        
        for(int val : data){
            if(rBytes==0){
                if((val>>7)==0b0){   //1st byte of 1 length char
                    rBytes = 0;
                }else if((val>>5)==0b110){   //1st byte of 2 length char
                    rBytes = 1;
                }else if((val>>4)==0b1110){   //1st byte of 3 length char
                    rBytes = 2;
                }else if((val>>3)==0b11110){   //1st byte of 4 length char
                    rBytes = 3;
                }else{
                    return false;
                }
            }else{
                if((val>>6)==0b10){
                    rBytes--;
                }else{
                    return false;
                }
            }
        }
        if(rBytes==0){
            return true;
        }
        return false;
    }
}