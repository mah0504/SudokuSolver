import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver implements GameSolver {
    // Attributs
    private IntegerBoard board;       
    private IntegerBoard solution;    // Grille de solution
    private LinkedTree dsTree;  // Arbre contenant les grilles de type IntegerBoard


    // 

    
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


    public boolean validMiniGrid(GameBoard<Integer> board) {

        // iterer entre chaque sous grille 
        for (int grid = 0; grid < 9; grid++) {

            // reinitialiser le tab de verif apres chaque sous grille 
            boolean[] seen = new boolean[9]; // ttes les valeurs possibles de 1 à 9

            for (int cell = 0; cell < 9; cell++) {

                // Calcul des indices pour chaque sous-grille
                int row = 3 * (grid / 3) + cell / 3;
                int col = 3 * (grid % 3) + cell % 3;
    
                int current = board.getCell(row, col); 

                if (current != 0) { 
                    int num = current - 1;

                    // chaque index du tab stocké correspond à une valeur vue 

                    if (seen[num]) {
                        return false; // Doublon détecté
                    }
                    seen[num] = true;
                }
            }
        }
        return true;
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



    public static void main(String[] args) {
        System.out.println("*** Test Case 5 ***:");
        
        Integer[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 1, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        // Création de la grille et du résolveur
        GameBoard<Integer> board = new IntegerBoard<>(puzzle);
        SudokuSolver solver = new SudokuSolver(board);
        
        // Test de validité de la sous-grille
        boolean isValidMiniGrid = solver.validMiniGrid(board);
        System.out.println("La sous-grille est-elle valide ? " + isValidMiniGrid);
        
        // Résolution du puzzle
        solver.solve();
        
        // Affichage de la solution
        solver.printSolution();
    }
    
}
