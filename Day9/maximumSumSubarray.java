public static long maximumSumSubarray(long[] nums, long k) {
    int n = nums.length;

    if (k > n) return 0;

    long windowSum = 0;

    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }

    long maxSum = windowSum;

    for (int i = (int) k; i < n; i++) {
        windowSum += nums[i];
        windowSum -= nums[i - (int) k];
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
