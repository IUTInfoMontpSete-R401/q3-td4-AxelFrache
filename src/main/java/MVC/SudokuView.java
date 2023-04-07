package MVC;

import java.util.ArrayList;
import java.util.List;

public class SudokuView implements SudokuObserver {
    private SudokuModel model;
    private List<SudokuCellView> cellViews;

    public SudokuView(SudokuModel model) {
        this.model = model;
        cellViews = new ArrayList<>();
        for (int row = 0; row < model.getBoardSize(); row++) {
            for (int col = 0; col < model.getBoardSize(); col++) {
                SudokuCellView cellView = new SudokuCellView(row, col);
                cellViews.add(cellView);
                model.registerObserver(cellView);
            }
        }
    }

    @Override
    public void onValueChanged(int row, int col, int value) {
        display();
        if (model.isGameFinished()) {
            displayVictoryMessage();
        }
    }

    public void display() {
        int blockSize = (int) Math.sqrt(model.getBoardSize());

        for (int row = 0; row < model.getBoardSize(); row++) {
            if (row % blockSize == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < model.getBoardSize(); col++) {
                if (col % blockSize == 0) {
                    System.out.print("| ");
                }
                int value = model.getValueAt(row, col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }
}
