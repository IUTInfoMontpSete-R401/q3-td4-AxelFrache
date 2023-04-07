package MVC;

public class BacktrackingSolver implements SolverStrategy {

    @Override
    public boolean solve(SudokuModel model) {
        return solveCell(0, 0, model);
    }

    private boolean solveCell(int row, int col, SudokuModel model) {
        // Si on a parcouru toutes les cellules, la grille est résolue
        if (row == model.getBoardSize()) {
            return true;
        }

        // Calcul de la prochaine cellule à traiter
        int nextRow = col == model.getBoardSize() - 1 ? row + 1 : row;
        int nextColumn = (col + 1) % model.getBoardSize();

        // Si la cellule actuelle est déjà remplie, passer à la suivante
        if (model.getValueAt(row, col) != 0) {
            return solveCell(nextRow, nextColumn, model);
        }

        // Essayer toutes les valeurs possibles pour la cellule actuelle
        for (int value = 1; value <= model.getBoardSize(); value++) {
            if (model.isValueValid(row, col, value)) {
                // Assigner la valeur à la cellule
                model.setValueAt(row, col, value);

                // Récursivement résoudre la grille à partir de la cellule suivante
                if (solveCell(nextRow, nextColumn, model)) {
                    return true;
                }

                // Si la résolution a échoué, retirer la valeur de la cellule
                model.setValueAt(row, col, 0);
            }
        }

        // Si aucune valeur n'a fonctionné, revenir en arrière
        return false;
    }
}
