import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        

        Iterable<Position<IntegerBoard>> children = dsTree.children(dsTree.root());
        for (Position<IntegerBoard> child : children) {
            IntegerBoard childBoard = child.getElement();
            System.out.println("Grille enfant:");
            childBoard.display();
            System.out.println(); // Ligne vide entre les grilles pour lisibilité
        }

        

    }

    public boolean solve() {

        if (!isValidSudoku()) {
            System.out.println("La grille de Sudoku initiale n'est pas valide...");
            return false;
        }
    
        Queue<Node> queue = new LinkedList<>();  
        Node root = new Node(board, null);  
        queue.add(root);  

        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();  
            IntegerBoard currentBoard = currentNode.getElement();  


            if (isComplete(currentBoard)) {
                System.out.println("Solution trouvée !");
                return true;  
            }
    
            for (int i = 0; i < board.getHeight(); i++) {
                for (int j = 0; j < board.getWidth(); j++) {

                    if (currentBoard.getCell(i, j).equals(0)) {

                        for (int val = 1; val <= 9; val++) {
                            if (isValidPlacement(i, j, val)) {


                                // optimiser la copie ??? 
                                
                                IntegerBoard newBoard = currentBoard.copy();  
                                newBoard.setCell(i, j, val);  


                                Node childNode = new Node(newBoard, currentNode);
                                queue.add(childNode);  
                            }
                        }
                        return false;  
                    } 
                    break;
                }
            }
        } // queue pas empty 
    
        
        System.out.println("Aucune solution trouvée.");
        return false;  
    }
    

    private boolean isComplete(IntegerBoard board) {
        // Vérifiez si la grille est entièrement remplie et valide
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.getCell(i, j).equals(0) ) {
                    return false; // Une case vide reste
                }
            }
        }
        return true;
    }


    

    // marche correctement :)
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



        // return validMiniGrid(board) && validHeightTrav(board) &&  validWidthTrav(board);
    private boolean solveBoard(){
        return isValidSudoku();
    }


 

    public void displayPossibleValues() {

        List<List<Integer>> possibleValuesForEachCell = new ArrayList<>();

        // Parcours de la grille
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.getCell(i, j).equals(0)) { // Si la case est vide
                    List<Integer> possibleValues = new ArrayList<>();
                    
                    for (int value = 1; value <= 9; value++) {
                        if (isValidPlacement(i, j, value)) {
                            possibleValues.add(value);
                        }
                    }

                    possibleValuesForEachCell.add(possibleValues);

                    // Affichage des valeurs possibles pour cette case
                    System.out.println("Case (" + i + ", " + j + ") - Valeurs possibles : " + possibleValues);
                }
            }
        }

       
    }



    // Vérifie si la grille de Sudoku est valide

    public boolean isValidSudoku() {

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
    
                // Restaurer la valeur originale
                board.setCell(x, y, originalValue);
        
                if (!isValid) {
                    return false; 
                }
            }
        }
        return true; // La grille est valide
    }
    
        

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


            
    Integer[][] p= {
        {5, 1, 6, 8, 4, 9, 7, 3, 2},
	    {3, 0, 7, 6, 0, 5, 0, 0, 0},
	    {8, 0, 9, 7, 0, 0, 0, 6, 5},
	    {1, 3, 5, 0, 6, 0, 9, 0, 7},
	    {4, 7, 2, 5, 9, 1, 0, 0, 6},
	    {9, 6, 8, 3, 7, 0, 0, 5, 0},
	    {2, 5, 3, 1, 8, 6, 0, 7, 4},
	    {6, 8, 4, 2, 0, 7, 5, 0, 0},
	    {7, 9, 1, 0, 5, 0, 6, 0, 0}};

        Integer[][] pozz = {
            {1,3,0,0,0,2,0,7,0},
            {0,0,4,0,0,0,0,0,0},
            {8,0,0,4,0,0,2,0,1},
            {0,4,2,0,0,0,0,0,0},
            {5,0,0,7,0,6,0,0,9},
            {0,0,0,0,0,0,6,2,0},
            {4,0,9,0,0,1,0,0,6},
            {0,0,0,0,0,0,5,0,0},
            {0,5,0,9,0,0,0,3,2}
        };
        Integer[][] puzzle3 = {
        };
        
        GameBoard<Integer> board = new IntegerBoard<>(puzzle);
        SudokuSolver solver = new SudokuSolver(board);
        
        
        // Résolution du puzzle
        solver.solve();
        // board.setCell(0, 2, 8);
        //  board.display();


        // System.out.println ;

        // Affichage de la solution
        solver.solve();

    }
    
}
