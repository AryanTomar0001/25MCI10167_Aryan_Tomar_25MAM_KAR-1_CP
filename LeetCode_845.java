class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int maxLen=0;
        for(int i=1;i<=n-2;i++){
            if(arr[i]>arr[i-1] && arr[i]> arr[i+1]){
                int left =i;
                int right=i;
                int count=1;
                while(left>0 && arr[left]>arr[left-1]){
                    count++;
                    left--;
                }
                while(right<n-1 && arr[right]>arr[right+1]){
                    count++;
                    right++;
                }
                maxLen=Math.max(maxLen,count);
                i=right;
            }
        }
        return maxLen;
    }
}
