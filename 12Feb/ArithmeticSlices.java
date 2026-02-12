class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if (nums.length < 3) {
            return 0;
        }
        int[] difference = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            difference[i - 1] = nums[i] - nums[i - 1];
        }
        int count = 0;
        int length = 0;
        for (int i = 1; i < difference.length; i++) {
            if (difference[i] == difference[i - 1]) {
                length++;
                count += length;
            } else {
                length = 0;
            }
        }
        return count;
    }
}
