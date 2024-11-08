import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SudokuSolver implements GameSolver {
// Attributs
private IntegerBoard board;       // Grille de départ
private IntegerBoard solution;    // Grille de solution
private Arbre<IntegerBoard> dsTree;  // Arbre contenant les grilles de type IntegerBoard




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
//        rootBoard.display();
        
    }

   

    public boolean solve(){

        // rajouter le cas pr les dimensions illegales 

        if (!isValidSudoku()) {
          //  System.out.println("La grille de Sudoku initiale n'est pas valide.");
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

    // faire en sorte que ca fonctionne pr ttes les minigrid pas juste la premiere -> modulo ? 
    public boolean validMiniGrid(GameBoard<Integer> board){

        List<Integer> lst = new ArrayList<>();

        for ( int i =0; i<3 ; i++){

// modifier pr cas general apres ou la grid = tiers dim du jeu  -> sqrt ? 

            for ( int j=0; j< 3 ; j++){

                if ( ! lst.contains(board.getCell(i, j)) ){
                    // lst.add( board.getCell(i, j));
            } 
            System.out.print(board.getCell(i, j));
            return false;

        }
    }
    return true ;

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

// fct correctement 

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

     public boolean validSize(){
    //     System.out.println(board.getWidth());
    //     System.out.println(board.getHeight());
        return board.getHeight() ==board.getWidth()  ;

    }

    public boolean isValidSudoku(){
       // System.out.println( validMiniGrid(board)); 


      
    //    System.err.println(validHeightTrav(board));
    //    System.out.println(validWidthTrav(board));

        return validWidthTrav(board)
        && validHeightTrav(board);

        // && validMiniGrid(board);
        // &&  validSize()
    }





}