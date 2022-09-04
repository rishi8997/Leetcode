class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] bits = new int[31];
        int l=0; int ans=0;
        for(int i=0; i<nums.length; i++){
            boolean flag = false;
            for(int k=0; k<31; k++){
                if((nums[i] & (1 << k)) != 0){
                    bits[k]++;
                    if(bits[k] > 1){
                        flag = true;
                    }
                }
            }
            if(!flag) ans = Math.max(ans, i-l+1);
            else{
                while(l<=i){
                    for(int k=0; k<31; k++){
                        if((nums[l] & (1 << k)) != 0){
                            bits[k]--;
                        }
                    }
                    l++;
                    boolean f = false;
                    for(int k=0; k<31; k++){
                        if(bits[k] > 1){
                            f = true;
                        }
                    }
                    if(!f) break;
                }
            }
        }
        return ans;
        
    }
}