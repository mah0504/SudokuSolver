public class SudokuSolver implements GameSolver {

    // attributes
    IntegerBoard board;
    IntegerBoard solution;
    Tree<IntegerBoard> treeDS;
    

    public SudokuSolver( GameBoard board ){
        this.board=solution; 
    }

    public boolean solve(){

        // rajouter le cas pr les dimensions illegales 

        
        if (!isValidSudoku()) {
            System.out.println("La grille de Sudoku initiale n'est pas valide.");
            return false;
        }
        return solveBoard();
    }


    public void printSolution(){

    }

    public boolean isValidPlacement( int row, int col, Integer value ){
        return false;
        // methode intermediaire pr verif si l'on peut mettre un nbr dans grille qlq selon les regles
    }

    // actual solver
    private boolean solveBoard(){
        return false;
    }


    public boolean validMiniGrid(){
    
        return false;
    }

    public boolean validHeightTrav(){
        return true;
    }


    public boolean validWidthTrav(){
        return false; 
    }

    public boolean isValidSudoku(){
        return validHeightTrav() && validHeightTrav() && validMiniGrid();
    }
}

