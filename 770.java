class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> eval = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            eval.put(evalvars[i], evalints[i]);
        }
        return parse(expression, eval).toList();
    }

    class Poly {
        Map<List<String>, Integer> map = new HashMap<>();

        Poly() {}

        Poly(int val) {
            map.put(new ArrayList<>(), val);
        }

        Poly(String var) {
            List<String> list = new ArrayList<>();
            list.add(var);
            map.put(list, 1);
        }

        Poly add(Poly other, int sign) {
            for (List<String> k : other.map.keySet()) {
                map.put(k, map.getOrDefault(k, 0) + sign * other.map.get(k));
                if (map.get(k) == 0) map.remove(k);
            }
            return this;
        }

        Poly mul(Poly other) {
            Map<List<String>, Integer> res = new HashMap<>();
            for (List<String> a : map.keySet()) {
                for (List<String> b : other.map.keySet()) {
                    List<String> merged = new ArrayList<>(a);
                    merged.addAll(b);
                    Collections.sort(merged);
                    res.put(merged, res.getOrDefault(merged, 0) + map.get(a) * other.map.get(b));
                }
            }
            map = res;
            return this;
        }

        List<String> toList() {
            List<String> res = new ArrayList<>();
            List<List<String>> keys = new ArrayList<>(map.keySet());

            Collections.sort(keys, (a, b) -> {
                if (a.size() != b.size()) return b.size() - a.size();
                return String.join("*", a).compareTo(String.join("*", b));
            });

            for (List<String> k : keys) {
                int coef = map.get(k);
                StringBuilder sb = new StringBuilder();
                sb.append(coef);
                for (String v : k) {
                    sb.append("*").append(v);
                }
                res.add(sb.toString());
            }

            return res;
        }
    }

    private Poly parse(String s, Map<String, Integer> eval) {
        List<Poly> stack = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(i) == '(') {
                int bal = 0, j = i;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == '(') bal++;
                    if (s.charAt(j) == ')') bal--;
                    if (bal == 0) break;
                }
                stack.add(parse(s.substring(i + 1, j), eval));
                i = j + 1;
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                int val = Integer.parseInt(s.substring(i, j));
                stack.add(new Poly(val));
                i = j;
            } else if (Character.isLetter(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isLetter(s.charAt(j))) j++;
                String var = s.substring(i, j);
                if (eval.containsKey(var)) {
                    stack.add(new Poly(eval.get(var)));
                } else {
                    stack.add(new Poly(var));
                }
                i = j;
            } else {
                ops.add(s.charAt(i));
                i++;
            }
        }

        for (int j = 0; j < ops.size();) {
            if (ops.get(j) == '*') {
                Poly left = stack.remove(j);
                Poly right = stack.remove(j);
                stack.add(j, left.mul(right));
                ops.remove(j);
            } else {
                j++;
            }
        }

        Poly res = stack.get(0);
        for (int j = 0; j < ops.size(); j++) {
            if (ops.get(j) == '+') {
                res.add(stack.get(j + 1), 1);
            } else {
                res.add(stack.get(j + 1), -1);
            }
        }

        return res;
    }
}