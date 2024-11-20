import java.util.ArrayList;
import java.util.List;

public class SudokuSolver implements GameSolver {
    // Attributs
    private IntegerBoard board;       
    private IntegerBoard solution;    // Grille de solution
    private LinkedTree dsTree;  // Arbre contenant les grilles de type IntegerBoard


    // parcourir jusqu'a trv une cell vide 
    // mettre lst des possibilites de cette cell dans  un tab -> nvls positions ??? 

    // creer len(tab) nv noeuds avec les possibilites possibles 
    // refaire 
    // s'arreter lors de trv solu
    // si contrainte -> supp ts les noeufs qui sont enfants uniques 


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
        
        System.out.println( " Les noeufs enfants "); 

        // for (Position<IntegerBoard> child : dsTree.children(dsTree.root()) ) {
        //     IntegerBoard childBoard = child.getElement();
        //     System.out.println("Grille enfant:");
        //     childBoard.display();
        //     System.out.println(); // Ligne vide entre les grilles pour lisibilité
        // }

        

    }

    // Méthode pour résoudre la grille
    public boolean solve(){
    
        List<Integer> lst = new ArrayList<>();

        if (!isValidSudoku()) {
            System.out.println("La grille de Sudoku initiale n'est pas valide.");

            return false;
        }
        else {
            System.out.println("valid fr fr "); 
            for( int i =0 ; i<board.getWidth(); i++){
                for ( int j = 0 ;j<board.getHeight();j++){
                    
                    // System.out.println( board.getCell(i, j));
                    // System.out.println(board.getCell(i, j).equals(0) );
    
    
                    if ( board.getCell(i, j).equals(0) ){
                        lst.clear();

                        // possib  de 1 a 10

                        for(int l =1 ; l<10; l++){
    
                            board.setCell(i, j, l); // on change ? 
    
                           if ( isValidPlacement(i,j,l) ) { 
                            lst.add(l); 
    
                            // dsTree.addChild(dsTree.root(), board); 
    
                            // cree enfant avec nvl grid 
                            // bla bla bla bla 
                           } else {
    
                            board.setCell(i, j,0 );
                           }
    
    
                        }
                        // System.out.println(lst); 

                    } else {
                        continue; 
                    } 
                    
                    // System.out.println(lst); 
    
                } 
            }

        }

        return solveBoard();
    }



