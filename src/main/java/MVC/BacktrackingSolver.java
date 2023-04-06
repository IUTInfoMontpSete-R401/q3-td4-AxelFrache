package MVC;

public class BacktrackingSolver implements SudokuSolverStrategy {
    @Override
    public boolean solve(SudokuModel model) {
        return solveCell(0, 0, model);
    }

    private boolean solveCell(int row, int column, SudokuModel model) {
        if (row == model.getBoardSize()) {
            return true;
        }

        int nextRow = column == model.getBoardSize() - 1 ? row + 1 : row;
        int nextColumn = (column + 1) % model.getBoardSize();

        if (model.getValueAt(row, column) != 0) {
            return solveCell(nextRow, nextColumn, model);
        }

        for (int value = 1; value <= model.getBoardSize(); value++) {
            if (model.isValueValid(row, column, value)) {
                model.setValueAt(row, column, value);
                if (solveCell(nextRow, nextColumn, model)) {
                    return true;
                }
                model.setValueAt(row, column, 0);
            }
        }
        return false;
    }


}
