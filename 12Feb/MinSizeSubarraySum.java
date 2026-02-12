class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i = 0, j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (i < nums.length) {
            sum += nums[i];

            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j];
                j++;
            }

            i++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}
