package MVC;

public class SudokuCellView implements SudokuObserver {
    private int row;
    private int col;
    private int value;

    public SudokuCellView(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void onValueChanged(int row, int col, int value) {
        if (this.row == row && this.col == col) {
            this.value = value;
            display();
        }
    }

    public void display() {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
    }
}