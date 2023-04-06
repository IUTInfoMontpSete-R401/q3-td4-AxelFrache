
package MVC;

public class SudokuView {
    private SudokuModel model;
    private SudokuCellView[][] cellViews;

    public SudokuView(SudokuModel model) {
        this.model = model;
        int boardSize = model.getBoardSize();
        cellViews = new SudokuCellView[boardSize][boardSize];

        // Initialiser les SudokuCellView et les enregistrer en tant qu'observateurs
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                cellViews[row][col] = new SudokuCellView(row, col);
                model.registerObserver(cellViews[row][col]);
            }
        }
    }

    public void update(int row, int col) {
        // Get the value from the model
        int value = model.getValueAt(row, col);

        // Update the corresponding SudokuCellView
        cellViews[row][col].update(row, col, value);
    }

    public void updateAll() {
        for (int row = 0; row < model.getBoardSize(); row++) {
            for (int col = 0; col < model.getBoardSize(); col++) {
                int value = model.getValueAt(row, col);
                cellViews[row][col].update(row, col, value);
            }
        }
    }



    public void displayVictoryMessage() {
        System.out.println("Félicitations, vous avez gagné !");
    }

    // Méthode pour afficher l'ensemble du plateau de jeu
    public void display() {
        int boardSize = model.getBoardSize();
        int blockSize = model.getBlockSize();

        for (int row = 0; row < boardSize; row++) {
            if (row % blockSize == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < boardSize; col++) {
                if (col % blockSize == 0) {
                    System.out.print("| ");
                }
                cellViews[row][col].display();
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
