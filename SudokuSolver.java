public class SudokuSolver implements GameSolver {

    // attributes
    GameBoard board;
    IntegerBoard solution;
    Tree<IntegerBoard> treeDS;
    
    

    public SudokuSolver( GameBoard<Integer> board ){
        this.board= board; 
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
        // methode intermediaire pr verif si l'on peut mettre 
        // un nbr dans grille qlq selon les regles
    }

    // actual solver
    private boolean solveBoard(){
        return isValidSudoku();
    }

    public boolean validMiniGrid(){
    
        return true;
    }

    public boolean validHeightTrav(){
        return true;
    }


    public boolean validWidthTrav(){
        return true; 
    }

    public boolean validSize(){
        System.out.println(board.getWidth());
        System.out.println(board.getHeight());
        return board.getHeight() ==board.getWidth()  ;

    }

    public boolean isValidSudoku(){
        
        return validHeightTrav() && validHeightTrav() && validMiniGrid() &&  validSize();
    }




}

