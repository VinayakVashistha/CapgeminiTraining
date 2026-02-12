class Solution {
    public double findMaxAverage(int[] nums, int k) {
    if(nums.length==1)
      return nums[0];
      int l=0,r=0;
      double sum=0;
      double res=Integer.MIN_VALUE;
      while(r<nums.length){
        sum+=nums[r];
        while(r-l+1==k){
            res=Math.max(res,sum/k);
            sum-=nums[l];
            l++;
        }
        r++;
      }
      return res;
    }
}