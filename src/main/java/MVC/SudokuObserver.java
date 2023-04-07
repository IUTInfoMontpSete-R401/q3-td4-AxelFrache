package MVC;

public interface SudokuObserver {
    void onValueChanged(int row, int col, int value);
}