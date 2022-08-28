// Approach: We need to maximise the number of elements from nums[] such that their sum is not more than query. Since it's subsequence, order doesn't matter. So sort nums, take prefix, and perform binary search to find upper bound or last element <= query.


class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int[] ans = new int[queries.length];
        int ind=0;
        for(int query : queries){
            int low = 0;
            int hi = n-1;
            while(low<=hi){
                int mid = low + (hi - low)/2;
                if(prefix[mid] > query){
                    hi = mid-1;
                } else{
                    low = mid+1;
                }
            }
            ans[ind++]=low;
        }
        return ans;
        
        // brute force:
//         Arrays.sort(nums);
//         int n = nums.length;
//         int[] prefix = new int[n];
//         prefix[0] = nums[0];
//         for(int i=1; i<n; i++){
//             prefix[i] = prefix[i-1]+nums[i];
//         }
//         int[] ans = new int[queries.length];
//         int ind=0;
//         for(int query : queries){
//             //calculate lower bound
//             for(int i=0; i<prefix.length; i++){
//                 if(prefix[i]<=query){
//                     ans[ind] = i+1;
//                 }else{
//                     break;
//                 }
//             }
//             ind++;
            
//         }
//         return ans;
        
    }
}