public boolean isValidPlacement(int x, int y, Integer value) {
    // Vérifier la ligne
    for (int j = 0; j < board.getWidth(); j++) {
        if (board.getCell(x, j) == value) {
            return false;
        }
    }

    // Vérifier la colonne
    for (int i = 0; i < board.getHeight(); i++) {
        if (board.getCell(i, y) == value) {
            return false;
        }
    }

    // Vérifier la sous-grille
    int ligne = 3 * (x / 3);
    int colonne = 3 * (y / 3);

    for (int i = ligne; i < ligne + 3; i++) {
        for (int j = colonne; j < colonne  + 3; j++) {
            if (board.getCell(i, j) == value) {
                return false;
            }
        }
    }
    return true;
}



        // System.out.println("valid mini grid " +validMiniGrid(board)); 
        // System.out.println("valid height trav"+  validHeightTrav(board) );
        // System.out.println( "valid width trav"+ validWidthTrav(board));

        // return validMiniGrid(board) && validHeightTrav(board) &&  validWidthTrav(board);
    private boolean solveBoard(){
        return isValidSudoku();
    }


    // public boolean validMiniGrid(GameBoard<Integer> board) {

    //     // iterer entre chaque sous grille 
    //     for (int grid = 0; grid < 9; grid++) {

    //         // reinitialiser le tab de verif apres chaque sous grille 
    //         boolean[] seen = new boolean[9]; // ttes les valeurs possibles de 1 à 9

    //         for (int cell = 0; cell < 9; cell++) {

    //             // Calcul des indices pour chaque sous-grille
    //             int row = 3 * (grid / 3) + cell / 3;
    //             int col = 3 * (grid % 3) + cell % 3;
    
    //             int current = board.getCell(row, col); 

    //             if (current != 0) { 
    //                 int num = current - 1;

    //                 // chaque index du tab stocké correspond à une valeur vue 

    //                 if (seen[num]) {
    //                     return false; // Doublon détecté
    //                 }
    //                 seen[num] = true;
    //             }
    //         }
    //     }
    //     return true;
    // }
    

    // public boolean validHeightTrav(GameBoard<Integer> board){
    //     List<Integer> lst = new ArrayList<>();

    //     // System.out.println(board.getHeight());
    //     // System.out.println(board.getWidth());

    //     for ( int i =0; i <board.getHeight(); i++){
    //         for ( int j=0; j<board.getWidth();j++){

    //              if ( !( lst.contains(board.getCell(i, j))) && board.getCell(i, j)!=0 ){

    //                // System.out.println(board.getCell(j, i));

    //                  lst.add( board.getCell(j, i));

    //        } else if ( board.getCell(i, j)==0){
    //         // lst.add( board.getCell(j, i));
    //         continue;

    //        } 
    //        else {
    //         // System.out.println(lst);
    //         // System.out.println(" element invalide est height: " +board.getCell(j, i));
    //         return false; 
    //        }

    //     }
    //     lst.clear() ;

    //     }
        
    //     return true;
    // }


    // public boolean validWidthTrav(GameBoard<Integer> board){
    //     List<Integer> lst = new ArrayList<>();

    //     for ( int i =0 ; i<board.getWidth();i++){
    //         for( int j=0; j<board.getHeight(); j++){
    //             // System.out.println("element" + board.getCell(i, j));
                
    //             if ( !( lst.contains(board.getCell(i, j)))  && board.getCell(i, j)!= 0 ){
    //                 lst.add( board.getCell(i, j));
    //                 // System.out.println(lst);

    //             } else if ( board.getCell(i, j)==0){
    //             //  lst.add( board.getCell(i, j));
    //                 continue;
     
    //             } 
    //             else {
    //             //   System.out.println(lst);
    //             //   System.out.println(" element invalide est : " +board.getCell(i, j));
    //              return false; 
    //             }
     
    //          }
    //          lst.clear() ;
     
    //          }
    //          return true;

    // }


    // Vérifie si la grille a la taille correcte
    public boolean validSize(){
        return board.getHeight() == board.getWidth();
    }

    // Vérifie si la grille de Sudoku est valide


    public boolean isValidSudoku() {
        // Parcours de la grille
        for (int x = 0; x < board.getHeight(); x++) {
            for (int y = 0; y < board.getWidth(); y++) {

                Object currentValue = board.getCell(x, y);
                
                if (currentValue == null || (Integer) currentValue == 0) {
                    continue;
                }
    
                // Retirer temporairement la valeur de la cellule pour vérifier la validité
                Integer originalValue = (Integer) currentValue;
                board.setCell(x, y, 0);
    
                // Vérifier si l'ajout de cette valeur induirait une contradiction
                boolean isValid = isValidPlacement(x, y, originalValue);
                // System.out.print("Checking validity for " + originalValue + ": " + isValid);
    
                // Restaurer la valeur originale
                board.setCell(x, y, originalValue);
        
                if (!isValid) {
                    return false; // Contradiction trouvée
                }
            }
        }
        return true; // La grille est valide
    }
    

        // System.out.println("valid mini grid " +validMiniGrid(board)); 
        // System.out.println("valid height trav"+  validHeightTrav(board) );
        // System.out.println( "valid width trav"+ validWidthTrav(board));

        // return validMiniGrid(board) && validHeightTrav(board) &&  validWidthTrav(board);


        // la logique relies on enlever l,elem deja place et voir si essayer de le remettre 
        // nous induit en contradiction 

        

    // methode main intermediaire car flm autre fichier each time 
    public static void main(String[] args) {
        System.out.println("*** Test Case 5 ***:");
        
        Integer[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        
        GameBoard<Integer> board = new IntegerBoard<>(puzzle);
        SudokuSolver solver = new SudokuSolver(board);
        
        
        // Résolution du puzzle
        solver.solve();
        // board.setCell(0, 2, 8);
        //  board.display();


        // System.out.println ;

        // Affichage de la solution
        solver.printSolution();
    }
    
}
