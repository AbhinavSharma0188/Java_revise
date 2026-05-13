class Solution {
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(convert(s) - convert(t)) < 1e-12;
    }

    private double convert(String s) {
        if (!s.contains("(")) {
            return Double.parseDouble(s);
        }

        int start = s.indexOf('(');
        int end = s.indexOf(')');

        String nonRepeat = s.substring(0, start);
        String repeat = s.substring(start + 1, end);

        double base = nonRepeat.isEmpty() ? 0 : Double.parseDouble(nonRepeat);

        double repeating = Integer.parseInt(repeat) /
                (Math.pow(10, repeat.length()) - 1);

        repeating /= Math.pow(10, nonRepeat.contains(".")
                ? nonRepeat.length() - nonRepeat.indexOf('.') - 1
                : 0);

        return base + repeating;
    }
}