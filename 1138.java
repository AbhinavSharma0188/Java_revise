class Solution {

    public String alphabetBoardPath(String target) {

        StringBuilder ans = new StringBuilder();

        int row = 0;
        int col = 0;

        for (char ch : target.toCharArray()) {

            int newRow = (ch - 'a') / 5;
            int newCol = (ch - 'a') % 5;

            // Move Left first
            while (col > newCol) {
                ans.append('L');
                col--;
            }

            // Move Up
            while (row > newRow) {
                ans.append('U');
                row--;
            }

            // Move Right
            while (col < newCol) {
                ans.append('R');
                col++;
            }

            // Move Down
            while (row < newRow) {
                ans.append('D');
                row++;
            }

            ans.append('!');
        }

        return ans.toString();
    }
}