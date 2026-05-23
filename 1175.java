class Solution {
    public int numPrimeArrangements(int n) {
        int primes = countPrimes(n);
        int nonPrimes = n - primes;

        long mod = 1000000007;

        return (int)((factorial(primes, mod) * factorial(nonPrimes, mod)) % mod);
    }

    private int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private long factorial(int n, long mod) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }

        return result;
    }
}