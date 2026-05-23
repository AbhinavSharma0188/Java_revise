class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();

        class Transaction {
            String name, city, original;
            int time, amount;

            Transaction(String s) {
                original = s;
                String[] parts = s.split(",");
                name = parts[0];
                time = Integer.parseInt(parts[1]);
                amount = Integer.parseInt(parts[2]);
                city = parts[3];
            }
        }

        int n = transactions.length;
        Transaction[] arr = new Transaction[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Transaction(transactions[i]);
        }

        for (int i = 0; i < n; i++) {
            boolean invalid = false;

            if (arr[i].amount > 1000) {
                invalid = true;
            }

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (arr[i].name.equals(arr[j].name) &&
                    !arr[i].city.equals(arr[j].city) &&
                    Math.abs(arr[i].time - arr[j].time) <= 60) {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                result.add(arr[i].original);
            }
        }

        return result;
    }
}