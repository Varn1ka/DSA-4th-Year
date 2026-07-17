public int minRemovals(int n, int m, int[] arrN, int[] arrM) {

    int[] req = new int[m + 1];
    int[] cnt = new int[m + 1];

    int need = 0;
    int total = 0;

    for (int i = 1; i <= m; i++) {
        req[i] = arrM[i - 1];
        total += req[i];
        if (req[i] > 0) need++;
    }

    int left = 0;
    int ans = Integer.MAX_VALUE;

    for (int right = 0; right < n; right++) {
        int c = arrN[right];

        cnt[c]++;
        if (cnt[c] == req[c]) need--;

        while (need == 0) {
            ans = Math.min(ans, right - left + 1);

            int x = arrN[left];
            if (cnt[x] == req[x]) need++;
            cnt[x]--;
            left++;
        }
    }

    if (ans == Integer.MAX_VALUE) return -1;

    return ans - total;
}
