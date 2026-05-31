import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> list = new ArrayList<>();

            int idx = Arrays.binarySearch(products, prefix);
            if (idx < 0) idx = -idx - 1;

            for (int i = idx; i < products.length && list.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    list.add(products[i]);
                } else {
                    break;
                }
            }

            result.add(list);
        }

        return result;
    }
}