package MVC;

import java.util.List;
import java.util.Scanner;

public class SudokuController {
    private SudokuModel model;
    private SudokuView view;
    private List<SudokuCommand> commandHistory;
    private List<SudokuCommand> undoneCommands;

    public SudokuController(SudokuModel model, SudokuView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        // Initialize the game with a predefined board or generate a new board
        // ...
        view.updateAll();
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (!model.isGameFinished()) {
            System.out.println("Enter row number (1-" + model.getBoardSize() + "):");
            int row = scanner.nextInt() - 1; // Convert to 0-based indexing
            System.out.println("Enter column number (1-" + model.getBoardSize() + "):");
            int col = scanner.nextInt() - 1; // Convert to 0-based indexing
            System.out.print("Enter value (1-" + model.getBoardSize() + "): ");
            int value = scanner.nextInt();

            if (model.isValueValid(row, col, value)) {
                model.setValueAt(row, col, value);
                view.updateAll();
            } else {
                System.out.println("Invalid value. Please try again.");
            }
        }
        view.displayVictoryMessage();
    }

    public void handleUserInput(int row, int col, int value) {
        if (model.isValueValid(row, col, value)) {
            model.setValueAt(row, col, value);
        } else {
            System.out.println("Invalid value. Please try again.");
        }
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            SudokuCommand lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
            undoneCommands.add(lastCommand);
        }
    }

    public void redo() {
        if (!undoneCommands.isEmpty()) {
            SudokuCommand lastUndoneCommand = undoneCommands.remove(undoneCommands.size() - 1);
            lastUndoneCommand.execute();
            commandHistory.add(lastUndoneCommand);
        }
    }


}
