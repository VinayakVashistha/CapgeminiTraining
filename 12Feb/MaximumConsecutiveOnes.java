class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int count=0;
        int maxlen=0;
        int n=nums.length;
        while(j<n){
            if(nums[j]==0)
            count++;
            while(i<n&&count>k){
                if(nums[i]==0)
                count--;
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}