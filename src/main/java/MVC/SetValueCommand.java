package MVC;

public class SetValueCommand implements SudokuCommand {
    private SudokuModel model;
    private int row;
    private int col;
    private int newValue;
    private int oldValue;

    public SetValueCommand(SudokuModel model, int row, int col, int newValue) {
        this.model = model;
        this.row = row;
        this.col = col;
        this.newValue = newValue;
        this.oldValue = model.getValueAt(row, col);
    }

    @Override
    public void execute() {
        model.setValueAt(row, col, newValue);
    }

    @Override
    public void undo() {
        model.setValueAt(row, col, oldValue);
    }
}
