class Solution {
    private boolean withinRange(int[] nums,int maxOperations,int k)
    {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
           if(nums[i]>k)
           {
            maxOperations-=(nums[i]-1)/k;
           }
           if(maxOperations<0)
           {
            return false;
           } 
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        //i - th bag : nums[i] balls
        //at most maxOperations times
        //any bag of balls : 2 bags with pos no of balls
        //penalty : max no of balls in a bag
        //minimize max no of balls

        // 9 : 9/(maxOperations + 1)
        
        int max=nums[0];
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            if(max<nums[i])
              max=nums[i];
        }
        int left=1,right=max;
        while(left<=right)
        {
           int mid=left+(right-left)/2;
           if(withinRange(nums,maxOperations,mid))
           {
            right=mid-1;
           } 
           else
           {
            left=mid+1;
           }
        }
    return left;
    }
}
