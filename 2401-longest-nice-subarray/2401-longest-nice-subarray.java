// Approach: For each number in nums, we'll keep adding the set bits in a bits array and if any bit is found to be set by more than 1 numbers, we keep removing numbers from the start in order to make subarray nice again, while storing maximum length and then return that.

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] bits = new int[31];
        int l=0; int ans=0;
        for(int i=0; i<nums.length; i++){
            boolean flag = false;
            for(int k=0; k<31; k++){
                if((nums[i] & (1 << k)) != 0){       //line1 tells if kth bit in nums[i] is set
                    bits[k]++;                       //if so, increments the count by 1
                    if(bits[k] > 1){                 //means kth bit was set previously by a number
                        flag = true;
                    }
                }
            }
            if(!flag) ans = Math.max(ans, i-l+1);    //means so far no bit was set by more than 1 number, meaning bitwise and is 0 and the subarray is nice
            else{
                while(l<=i){
                    //remove the impact of nums[l] from the bits[]
                    for(int k=0; k<31; k++){
                        if((nums[l] & (1 << k)) != 0){
                            bits[k]--;
                        }
                    }
                    l++;
                    boolean f = false;
                    //checking if now after removing nums[l] the subarray is nice
                    for(int k=0; k<31; k++){
                        if(bits[k] > 1){
                            f = true;
                        }
                    }
                    //if subarray is nice then break otherwise keep narrowing down [l,i] window
                    if(!f) break;
                }
            }
        }
        return ans;
        
    }
}