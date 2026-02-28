lass Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {
            // If i is a power of 2, number of bits increases by 1
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            result = ((result << bits) % MOD + i) % MOD;
        }

        return (int) result;
    }
}
