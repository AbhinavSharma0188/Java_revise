class Solution {
    public int maxDiff(int num) {
        String maxStr = String.valueOf(num);
        String minStr = String.valueOf(num);

        // Create maximum number
        for (char c : maxStr.toCharArray()) {
            if (c != '9') {
                maxStr = maxStr.replace(c, '9');
                break;
            }
        }

        // Create minimum number
        if (minStr.charAt(0) != '1') {
            minStr = minStr.replace(minStr.charAt(0), '1');
        } else {
            for (int i = 1; i < minStr.length(); i++) {
                char c = minStr.charAt(i);
                if (c != '0' && c != '1') {
                    minStr = minStr.replace(c, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}