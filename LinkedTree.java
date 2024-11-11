import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree implements Tree<IntegerBoard> {
    private Node root;

    public LinkedTree(IntegerBoard initialBoard) {
        this.root = new Node(initialBoard, null);
    }

    @Override
    public Position<IntegerBoard> root() {
        return root;
    }

    @Override
    public Position<IntegerBoard> parent(Position<IntegerBoard> p) {
        return ((Node) p).getParent();
    }

    @Override
    public Iterable<Position<IntegerBoard>> children(Position<IntegerBoard> p) {
        List<Position<IntegerBoard>> positions = new ArrayList<>();
        for (Node child : ((Node) p).getChildren()) {
            positions.add(child);
        }
        return positions;
    }

    @Override
    public int numChildren(Position<IntegerBoard> p) {
        return ((Node) p).getChildren().size();
    }

    @Override
    public boolean isInternal(Position<IntegerBoard> p) {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<IntegerBoard> p) {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<IntegerBoard> p) {
        return p == root;
    }

    @Override
    public int size() {
        return calculateSize(root);
    }

    private int calculateSize(Node node) {
        int size = 1;
        for (Node child : node.getChildren()) {
            size += calculateSize(child);
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<IntegerBoard> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<IntegerBoard>> positions() {
        return preorder();
    }

    private Iterable<Position<IntegerBoard>> preorder() {
        List<Position<IntegerBoard>> snapshot = new ArrayList<>();
        preorderSubtree(root, snapshot);
        return snapshot;
    }

    private void preorderSubtree(Node node, List<Position<IntegerBoard>> snapshot) {
        snapshot.add(node);
        for (Node child : node.getChildren()) {
            preorderSubtree(child, snapshot);
        }
    }

    private class ElementIterator implements Iterator<IntegerBoard> {
        Iterator<Position<IntegerBoard>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public IntegerBoard next() {
            return posIterator.next().getElement();
        }
    }
}
