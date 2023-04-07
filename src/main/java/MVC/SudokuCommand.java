package MVC;

public abstract class SudokuCommand {
    public abstract void execute();
    public abstract void undo();
}