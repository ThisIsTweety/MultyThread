public class CalcThread extends Thread {
    private int startRow, endRow;
    private int[][] a, b, result;
    private int n;

    public CalcThread(int[][] a, int[][] b, int[][] result, int startRow, int endRow) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
        this.n = b.length;
    }

    @Override
    public void run() {
        System.out.println("Считаю со строки " + startRow + " до строки " + endRow + " включительно");
        for (int row = startRow; row <= endRow ; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = calcSingleValue(row, col);
            }
        }
    }

    private int calcSingleValue(int row, int col) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            c += a[row][i] * b[i][col];
        }
        return c;
    }

}