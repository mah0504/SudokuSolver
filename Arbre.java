import java.util.Iterator;

public class Arbre<E> implements Tree<E> {
    private Noeud racine;

    // Constructeur qui prend un Noeud initial comme racine
    public Arbre(Noeud racine) {
        this.racine = racine;
    }

    // Accesseur pour obtenir la racine de l'arbre
    public Noeud getRacine() {
        return racine;
    }


    @Override
    public Position root() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'root'");
    }

    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parent'");
    }

    @Override
    public Iterable children(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'children'");
    }

    @Override
    public int numChildren(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numChildren'");
    }

    @Override
    public boolean isInternal(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInternal'");
    }

    @Override
    public boolean isExternal(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExternal'");
    }

    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRoot'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Iterable positions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positions'");
    }
    
}
