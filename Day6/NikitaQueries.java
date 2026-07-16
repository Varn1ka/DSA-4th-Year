import java.util.*;

public class Main {

    static class Solution {

        public List<Integer> specialXOR(int n, int Q, int[] a, int[][] query) {

            List<Integer> ans = new ArrayList<>();

            int xor = 0;
            for (int x : a) {
                xor ^= x;
            }

            int[] pre = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] ^ a[i - 1];
            }

            for (int i = 0; i < Q; i++) {
                int l = query[i][0];
                int r = query[i][1];
                int inside = pre[r] ^ pre[l-1];
               ans.add(xor ^ inside);
                
            }

            return ans;
        }
    }
}
