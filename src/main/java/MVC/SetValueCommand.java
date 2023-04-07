package MVC;

public class SetValueCommand extends SudokuCommand {
    private SudokuModel model;
    private int row;
    private int col;
    private int oldValue;
    private int newValue;

    public SetValueCommand(SudokuModel model, int row, int col, int newValue) {
        this.model = model;
        this.row = row;
        this.col = col;
        this.oldValue = model.getValueAt(row, col);
        this.newValue = newValue;
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