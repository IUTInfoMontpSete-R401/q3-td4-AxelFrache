package MVC;

import java.util.Scanner;

import java.util.Scanner;

public class SudokuApp {
    public static void main(String[] args) {
        int boardSize = 9; // Vous pouvez définir la taille du plateau ici
        SudokuModel model = new SudokuModel(boardSize);
        SudokuView view = new SudokuView(model);
        SudokuController controller = new SudokuController(model, view);

        Scanner scanner = new Scanner(System.in);
        controller.startGame();

        while (true) {
            System.out.println("Entrez 'ligne colonne valeur' pour insérer une valeur, 'U' pour annuler, 'R' pour rétablir ou 'Q' pour quitter :");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Q")) {
                break;
            } else if (input.equalsIgnoreCase("U")) {
                controller.undo();
            } else if (input.equalsIgnoreCase("R")) {
                controller.redo();
            } else {
                String[] parts = input.split(" ");
                if (parts.length == 3) {
                    try {
                        int row = Integer.parseInt(parts[0]);
                        int col = Integer.parseInt(parts[1]);
                        int value = Integer.parseInt(parts[2]);
                        controller.handleUserInput(row, col, value);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrée invalide. Veuillez réessayer.");
                    }
                } else {
                    System.out.println("Entrée invalide. Veuillez réessayer.");
                }
            }
        }
    }
}
