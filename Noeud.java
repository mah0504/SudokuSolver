public class Noeud implements Position {
    
    private IntegerBoard board;  // Référence au IntegerBoard

    // Constructeur qui prend un IntegerBoard
    public Noeud(IntegerBoard board) {
        this.board = board;
    }

    public IntegerBoard getBoard() {
        return board;
    }



    // modif les erreurs 
    @Override
    public Object getElement() throws IllegalStateException {
        throw new UnsupportedOperationException("Unimplemented method 'getElement'");
    }




    
}
