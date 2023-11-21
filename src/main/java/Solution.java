import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long diff = (long) ((long) nums[i] - (long) reverse(nums[i]));
            int counter = map.getOrDefault(diff, 0);
            counter++;
            map.put(diff, counter);
        }
        int mod = 1_000_000_007;
        int result = 0;

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                result = result + (count(e.getValue()) % mod) % mod;
            }
        }
        return result % mod;

    }

    private int reverse(int x) {
        StringBuilder sb = new StringBuilder("" + x);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    private int count(int n) {
        long result = (1L * n * (n - 1) / 2) % 1_000_000_007;
        return (int) result;
    }
}