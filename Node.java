import java.util.ArrayList;
import java.util.List;

public class Node implements Position<IntegerBoard> {
    private IntegerBoard board;  // État de la grille pour ce nœud
    private Node parent;         // Référence au parent de ce nœud
    private List<Node> children; // Liste des enfants de ce nœud

    // Constructeur principal
    public Node(IntegerBoard board, Node parent) {
        this.board = board;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    // Méthode requise par l'interface Position
    @Override
    public IntegerBoard getElement() {
        return board;
    }

    // Obtenir le parent de ce nœud
    public Node getParent() {
        return parent;
    }

    // Définir le parent de ce nœud
    public void setParent(Node parent) {
        this.parent = parent;
    }

    // Obtenir la liste des enfants
    public List<Node> getChildren() {
        return children;
    }

    // Ajouter un enfant à ce nœud
    public void addChild(Node child) {
        children.add(child);
        child.setParent(this); // Assurer que l'enfant connaît son parent
    }

    // Supprimer un enfant spécifique
    public void removeChild(Node child) {
        children.remove(child);
    }

    // Vérifier si ce nœud a des enfants
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    // Supprimer tous les enfants
    public void clearChildren() {
        children.clear();
    }

    // Représentation textuelle pour faciliter le débogage
    @Override
    public String toString() {
        return "Node{" +
               "board=" + board +
               ", parent=" + (parent != null ? "Present" : "Null") +
               ", childrenCount=" + children.size() +
               '}';
    }
}
