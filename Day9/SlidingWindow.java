public List<Integer> solve(int N, int[] arr, int target) {
    List<Integer> ans = new ArrayList<>();

    int start = 0;
    int sum = 0;

    for (int end = 0; end < N; end++) {
        sum += arr[end];

        while (sum > target && start <= end) {
            sum -= arr[start];
            start++;
        }

        if (sum == target) {
            ans.add(start + 1); 
            ans.add(end + 1);  
            return ans;
        }
    }

    ans.add(-1);
    return ans;
}
