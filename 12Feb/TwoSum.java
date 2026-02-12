class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int i=0;
        int n=numbers.length;
        int j=n-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                arr[0]=i+1;
                arr[1]=j+1;
                break;
            }
            if(numbers[i]+numbers[j]<target)
            i++;
            else
            j--;
        }
        return arr;
    }
}