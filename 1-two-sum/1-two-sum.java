class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a = -1, b = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            } else{
                a = i;
                b = map.get(target - nums[i]);
                break;
            }
        }
        return new int[]{a, b};
        
    }
}