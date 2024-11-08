

public class SudokuSolver implements GameSolver {
// Attributs
private IntegerBoard board;       // Grille de départ
private IntegerBoard solution;    // Grille de solution
private Arbre<IntegerBoard> dsTree;  // Arbre contenant les grilles de type IntegerBoard

// Constructeur
public SudokuSolver(GameBoard<Integer> board) {
    if (board instanceof IntegerBoard) {
        this.board = (IntegerBoard) board;  // Cast en IntegerBoard
    } else {
        throw new IllegalArgumentException("Le board doit être de type IntegerBoard");
    }
    this.solution = null;  // Initialisation de la grille de solution si nécessaire
    this.dsTree = new Arbre<>(new Noeud(this.board));  // Initialise l’arbre avec le noeud de la grille de départ
}

    public void printSolution(){


        // Récupère la racine de l'arbre et affiche la grille
        IntegerBoard rootBoard = dsTree.getRacine().getBoard();
        System.out.println("Grille de la racine de l'arbre:");
        rootBoard.display();
        
    }

    // validate an insertion in the board




    public boolean solve(){

        // rajouter le cas pr les dimensions illegales 

        if (!isValidSudoku()) {
            System.out.println("La grille de Sudoku initiale n'est pas valide.");
            return false;
        }
        return solveBoard();
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

    public boolean validMiniGrid(GameBoard<Integer> board){
    
        return true;
    }

    public boolean validHeightTrav(GameBoard<Integer> board){
        // 
        return true;
    }


    public boolean validWidthTrav(GameBoard<Integer> board){
        return true; 
    }

    public boolean validSize(){
        System.out.println(board.getWidth());
        System.out.println(board.getHeight());
        return board.getHeight() ==board.getWidth()  ;

    }

    public boolean isValidSudoku(){
        
        return validHeightTrav(board) && validHeightTrav(board) && validMiniGrid(board) &&  validSize();
    }





}