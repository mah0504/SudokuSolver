import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Stack;

public class SudokuSolver implements GameSolver {
    // Attributs
    private IntegerBoard board;       
    private IntegerBoard solution;    
    private LinkedTree dsTree;  



    public SudokuSolver(GameBoard<Integer> board) {

            this.board = (IntegerBoard) board;  
            this.dsTree = new LinkedTree(this.board);  
            
    }
    
    public void printSolution(){

        if (solution != null) {
            solution.display();      
        } else {
            System.out.println("No solution found.");
        }
    
    }



    public boolean solve() {
        // Ajout de l'état initial à l'arbre
    
        if (solveBoard()) { 
            System.out.println("Solution trouvée !");
            return true;
        } else {
            System.out.println(":(  pas de solution ");
            return false;
        }
    }
    

private boolean solveBoard() {
    
    // System.out.println(getPossibleValues(board,  0, 2)) ;

    for (int row = 0; row < board.getHeight(); row++) {
        for (int col = 0; col < board.getWidth(); col++) {

            if (board.getCell(row, col).equals(0)) { 

                for (int value = 1; value <= 9; value++) {
                    if (isValidPlacement(row, col, value)) {
                        board.setCell(row, col, value); 

                        if (solveBoard()) {
                            return true; 
                        }

                        board.setCell(row, col, 0);
                    }
                }
                return false; 
            }
        }
    }
    return true; 
}


public List<Integer> getPossibleValues( IntegerBoard board , int row , int cols ){
    List<Integer> possiblevalues= new ArrayList<>();
            if (board.getCell(row, cols).equals(0)) { 

                for (int l = 1; l <= 9; l++) {
                    if (isValidPlacement(row, cols, l)) {
                        possiblevalues.add(l);
                    }
                }
            }
        return possiblevalues;


 }




// marche correctement normalement
public boolean isValidPlacement( int row, int col, Integer value) {
    // Vérifier la ligne
    for (int j = 0; j < board.getWidth(); j++) {
        if (board.getCell(row, j) == value) {
            return false;
        }
    }

    // Vérifier la colonne
    for (int i = 0; i < board.getHeight(); i++) {
        if (board.getCell(i, col) == value) {
            return false;
        }
    }

    // Vérifier la sous-grille
    int startRow = 3 * (row / 3);
    int startCol = 3 * (col / 3);
    for (int i = startRow; i < startRow + 3; i++) {
        for (int j = startCol; j < startCol + 3; j++) {
            if (board.getCell(i, j) == value) {
                return false;
            }
        }
    }

    return true;
}



}