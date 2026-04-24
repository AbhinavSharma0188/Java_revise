class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String expr, Map<String, Integer> map) {
        if (expr.charAt(0) != '(') {
            if (Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-') {
                return Integer.parseInt(expr);
            }
            return map.get(expr);
        }

        Map<String, Integer> newMap = new HashMap<>(map);
        String inner = expr.substring(1, expr.length() - 1);
        List<String> tokens = parse(inner);

        if (tokens.get(0).equals("add")) {
            return eval(tokens.get(1), newMap) + eval(tokens.get(2), newMap);
        } else if (tokens.get(0).equals("mult")) {
            return eval(tokens.get(1), newMap) * eval(tokens.get(2), newMap);
        } else {
            for (int i = 1; i < tokens.size() - 1; i += 2) {
                newMap.put(tokens.get(i), eval(tokens.get(i + 1), newMap));
            }
            return eval(tokens.get(tokens.size() - 1), newMap);
        }
    }

    private List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        int i = 0, n = s.length();

        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (s.charAt(i) == '(') {
                int count = 0;
                int j = i;
                while (j < n) {
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                    if (count == 0) break;
                    j++;
                }
                res.add(s.substring(i, j + 1));
                i = j + 1;
            } else {
                int j = i;
                while (j < n && s.charAt(j) != ' ') j++;
                res.add(s.substring(i, j));
                i = j;
            }
        }

        return res;
    }
}