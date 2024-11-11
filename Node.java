import java.util.ArrayList;
import java.util.List;

public class Node implements Position<IntegerBoard> {
    private IntegerBoard board;  // État de la grille pour ce nœud
    private Node parent;

    
    private List<Node> children;

    public Node(IntegerBoard board, Node parent) {
        this.board = board;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    @Override
    public IntegerBoard getElement() {
        return board;
    }
    

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }
}
