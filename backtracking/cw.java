class cw {
    public static void main(String[] args) {
        int row = 2;
        int col = 2;
        int path = mazepath(0, 0, row - 1, col - 1);
        System.out.println(path);
    }

    public static int mazepath(int srcrow, int srccol, int destrow, int destcol) {
        if (srcrow > destrow || srccol > destcol) {
            return 0;
        }
        if (srcrow == destrow && srccol == destcol) {
            return 1;
        }

        int path = mazepath(srcrow + 1, srccol, destrow, destcol)
                 + mazepath(srcrow, srccol + 1, destrow, destcol);
        return path;
    }
}
