package MVC;

import java.util.Stack;

public class SudokuController {
    private SudokuModel model;
    private SudokuView view;
    private SolverStrategy solver;
    private Stack<SudokuCommand> undoStack;
    private Stack<SudokuCommand> redoStack;

    public SudokuController(SudokuModel model, SudokuView view) {
        this.model = model;
        this.view = view;
        this.solver = new BacktrackingSolver();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void startGame() {
        model.registerObserver(view);
        view.display();
    }

    public void handleUserInput(int row, int col, int value) {
        if (model.isValueValid(row, col, value)) {
            SudokuCommand command = new SetValueCommand(model, row, col, value);
            undoStack.push(command);
            command.execute();
            redoStack.clear();
        } else {
            System.out.println("Invalid value. Please try again.");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            SudokuCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            SudokuCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}
