import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Stack;

public class SudokuSolver implements GameSolver {
    // Attributs
    private IntegerBoard board;       
    private IntegerBoard solution;    
    private LinkedTree dsTree;  


    public SudokuSolver(){}

    public SudokuSolver(GameBoard<Integer> board) {

            this.board = (IntegerBoard) board;  
            this.dsTree = new LinkedTree(this.board);  
            
    }
    
    public void printSolution(){

        // if (solution != null) {
        //     solution.display();      
        // } else {
        //     System.out.println("No solution found.");
        // }
    
    }



    public boolean solve() {
    

        if (solveBoard()) { 
            System.out.println("Solution trouvée !");
            return true;
        } else {
            System.out.println(":(  pas de solution ");
            return false;
        }
    }
    

private boolean solveBoard() {


    // verifier si le sudoku est valide de base 
    // puis algo de resolution 

    // System.out.println(isValidSudoku(board));  
    // verif initiale de la grille 

    if (!isValidSudoku(board)) {
        return false; 
    }

    dsTree = new LinkedTree(board);
    Node currentNode = new Node(board, null); 

    int row = 0;
    int col = 0;

    Stack<StackElement> pile = new Stack<>(); 
    // System.out.println(getPossibleValues(board,  0, 2)) ;

    while ( row < board.getHeight()) {

            if (board.getCell(row, col).equals(0)) { 

                List<Integer> possibleValues = getPossibleValues(row, col, board);  
                // prendre le dernier ? 


                if (!possibleValues.isEmpty()) {
                    // pop le dernier element de possible values 
                    // le mettre sur la grille et initialiser un noeud enfant avec cette grille modifiee 
                    // ajouter a la pile 


                    Integer val = possibleValues.remove(possibleValues.size()-1); // derniere valeur :( 
                    // update la grille 

                    IntegerBoard childBoard = currentNode.getElement().copy();

                    childBoard.setCell(row, col, val);


                    Node childNode = new Node(childBoard, currentNode);
                    currentNode.addChild(childNode);


                    pile.push(new StackElement(row, col, possibleValues)); 
                    // nv etat ajouté à la pile
                    
                    currentNode = childNode;
                    if (isComplete(childBoard) && isValidSudoku(childBoard)) {
                        solution = childBoard; // Met à jour la solution
                        return true; // Une solution a été trouvée
                    }
                    

                    // col++;
                    // if (col == board.getWidth()) {
                    //     col = 0;
                    //     row++;
                    // }
                    // if (col == board.getWidth()) {
                    //     col = 0;
                    //     row++;
                    // }
                  


                } else {

                    Boolean contradictionAnnulee = false;
                    while (!contradictionAnnulee) { 

                        StackElement lastElement = pile.pop(); // enlever contradiction 
                        currentNode = currentNode.getParent(); // Retour au parent
                        possibleValues = lastElement.getPossibleValues(); // possible vaues du parent   
                        int var =possibleValues.remove(possibleValues.size()-1);
                        
                        pile.push(lastElement);

                        if (!possibleValues.isEmpty()) {
                            contradictionAnnulee = true;
                            


                            row = lastElement.getX(); //update les coordonnees dans la boucle 
                            col = lastElement.getY();

                            board.setCell(row, col, var); 

                        } 

                        // possibleValues.remove(possibleValues.size()-1);

                    

                        // board.setCell(lastElement.getX(), lastElement.getY(), 
                        //  possibleValues.remove(possibleValues.size()-1)); 


                        // extraire le dernier element si possible values n'est pas vide et essayer 
                        // nv etat de la grille ? 

                    }
                    
            }


                
            }

            // pp la pile , voir si le noeud correspondant a cette modifi de la pile de la coord
            // onnee x,y contient une contradiction 
            // si oui on pop , on voit l'elem de la pile d'avant qui a cause la contradiction  , on supprime 
            // le noeud enfant avec la contradiction de l'arbre 
            // on insere dans la grille une autre possibilite de possiblevalues correspondante 
            // on push dans la grille le nv choix et on ajoute un nv noeud 
            // etc 
            // si la pile vide = pas de solution 
            // si grille complete ( on ne trv pas de cell (x, y )==0 ) et qu'elle ne contient pas 
            // de contradiction alors on a finit par trv la solution 
            // on prend le dernier neoud de l'arbre avec la solution 
            // on print solution apres avoir instancie 
        
    } 
    
    return false; 

}



/**
 * Calcule et retourne les valeurs possibles qui peuvent être placées dans une cellule
 * donnée d'une grille Sudoku sans enfreindre les règles du jeu.
 *
 * @param board la grille Sudoku actuelle sous forme de {@code IntegerBoard}.
 * @param row l'indice de la ligne de la cellule à évaluer (commençant à 0).
 * @param cols l'indice de la colonne de la cellule à évaluer (commençant à 0).
 * @return une liste d'entiers représentant les valeurs valides (entre 1 et 9) 
 *         qui peuvent être placées dans la cellule spécifiée. Retourne une liste vide 
 *         si aucune valeur n'est valide ou si la cellule n'est pas vide.
 */
public List<Integer> getPossibleValues(  int row , int cols,IntegerBoard board ){
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
    
 public boolean isComplete(IntegerBoard board) {

    for (int row = 0; row < board.getHeight(); row++) {
        for (int col = 0; col < board.getWidth(); col++) {
            if (board.getCell(row, col).equals(0)) { 
                return false;
            }
        }
    }


    // Vérifier les lignes, colonnes et sous-grilles
    return isValidSudoku(board);

}




public boolean isValidSudoku(GameBoard<Integer> board) {
    for (int row = 0; row < board.getHeight(); row++) {
        for (int col = 0; col < board.getWidth(); col++) {
            Integer currentValue = board.getCell(row, col);
            
            // Ignorer les cellules vides
            if (currentValue != 0) {
                // Retirer temporairement la valeur de la cellule pour vérifier la validité
                board.setCell(row, col, 0);
                boolean isValid = isValidPlacement( row, col, currentValue);
                // Restaurer la valeur originale
                board.setCell(row, col, currentValue);

                if (!isValid) {
                    return false; // Contradiction détectée
                }
            }
        }
    }
    return true; // Aucune contradiction détectée
}




// marche correctement normalement
/**
 * Vérifie si une valeur peut être placée dans une cellule spécifique de la grille Sudoku 
 * sans enfreindre les règles du jeu (pas de doublon dans la ligne, la colonne et la sous-grille 3x3).
 *
 * @param row l'indice de la ligne où l'on souhaite placer la valeur (commençant à 0).
 * @param col l'indice de la colonne où l'on souhaite placer la valeur (commençant à 0).
 * @param value la valeur à tester pour la cellule spécifiée (comprise entre 1 et 9).
 * @return {@code true} si la valeur peut être placée dans la cellule spécifiée sans violation des règles,
 *         {@code false} si la valeur est déjà présente dans la même ligne, colonne ou sous-grille.
 */
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