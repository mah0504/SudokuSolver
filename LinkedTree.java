import java.util.Iterator;
import java.util.List;

public class LinkedTree<E>  extends AbstractTree<E> {

     //code issu des ndc pr utiliser des noeuds
     protected static class Node<E> implements Position<E> {
        private E element; // element stored in this node
        private Node<E> parent; // reference to parent node, if any

        private List<Node<E>> children; // liste des enfants
        private Object container; // reference to the node's container
        // construct a node with element and neighbors
        public Node( E e, Node<E> parent, List<Node<E>> children, Object container ) {
            this.element = e;
            this.parent = parent;
            this.children=children;
            this.container = container;
        }
        // getters
        public E getElement() { return this.element; }
        public Node<E> getParent() { return this.parent; }

        public Object getContainer() { return this.container; }
        // setters

    
    
}

    @Override
    public Position<E> root() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'root'");
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parent'");
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'children'");
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numChildren'");
    }

    @Override
    public int size() {

        // compter le nbr de noeuds, kinda irrelevant rn ? 
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
}