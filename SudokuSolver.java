import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver implements GameSolver {
    // Attributs
    private IntegerBoard board;       
    private IntegerBoard solution;    // Grille de solution
    private LinkedTree dsTree;  // Arbre contenant les grilles de type IntegerBoard



    public SudokuSolver(GameBoard<Integer> board) {
        // if (board instanceof IntegerBoard) {


            this.board = (IntegerBoard) board;  // Cast en IntegerBoard
            this.dsTree = new LinkedTree(this.board);  
            
    
            
        // } else {
        //     throw new IllegalArgumentException("Le board doit être de type IntegerBoard");
        // }
    }
    

    // Méthode pour afficher la solution
    public void printSolution(){
    
        IntegerBoard rootBoard = dsTree.root().getElement();
        System.out.println("Grille de la racine de l'arbre:");
        rootBoard.display();

    }

    // Méthode pour résoudre la grille
    public boolean solve(){
        if (!isValidSudoku()) {
            // System.out.println("La grille de Sudoku initiale n'est pas valide.");
            return false;
        }
        return solveBoard();
    }

    // Vérifie si une valeur est valide pour un placement
    public boolean isValidPlacement(int row, int col, Integer value){
        return false;
    }

    private boolean solveBoard(){
        return isValidSudoku();
    }

    public boolean validMiniGrid(GameBoard<Integer> board){
        return false;
    }

    public boolean validHeightTrav(GameBoard<Integer> board){
        List<Integer> lst = new ArrayList<>();

        // System.out.println(board.getHeight());
        // System.out.println(board.getWidth());

        for ( int i =0; i <board.getHeight(); i++){
            for ( int j=0; j<board.getWidth();j++){

                 if ( !( lst.contains(board.getCell(i, j)))  ){

                   // System.out.println(board.getCell(j, i));

                     lst.add( board.getCell(j, i));

           } else if ( board.getCell(i, j)==0){
            lst.add( board.getCell(j, i));

           } 
           else {
           // System.out.println(lst);
           // System.out.println(" element invalide est : " +board.getCell(j, i));
            return false; 
           }

        }
        lst.clear() ;

        }
        
        return true;
    }


    public boolean validWidthTrav(GameBoard<Integer> board){
        List<Integer> lst = new ArrayList<>();

        for ( int i =0 ; i<board.getWidth();i++){
            for( int j=0; j<board.getHeight(); j++){
                
                if ( !( lst.contains(board.getCell(i, j)))  ){
                    lst.add( board.getCell(i, j));
                    // System.out.println(lst);

                } else if ( board.getCell(i, j)==0){

                 lst.add( board.getCell(i, j));
     
                } 
                else {
                //  System.out.println(lst);
                //  System.out.println(" element invalide est : " +board.getCell(i, j));
                 return false; 
                }
     
             }
             lst.clear() ;
     
             }
             return true;

    }


    // Vérifie si la grille a la taille correcte
    public boolean validSize(){
        return board.getHeight() == board.getWidth();
    }

    // Vérifie si la grille de Sudoku est valide
    public boolean isValidSudoku(){
        return validMiniGrid(board) && validHeightTrav(board) && validWidthTrav(board) && validSize();
    }
}
